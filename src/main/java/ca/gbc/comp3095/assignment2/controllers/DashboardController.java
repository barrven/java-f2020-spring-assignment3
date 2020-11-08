package ca.gbc.comp3095.assignment2.controllers;

import ca.gbc.comp3095.assignment2.domain.User;
import ca.gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    private final UserRepository userRepository;

    public DashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/dashboard")
    public String loadDashboard() {
        return "client/dashboard";
    }

    @RequestMapping("/testtabs")
    public String test(){
        return "client/dashboard";
    }

    @RequestMapping(value = {"/tab1","/tab2","/tab3","/tab4"})
    public String responseUnderCTabs(){
        return "construction";
    }

}

