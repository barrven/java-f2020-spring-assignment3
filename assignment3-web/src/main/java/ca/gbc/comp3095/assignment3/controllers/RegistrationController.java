package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.Role;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.services.RoleService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final RoleService roleService;

    public RegistrationController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String initRegistration() {
        return "client/registration";
    }

    public Role findRole(Long id) {
        return this.roleService.findById(id);
    }

    @GetMapping("/registration")
    public String initCreateForm(ModelMap model) {
        User user = new User();
        model.put("user", user);
        return "client/registration";
    }

    @PostMapping("/registration")
    public String processCreationForm(Role role, @ModelAttribute @Valid User user, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()) {
            return "client/registration";
        } else {
            role = findRole((long) 2);
            role.addUser(user);
            user.addRole(role);
            this.userService.save(user);
            this.roleService.save(role);
            return "login";
        }
    }
}
