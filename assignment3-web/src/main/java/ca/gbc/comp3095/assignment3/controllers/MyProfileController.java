package ca.gbc.comp3095.assignment3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyProfileController {

    @RequestMapping(value = "/myprofile")
    public String myProfile(){
        return "client/myprofile";
    }
}
