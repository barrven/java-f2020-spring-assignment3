package ca.gbc.comp3095.assignment3.repositories;

import ca.gbc.comp3095.assignment3.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
