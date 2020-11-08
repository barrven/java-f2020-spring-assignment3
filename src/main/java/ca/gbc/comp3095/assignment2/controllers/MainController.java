package ca.gbc.comp3095.assignment2.controllers;

import ca.gbc.comp3095.assignment2.domain.User;
import ca.gbc.comp3095.assignment2.repositories.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    private final TestRepository testRepository; //acting as service layer - connection to DB


    public MainController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @RequestMapping(value = {"/", "", "/login"})
    public String initCreateForm(ModelMap model) {
        return "login";
    }



}
