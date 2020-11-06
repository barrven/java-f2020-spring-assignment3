package ca.gbc.comp3095.assignment2.bootstrap;

import ca.gbc.comp3095.assignment2.domain.Role;
import ca.gbc.comp3095.assignment2.domain.TestItem;
import ca.gbc.comp3095.assignment2.domain.User;
import ca.gbc.comp3095.assignment2.repositories.RoleRepository;
import ca.gbc.comp3095.assignment2.repositories.TestRepository;
import ca.gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    //default implementation of run method that is required by the interface
    //anything that implements this CommandLineRunner will invoke this run method behind the scenes
    @Override
    public void run(String... args) throws Exception {

        //instantiate in memory
        for (int i = 0; i < 10; i++){

            TestItem item = new TestItem("Hello I'm item "+(i+1));
            //call repository first, then repository adds to DB through the hibernate ORM
            testRepository.save(item);
        }

        Role admin = new Role("Admin");
        Role client = new Role("Client");
        Long adminId = admin.getId();
        Long clientId = client.getId();

        roleRepository.save(admin);
        roleRepository.save(client);

        User kevin = new User("Kevin", "Ufkes", "kevinufkes@gmail.com", "JeebaDeebs", "12345");
        User satan = new User("Satan", "Joe", "satanjoe@gmail.com", "LuciferSam", "54321");

        kevin.getRoles().add(admin);
        kevin.getRoles().add(client);
        satan.getRoles().add(client);

        userRepository.save(kevin);
        userRepository.save(satan);

        //make a note in the console
        System.out.println("Started in bootstrap...");
        System.out.println("Roles of Kevin: " + kevin.getRoles());
        System.out.println("number of Roles: " + roleRepository.count());
    }
}