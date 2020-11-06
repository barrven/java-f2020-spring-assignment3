package ca.gbc.comp3095.assignment2.bootstrap;

import ca.gbc.comp3095.assignment2.domain.TestItem;
import ca.gbc.comp3095.assignment2.repositories.TestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//this is going to be a managed bean by the spring container. spring container will manage the instantiation of this class
public class BootstrapData implements CommandLineRunner {

    private final TestRepository testRepository;

    //instantiate a new bootstrap data object with these specific data members assigned
    //constructor injection
    public BootstrapData(TestRepository testRepository) {
        this.testRepository = testRepository;
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


        //make a note in the console
        System.out.println("Started in bootstrap...");
    }
}