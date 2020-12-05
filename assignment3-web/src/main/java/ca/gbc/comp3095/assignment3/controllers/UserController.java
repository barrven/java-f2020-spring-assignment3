/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment:  Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: Creates new Users from registration.html. Saves new users to database and links new users to Role: "Client".
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.Role;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.repositories.RoleRepository;
import ca.gbc.comp3095.assignment3.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    public String processCreationForm(Role role, @ModelAttribute @Valid User user, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()) {
            return "client/registration";
        } else {
            role = findRole((long) 2);
            role.addUser(user);
            user.addRole(role);
            this.userRepository.save(user);
            this.roleRepository.save(role);
            return "login";
        }
    }
}
