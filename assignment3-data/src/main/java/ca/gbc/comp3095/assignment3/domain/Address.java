package ca.gbc.comp3095.assignment3.domain;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name="owner_id")
    private Long id;

    @Column(name="addres")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="province")
    private String province;

    @Column(name="country")
    private String country;

    @Column(name="is_default_shipping")
    private boolean isDefaultShipping;

    @Column(name="is_default_billing")
    private boolean isDefaultBilling;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Address() {
    }

    public Address(String address, String city, String province, String country) {
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isDefaultShipping() {
        return isDefaultShipping;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDefaultShipping(boolean defaultShipping) {
        isDefaultShipping = defaultShipping;
    }

    public boolean isDefaultBilling() {
        return isDefaultBilling;
    }

    public void setDefaultBilling(boolean defaultBilling) {
        isDefaultBilling = defaultBilling;
    }

}
