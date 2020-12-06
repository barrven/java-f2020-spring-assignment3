package ca.gbc.comp3095.assignment3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/registration")
    public String initRegistration() {
        return "client/registration";
    }
}
