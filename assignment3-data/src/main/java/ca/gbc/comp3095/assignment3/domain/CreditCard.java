package ca.gbc.comp3095.assignment3.domain;


import javax.persistence.*;
import java.util.Date;


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
    private Date expirationDate;

    @Column(name="card_holder_name")
    private String cardHolderName;

    @Column(name="card_number")
    private int cardNumber;

    @Column(name="default")
    private boolean defaultCard;

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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isDefaultCard() {
        return defaultCard;
    }

    public void setDefaultCard(boolean defaultCard) {
        this.defaultCard = defaultCard;
    }
}
