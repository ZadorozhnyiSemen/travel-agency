package com.epam.travel.model;

public class User {
    private int id;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private boolean loyalty;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isLoyalty() {
        return loyalty;
    }

    public void setLoyalty(boolean loyalty) {
        this.loyalty = loyalty;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", loyalty=" + loyalty +
                '}';
    }
}
