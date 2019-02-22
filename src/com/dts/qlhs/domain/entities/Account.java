package com.dts.qlhs.domain.entities;

import com.dts.qlhs.connection.DBConnection;

public class Account {
	private int accId;
	private String accName;
	private String accPass;
	private String accEmail;
	private int role;
	private String token;
	private static Account Instance = null;

	public static Account getInstence() {
		if (Instance == null) {
			Instance = new Account();
		}
		return Instance;
	}

	

	private Account() {
		super();
	}

	public int getAccId() {
		return accId;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccPass() {
		return accPass;
	}

	public void setAccPass(String accPass) {
		this.accPass = accPass;
	}

	public String getAccEmail() {
		return accEmail;
	}

	public void setAccEmail(String accEmail) {
		this.accEmail = accEmail;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Account(int accId, String accName, String accPass, String accEmail, int role, String token) {
		super();
		this.accId = accId;
		this.accName = accName;
		this.accPass = accPass;
		this.accEmail = accEmail;
		this.role = role;
		this.token = token;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accName=" + accName + ", accPass=" + accPass + ", accEmail=" + accEmail
				+ ", role=" + role + ", token=" + token + "]";
	}

}
