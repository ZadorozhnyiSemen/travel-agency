package com.epam.travel.model;

public class Hotel {
    private int id;
    private String country;
    private String city;
    private String address;
    private String phone;
    private short rank;

    public Hotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public short getRank() {
        return rank;
    }

    public void setRank(short rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", rank=" + rank +
                '}';
    }
}
