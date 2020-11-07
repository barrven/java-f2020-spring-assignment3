package ca.gbc.comp3095.assignment2.controllers;

import ca.gbc.comp3095.assignment2.domain.Greeting;
import ca.gbc.comp3095.assignment2.repositories.GreetingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class

TestController {

//    private final GreetingRepository greetingRepository; //acting as service layer - connection to DB

//    public TestController(GreetingRepository greetingRepository) {
//        this.greetingRepository = greetingRepository;
//    }
//
//    @GetMapping("/greeting")
//    public String greetingForm(Model model) {
//        model.addAttribute("greeting", new Greeting());
//        return "tests/greeting";
//    }
//
//    @PostMapping("/greeting")
//    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
//        model.addAttribute("greeting", greeting);
//
//        greetingRepository.save(greeting);
//        return "tests/result";
//    }
//
//    @RequestMapping("/view-greetings")
//    public String getGreetings(Model model){
//        model.addAttribute("items", greetingRepository.findAll());
//
//        return "testing";
//    }
//
//    @RequestMapping("/test/login")
//    public String response(Model model){
//        return "login";
//    }
}