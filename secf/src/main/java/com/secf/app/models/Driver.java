package com.secf.app.models;

public class Driver {
	
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
	int uid;
	String name;
	long phone;
	String pickupAdd;
	String dropAdd;
	String upiId;
	String bankingName; // in case of settlement
	String vehicleNumber;
	String drivingLiscenceNumber;
	String adharNumber;
	String panNumber;
	String email;
	String password;
	
	public Driver(int uid, String name, long phone, String pickupAdd, String dropAdd, String upiId, String bankingName,
			String vehicleNumber, String drivingLiscenceNumber, String adharNumber, String panNumber, String email, String password) {
		this.uid = uid;
		this.name = name;
		this.phone = phone;
		this.pickupAdd = pickupAdd;
		this.dropAdd = dropAdd;
		this.upiId = upiId;
		this.bankingName = bankingName;
		this.vehicleNumber = vehicleNumber;
		this.drivingLiscenceNumber = drivingLiscenceNumber;
		this.adharNumber = adharNumber;
		this.panNumber = panNumber;
		this.email = email;
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPickupAdd() {
		return pickupAdd;
	}
	public void setPickupAdd(String pickupAdd) {
		this.pickupAdd = pickupAdd;
	}
	public String getDropAdd() {
		return dropAdd;
	}
	public void setDropAdd(String dropAdd) {
		this.dropAdd = dropAdd;
	}
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public String getBankingName() {
		return bankingName;
	}
	public void setBankingName(String bankingName) {
		this.bankingName = bankingName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getDrivingLiscenceNumber() {
		return drivingLiscenceNumber;
	}
	public void setDrivingLiscenceNumber(String drivingLiscenceNumber) {
		this.drivingLiscenceNumber = drivingLiscenceNumber;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
}
