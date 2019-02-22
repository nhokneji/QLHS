package com.dts.qlhs.domain.entities;

public class HocSinh {
	private int hocSinhId;
	private String hocSinhName;
	private int hocSinhBirthDay;
	private String hocSinhClass;
	

	private static HocSinh Instance = null;
	public static HocSinh getInstence() {
		if (Instance == null) {
			Instance = new HocSinh();
		}
		return Instance;
	}
	
	private HocSinh() {
	}
	
	public HocSinh(int hocSinhId, String hocjSinhName, int hocSinhBirthDay2, String hocSinhClass) {
		super();
		this.hocSinhId = hocSinhId;
		this.hocSinhName = hocjSinhName;
		this.hocSinhBirthDay = hocSinhBirthDay2;
		this.hocSinhClass = hocSinhClass;
	}

	public int getHocSinhId() {
		return hocSinhId;
	}
	public void setHocSinhId(int hocSinhId) {
		this.hocSinhId = hocSinhId;
	}
	public String getHocSinhName() {
		return hocSinhName;
	}
	public void setHocSinhName(String hocjSinhName) {
		this.hocSinhName = hocjSinhName;
	}
	public int getHocSinhBirthDay() {
		return hocSinhBirthDay;
	}
	public void setHocSinhBirthDay(int hocSinhBirthDay) {
		this.hocSinhBirthDay = hocSinhBirthDay;
	}
	public String getHocSinhClass() {
		return hocSinhClass;
	}
	public void setHocSinhClass(String hocSinhClass) {
		this.hocSinhClass = hocSinhClass;
	}
	
	
	@Override
	public String toString() {
		return "HocSinh [hocSinhId=" + hocSinhId + ", hocjSinhName=" + hocSinhName + ", hocSinhBirthDay="
				+ hocSinhBirthDay + ", hocSinhClass=" + hocSinhClass + "]";
	}
	
	
	
	
	
}
