package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.Address;
import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import ca.gbc.comp3095.assignment3.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ca.gbc.comp3095.assignment3.services.UserService;
import ca.gbc.comp3095.assignment3.services.AddressService;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class MyProfileController {

    private final UserService userService;
    private final AddressService addressService;

    public MyProfileController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @RequestMapping(value = "/myprofile")
    public String myProfile(User tempUser, Model model){
        Address address = new Address();
        tempUser = userService.findByUsername("client@isp.net");
        model.addAttribute("addresses", tempUser.getAddresses());
        model.addAttribute("address", address);
        return "client/myprofile";
    }

    @PostMapping("/myprofile")
    public String processCreationForm(User tempUser, @ModelAttribute @Valid Address address, BindingResult br, ModelMap model) {
        if(br.hasErrors()) {
            return "client/dashboard";
        } else {
            tempUser = userService.findByUsername("client@isp.net");
            address.setUser(tempUser);
            addressService.save(address);
            userService.save(tempUser);
            return "client/dashboard";
        }
    }
}
