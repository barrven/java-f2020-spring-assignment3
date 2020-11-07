package ca.gbc.comp3095.assignment2.controllers;

import ca.gbc.comp3095.assignment2.repositories.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/testtabs")
    public String test(){
        return "client/dashboard";
    }

    @RequestMapping(value = {"/tab1","/tab2","/tab3","/tab4"})
    public String responseUnderCTabs(){
        return "construction";
    }

}

