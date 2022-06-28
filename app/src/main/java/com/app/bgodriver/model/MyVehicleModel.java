package com.app.bgodriver.model;

public class MyVehicleModel {
    int myVehicleImage;
    String myVehicleModel,myVehicleNumber;

    public MyVehicleModel(int myVehicleImage, String myVehicleModel, String myVehicleNumber) {
        this.myVehicleImage = myVehicleImage;
        this.myVehicleModel = myVehicleModel;
        this.myVehicleNumber = myVehicleNumber;
    }

    public int getMyVehicleImage() {
        return myVehicleImage;
    }

    public void setMyVehicleImage(int myVehicleImage) {
        this.myVehicleImage = myVehicleImage;
    }

    public String getMyVehicleModel() {
        return myVehicleModel;
    }

    public void setMyVehicleModel(String myVehicleModel) {
        this.myVehicleModel = myVehicleModel;
    }

    public String getMyVehicleNumber() {
        return myVehicleNumber;
    }

    public void setMyVehicleNumber(String myVehicleNumber) {
        this.myVehicleNumber = myVehicleNumber;
    }
}
