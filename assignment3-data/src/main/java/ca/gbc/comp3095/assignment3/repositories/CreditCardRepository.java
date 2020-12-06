package ca.gbc.comp3095.assignment3.repositories;

import ca.gbc.comp3095.assignment3.domain.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
}
