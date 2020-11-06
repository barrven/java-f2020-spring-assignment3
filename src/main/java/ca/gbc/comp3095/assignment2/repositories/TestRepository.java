package ca.gbc.comp3095.assignment2.repositories;

import ca.gbc.comp3095.assignment2.domain.TestItem;
import org.springframework.data.repository.CrudRepository;

//generic declaration specifies the object that the repository will be working with - like typecasting
//also specifies the datatype of its pk
public interface TestRepository extends CrudRepository<TestItem, Long>{

}
