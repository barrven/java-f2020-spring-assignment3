package ca.gbc.comp3095.assignment3.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private User user;

    @Column(name="type")
    private String type;

    @Column(name="expiration_date")
    private LocalDate expirationDate;

    @Column(name="card_holder_name")
    private String cardHolderName;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="default")
    private boolean defaultCard;

    public CreditCard() {
    }

    public CreditCard(User user, String type, LocalDate expirationDate, String cardHolderName, String cardNumber, boolean defaultCard) {
        this.user = user;
        this.type = type;
        this.expirationDate = expirationDate;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.defaultCard = defaultCard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isDefaultCard() {
        return defaultCard;
    }

    public void setDefaultCard(boolean defaultCard) {
        this.defaultCard = defaultCard;
    }
}
