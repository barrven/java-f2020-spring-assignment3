package ca.gbc.comp3095.assignment2.bootstrap;

import ca.gbc.comp3095.assignment2.domain.Role;
import ca.gbc.comp3095.assignment2.domain.TestItem;
import ca.gbc.comp3095.assignment2.domain.User;
import ca.gbc.comp3095.assignment2.repositories.RoleRepository;
import ca.gbc.comp3095.assignment2.repositories.TestRepository;
import ca.gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
//this is going to be a managed bean by the spring container. spring container will manage the instantiation of this class
public class BootstrapData implements CommandLineRunner {

    private final TestRepository testRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    //instantiate a new bootstrap data object with these specific data members assigned
    //constructor injection
    public BootstrapData(TestRepository testRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.testRepository = testRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public Role findRoleById(Long id) {
        return roleRepository.findById(id).get();
    }
    //default implementation of run method that is required by the interface
    //anything that implements this CommandLineRunner will invoke this run method behind the scenes
    @Override
    public void run(String... args) throws Exception {


        //instantiate in memory
//        for (int i = 0; i < 10; i++){
//
//            TestItem item = new TestItem("Hello I'm item "+(i+1));
//            //call repository first, then repository adds to DB through the hibernate ORM
//            testRepository.save(item);
//        }

//        User kevin = new User("Kevin", "Ufkes", "kevinufkes@gmail.com", "JeebaDeebs", "12345");
//        User satan = new User("Satan", "Joe", "satanjoe@gmail.com", "LuciferSam", "54321");
//
//        Role admin = new Role("Admin");
//        Role client = new Role("Client");
//        Role other = new Role("Other");
//
//        kevin.getRoles().add(admin);
//        admin.getUsers().add(kevin);
//        kevin.getRoles().add(client);
//        client.getUsers().add(kevin);
//        satan.getRoles().add(other);
//        other.getUsers().add(satan);
//        userRepository.save(satan);
//        userRepository.save(kevin);
//        roleRepository.save(other);
//        roleRepository.save(admin);
//        roleRepository.save(client);
//
//
////        make a note in the console
//        System.out.println("Started in bootstrap...");
////        System.out.println("Roles of Kevin: " + kevin.getRoles().toString());
//        System.out.println("number of Roles: " + roleRepository.count());
//        System.out.println(userRepository.findById(Long.parseLong("1")));
    }
}