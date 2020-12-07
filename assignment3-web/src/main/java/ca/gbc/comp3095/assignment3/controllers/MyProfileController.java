package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ca.gbc.comp3095.assignment3.services.UserService;
import ca.gbc.comp3095.assignment3.services.AddressService;

@Controller
public class MyProfileController {

    private final UserService userService;

    public MyProfileController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/myprofile")
    public String myProfile(User tempUser, Model model){
        tempUser = userService.findByUsername("client@isp.net");
        model.addAttribute("addresses", tempUser.getAddresses());
        return "client/myprofile";
    }
}
