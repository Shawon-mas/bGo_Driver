package com.app.bgodriver.model;

public class DriverModel {
    String name,licenceNo,expireDate,phoneNumber,address,verified;
    int img;

    public DriverModel() {
    }

    public DriverModel(String name, String licenceNo, String expireDate, String phoneNumber, String address, String verified, int img) {
        this.name = name;
        this.licenceNo = licenceNo;
        this.expireDate = expireDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.verified = verified;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
