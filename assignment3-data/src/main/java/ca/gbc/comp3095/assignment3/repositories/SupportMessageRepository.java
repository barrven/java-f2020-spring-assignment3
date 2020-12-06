package ca.gbc.comp3095.assignment3.repositories;

import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import org.springframework.data.repository.CrudRepository;

public interface SupportMessageRepository extends CrudRepository<SupportMessage, Long> {
}
