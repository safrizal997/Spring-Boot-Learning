package com.rizal.belajarspring.entity;

import javax.persistence.*;

@Entity
@Table (name = "costumers_tbl")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costumer_id", nullable = false)
    private Integer costumerId;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "cardnumber", length = 16)
    private String cardNumber;

    @Column(name = "handphone", length = 20)
    private String handPhone;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer costumerId, String email, String userName, String cardNumber, String handPhone) {
        this.costumerId = costumerId;
        this.email = email;
        this.userName = userName;
        this.cardNumber = cardNumber;
        this.handPhone = handPhone;
    }

    public Integer getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Integer costumerId) {
        this.costumerId = costumerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHandPhone() {
        return handPhone;
    }

    public void setHandPhone(String handPhone) {
        this.handPhone = handPhone;
    }
}
