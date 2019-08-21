package com.exampl.nabda.Classes;

public class DrData {

    private String name;
    private String specialty;
    private String address;
    private String phone;
    private String date;
    private int price;



    public DrData() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public DrData(String name, String specialty, String address, String phone, int price, String date) {
        this.name = name;
        this.specialty = specialty;
        this.address = address;
        this.phone = phone;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String Specialty) {
        this.specialty = Specialty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int Price) {
        this.price = Price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }
}

