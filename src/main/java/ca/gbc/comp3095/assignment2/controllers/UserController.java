package ca.gbc.comp3095.assignment2.controllers;

import ca.gbc.comp3095.assignment2.domain.Role;
import ca.gbc.comp3095.assignment2.domain.User;
import ca.gbc.comp3095.assignment2.repositories.RoleRepository;
import ca.gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Role findRole(Long id) {
        return this.roleRepository.findById(id).get();
    }

    @GetMapping("/registration")
    public String initCreateForm(ModelMap model) {
        User user = new User();
        model.put("user", user);
        return "client/registration";
    }

    @PostMapping("/registration")
    public String processCreationForm(Role role, @ModelAttribute User user, ModelMap model) {
        role = findRole((long)2);
        role.addUser(user);
        user.addRole(role);
        this.userRepository.save(user);
        this.roleRepository.save(role);
        return "client/dashboard";
    }

    @RequestMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "client/dashboard";
    }
}
