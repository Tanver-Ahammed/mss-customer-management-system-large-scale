package com.customer.management.entity;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

public class Customer {

    private long id;

    private String firstName;

    private String lastName;

    private String city;

    private String country;

    private String postCode;

    private String contact;

    private String email;

    private String ip;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public Customer() {
    }

    public Customer(String firstName, String lastName, String city,
                    String country, String postCode, String contact, String email, String ip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.contact = contact;
        this.email = email;
        this.ip = ip;
    }

    public Customer(long id, String firstName, String lastName, String city,
                    String country, String postCode, String contact, String email, String ip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.contact = contact;
        this.email = email;
        this.ip = ip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
