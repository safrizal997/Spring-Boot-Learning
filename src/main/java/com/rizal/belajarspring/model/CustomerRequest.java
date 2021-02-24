package com.rizal.belajarspring.model;

import javax.persistence.Column;

public class CustomerRequest {

    private String email;

    private String userName;

    private String cardNumber;

    private String handPhone;

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
