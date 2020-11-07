package ca.gbc.comp3095.assignment2.controllers;

import ca.gbc.comp3095.assignment2.domain.Greeting;
import ca.gbc.comp3095.assignment2.domain.Role;
import ca.gbc.comp3095.assignment2.domain.User;
import ca.gbc.comp3095.assignment2.repositories.RoleRepository;
import ca.gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository) { this.userRepository = userRepository; this.roleRepository = roleRepository; }
    Role client = new Role("Client");

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "client/registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("registration", user);
        user.getRoles().add(client);
        client.getUsers().add(user);
        userRepository.save(user);
        return "client/dashboard";
    }

    @RequestMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "client/dashboard";
    }
}
