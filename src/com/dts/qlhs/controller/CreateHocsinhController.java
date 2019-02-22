package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.domain.entities.HocSinh;
import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.service.HocSinhService;

public class CreateHocsinhController extends Handler {

	@Override
	public String doProcessGet(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doProcessPost(JSONObject params, String token) {
		HocSinh hs =  HocSinh.getInstence();
		HocSinhService hsService = new HocSinhService(BasicWebservice.dbConn);
		try {
			hs.setHocSinhName(params.get("sinhvien_name").toString());
			hs.setHocSinhBirthDay(Integer.parseInt(params.get("sinhvien_birthday").toString()));
			hs.setHocSinhClass(params.get("sinhien_class").toString());
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hsService.addHocSinh(hs);
	}

}
