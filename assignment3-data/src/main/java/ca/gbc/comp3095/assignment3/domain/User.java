/*******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: Defines User Class and Joins with Role class in Many-to-many relationship
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class User {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message="First Name must not be empty!")
    @Pattern(regexp = "^[A-Za-z]+$", message="Must be alphabetical")
    private String firstName;

    @NotNull(message="Last Name must not be empty!")
    @Pattern(regexp = "^[A-Za-z]+$", message="Must be alphabetical")
    private String lastName;

    @NotNull(message="Email must not be empty!")
    @Email(message="Must enter valid email!")
    private String email;

    @NotNull(message="Username must not be empty!")
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Password must contain at least: 1 uppercase, 1 lowercase, 1 number, 1 special character and must be at least 8 characters long!")
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<CreditCard> creditCards = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<SupportMessage> supportMessages = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Set<SupportMessage> getSupportMessages() {
        return supportMessages;
    }

    public void setSupportMessages(Set<SupportMessage> supportMessages) {
        this.supportMessages = supportMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
