package ca.gbc.comp3095.assignment2.repositories;

import ca.gbc.comp3095.assignment2.domain.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

}
