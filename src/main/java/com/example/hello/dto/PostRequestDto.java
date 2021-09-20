package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {
    private String account;
    private String email;
    private String password;
    private String address;
    //phone_number의 경우 자바에선 카멜케이스로 변수명을 적어주어서 null값으로 나온다.
    // -> jsonProperty로 매칭해주는 방법이 있다.
    @JsonProperty("phone_number")
    private String phoneNumber; //phone_number

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
