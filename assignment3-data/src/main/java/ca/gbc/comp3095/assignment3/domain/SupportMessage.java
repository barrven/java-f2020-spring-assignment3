package ca.gbc.comp3095.assignment3.domain;

import javax.persistence.*;

@Entity
@Table(name="support_messages")
public class SupportMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="subject")
    private String subject;

    @Column(name="message")
    private String message;

    public SupportMessage() {
    }

    public SupportMessage(User user, String subject, String message) {
        this.user = user;
        this.subject = subject;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
