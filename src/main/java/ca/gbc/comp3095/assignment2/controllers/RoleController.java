package ca.gbc.comp3095.assignment2.controllers;


import ca.gbc.comp3095.assignment2.domain.Role;
import ca.gbc.comp3095.assignment2.repositories.RoleRepository;
import ca.gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RoleController(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        Role admin = new Role("Admin");
        Role client = new Role("Client");
        roleRepository.save(admin);
        roleRepository.save(client);
    }
}
