package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.Address;
import ca.gbc.comp3095.assignment3.domain.Role;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.domain.UserWithAddress;
import ca.gbc.comp3095.assignment3.services.RoleService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminUserController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminUserController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @RequestMapping("/myprofile/admin")
    public String getAdminProfile(Model model){
        User user = userService.findByUsername("admin@isp.net");
        Set<Address> addresses = user.getAddresses();
        Address address = addresses.iterator().next();
        UserWithAddress userWithAddress = new UserWithAddress(
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            address.getPlace(),
            address.getCity(),
            address.getCountry()
        );
        model.addAttribute("user", user);
        model.addAttribute("address", address);
        model.addAttribute(userWithAddress);


        return "admin/myprofile";
    }


    @PostMapping("/myprofile/admin")
    public String processCreationForm(UserWithAddress userWithAddress) {
        User user = userService.findByUsername("admin@isp.net");
        user.setFirstName(userWithAddress.getFirstName());
        user.setLastName(userWithAddress.getLastName());
        user.setEmail(userWithAddress.getEmail());


        Set<Address> addresses = user.getAddresses();
        List<Address> addressList = new ArrayList<>(addresses);
        Address temp = addressList.get(0);
        temp.setPlace(userWithAddress.getAddress());
        temp.setCity(userWithAddress.getCity());
        temp.setCountry(userWithAddress.getCountry());
        addressList.set(0, temp);
        user.setAddresses(new HashSet<>(addressList));

        this.userService.save(user);

        return "admin/myprofile";
    }

    @RequestMapping("/admin/users-listing")
    public String getAdminUsersListing(Model model){
        return "admin/construction";
    }

    @RequestMapping("/admin/users")
    public String getAdminUsers(Model model){
        return "admin/admin-users-crud";
    }

    @RequestMapping("/admin/inbox")
    public String getAdminUsersInbox(Model model){
        return "admin/construction";
    }

}
