package com.secf.app.models;

public class User {
	int uid;
	String name;
	long phone;
	String pickupAdd;
	String dropAdd;
	String upiId;
	String bankingName; // in case of refunds
	
	public User(int uid, String name, long phone, String pickupAdd, String dropAdd, String upiId, String bankingName) {
		this.uid = uid;
		this.name = name;
		this.phone = phone;
		this.pickupAdd = pickupAdd;
		this.dropAdd = dropAdd;
		this.upiId = upiId;
		this.bankingName = bankingName;
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
	
	
}
