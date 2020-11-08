package ca.gbc.comp3095.assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    public MainController(){

    }

    @RequestMapping({"/","/login"})
    public String response(Model model){
        return "login";
    }

    @RequestMapping("/registration")
    public String initRegistration() {
        return "client/registration";
    }

}
