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

import ca.gbc.comp3095.assignment3.domain.*;
import ca.gbc.comp3095.assignment3.repositories.RoleRepository;
import ca.gbc.comp3095.assignment3.repositories.UserRepository;
import ca.gbc.comp3095.assignment3.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;

@Component
//this is going to be a managed bean by the spring container. spring container will manage the instantiation of this class
public class BootstrapData implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final CreditCardService creditCardService;
    private final SupportMessageService supportMessageService;
    private final AddressService addressService;


    //instantiate a new bootstrap data object with these specific data members assigned
    //constructor injection
    public BootstrapData(
            UserService userService,
            RoleService roleService,
            CreditCardService creditCardService,
            SupportMessageService supportMessageService,
            AddressService addressService) {
        this.userService = userService;
        this.roleService = roleService;
        this.creditCardService = creditCardService;
        this.supportMessageService = supportMessageService;
        this.addressService = addressService;
    }

    //default implementation of run method that is required by the interface
    //anything that implements this CommandLineRunner will invoke this run method behind the scenes
    @Override
    public void run(String... args) throws Exception {

        Role admin = new Role("Admin");
        Role client = new Role("Client");
        roleService.save(admin);
        roleService.save(client);

        User chuckNorris = new User("Chuck", "Norris", "admin@isp.net", "admin@isp.net", "P@ssword1");
        User barry = new User("barry","trombone", "client@isp.net", "client@isp.net", "P@ssword1");
        userService.save(chuckNorris);
        userService.save(barry);

        CreditCard card1 = new CreditCard(barry, "Visa", LocalDate.now(), "Barry Trombone", "1111222233334444", true);
        card1.setUser(barry);
        creditCardService.save(card1);

        SupportMessage sMessage1 = new SupportMessage();
        sMessage1.setUser(barry);
        sMessage1.setSubject("Springboot being fun");
        sMessage1.setMessage("Hello, I don't need support I just want to say how much fun I think SpringBoot is!!");
        supportMessageService.save(sMessage1);

        Address address1 = new Address();
        address1.setFirstName("John");
        address1.setLastName("Doe");
        address1.setEmail("johndoe@gmail.com");
        address1.setAddress("123 Real Blvd.");
        address1.setCity("Toronto");
        address1.setProvince("Ontario");
        address1.setCountry("Canada");
        address1.setDefaultBilling(true);
        address1.setDefaultShipping(false);
        address1.setUser(barry);
        addressService.save(address1);

        Address address2 = new Address();
        address2.setFirstName("John");
        address2.setLastName("Doe");
        address2.setEmail("johndoe@gmail.com");
        address2.setAddress("123 Fake Blvd.");
        address2.setCity("Peterborough");
        address2.setProvince("Ontario");
        address2.setCountry("Canada");
        address2.setDefaultBilling(false);
        address2.setDefaultShipping(true);
        address2.setUser(barry);
        addressService.save(address2);

        admin.getUsers().add(chuckNorris);
        client.getUsers().add(barry);
        chuckNorris.getRoles().add(admin);
        barry.getRoles().add(client);

        userService.save(chuckNorris);
        userService.save(barry);
        roleService.save(admin);
        roleService.save(client);

        System.out.println(chuckNorris.getFirstName() + " " + chuckNorris.getLastName() + " is a(n) " + admin.getTitle());
        System.out.println(barry.getFirstName() + " " + barry.getLastName() + " is a(n) " + client.getTitle());

    }
}