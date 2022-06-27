package com.app.bgodriver.model;

public class VehicleListModel {

    String vehicleName,vehicleStatus,vehicleNumber,vehicleColor,vehicleModel,vehicleSit,vehicleAirCondition;

    public VehicleListModel(String vehicleName, String vehicleStatus, String vehicleNumber, String vehicleColor, String vehicleModel, String vehicleSit, String vehicleAirCondition) {
        this.vehicleName = vehicleName;
        this.vehicleStatus = vehicleStatus;
        this.vehicleNumber = vehicleNumber;
        this.vehicleColor = vehicleColor;
        this.vehicleModel = vehicleModel;
        this.vehicleSit = vehicleSit;
        this.vehicleAirCondition = vehicleAirCondition;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleSit() {
        return vehicleSit;
    }

    public void setVehicleSit(String vehicleSit) {
        this.vehicleSit = vehicleSit;
    }

    public String getVehicleAirCondition() {
        return vehicleAirCondition;
    }

    public void setVehicleAirCondition(String vehicleAirCondition) {
        this.vehicleAirCondition = vehicleAirCondition;
    }
}
