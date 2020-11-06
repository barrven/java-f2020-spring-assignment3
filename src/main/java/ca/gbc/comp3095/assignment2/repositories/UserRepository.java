package ca.gbc.comp3095.assignment2.repositories;

import ca.gbc.comp3095.assignment2.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}