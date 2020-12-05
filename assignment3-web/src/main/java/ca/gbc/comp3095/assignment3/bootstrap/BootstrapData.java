/*******************************************************************************************
Project: COMP3095 Channel5NewsTeam
        * Assignment: Assignment # 2
        * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
        * Student Number: 101197364, 101189284, 101176085
        * Date: Sunday November 8, 2020
        * Description: Used to create database entries for pre-existing entities - Roles: Admin and Client
                                                                                  - User:  chuckNorris(admin) and barry(client)
                       Used for database testing
********************************************************************************************/


package ca.gbc.comp3095.assignment3.bootstrap;

import ca.gbc.comp3095.assignment3.domain.Role;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.repositories.RoleRepository;
import ca.gbc.comp3095.assignment3.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//this is going to be a managed bean by the spring container. spring container will manage the instantiation of this class
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    //instantiate a new bootstrap data object with these specific data members assigned
    //constructor injection
    public BootstrapData(UserRepository userRepository, RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    //default implementation of run method that is required by the interface
    //anything that implements this CommandLineRunner will invoke this run method behind the scenes
    @Override
    public void run(String... args) throws Exception {

        Role admin = new Role("Admin");
        Role client = new Role("Client");
        roleRepository.save(admin);
        roleRepository.save(client);

        User chuckNorris = new User("Chuck", "Norris", "admin@isp.net", "admin@isp.net", "P@ssword1");
        User barry = new User("barry","trombone", "client@isp.net", "client@isp.net", "P@ssword1");
        userRepository.save(chuckNorris);
        userRepository.save(barry);


        admin.getUsers().add(chuckNorris);
        client.getUsers().add(barry);
        chuckNorris.getRoles().add(admin);
        barry.getRoles().add(client);

        userRepository.save(chuckNorris);
        userRepository.save(barry);
        roleRepository.save(admin);
        roleRepository.save(client);

        System.out.println(chuckNorris.getFirstName() + " " + chuckNorris.getLastName() + " is a(n) " + admin.getTitle());
        System.out.println(barry.getFirstName() + " " + barry.getLastName() + " is a(n) " + client.getTitle());

    }
}