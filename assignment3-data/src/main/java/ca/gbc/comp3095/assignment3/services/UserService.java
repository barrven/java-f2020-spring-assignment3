package ca.gbc.comp3095.assignment3.services;

import ca.gbc.comp3095.assignment3.domain.User;

public interface UserService extends CRUDService<User, Long> {
    User findByUsername(String username);
}
