package ca.gbc.comp3095.assignment2.controllers;

import ca.gbc.comp3095.assignment2.repositories.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    private final TestRepository testRepository; //acting as service layer - connection to DB


    public MainController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
//
//    @RequestMapping("/testing")
//    public String response(Model model){
//
//        model.addAttribute("items", testRepository.findAll());
//
//        return "testing";
//    }
//
//    @RequestMapping("/testing2")
//    public String response2(Model model){
//        String[] items = {"abc", "def", "hij"};
//        model.addAttribute("items", items);
//
//        return "testing";
//    }




}
