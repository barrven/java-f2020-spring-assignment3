package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.services.RoleService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminUserController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminUserController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

}
