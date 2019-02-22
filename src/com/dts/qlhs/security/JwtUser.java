package com.dts.qlhs.security;

public class JwtUser {
	private int accId;
	private String accName;
	private String accPass;
	private int accRole;
	
	
	public int getAccId() {
		return accId;
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
	public int getAccRole() {
		return accRole;
	}
	public void setAccRole(int accRole) {
		this.accRole = accRole;
	}
	public JwtUser() {
		super();
	}

	public JwtUser(int accId, String accName, String accPass, int accRole) {
		super();
		this.accId = accId;
		this.accName = accName;
		this.accPass = accPass;
		this.accRole = accRole;
	}
	@Override
	public String toString() {
		return "JwtUser [accId=" + accId + ", accName=" + accName + ", accPass=" + accPass + ", accRole=" + accRole
				+ "]";
	}

	
	
}
