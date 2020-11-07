package ca.gbc.comp3095.assignment2.repositories;

import ca.gbc.comp3095.assignment2.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
