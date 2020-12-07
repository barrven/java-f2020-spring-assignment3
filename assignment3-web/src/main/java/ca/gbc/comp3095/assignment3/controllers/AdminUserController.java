package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.Address;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.services.RoleService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("user", user);
        model.addAttribute("address", address);


        return "admin/myprofile";
    }

    @RequestMapping("/admin/users-listing")
    public String getAdminUsersListing(Model model){
        return "admin/construction";
    }

    @RequestMapping("/admin/users")
    public String getAdminUsers(Model model){
        return "admin/construction";
    }

}
