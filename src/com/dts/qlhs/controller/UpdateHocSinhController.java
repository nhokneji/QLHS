package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.domain.entities.HocSinh;
import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.service.HocSinhService;

public class UpdateHocSinhController extends Handler {

	@Override
	public String doProcessGet(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doProcessPost(JSONObject params, String token) {
		HocSinh hs =  HocSinh.getInstence();
		HocSinhService hsService = new HocSinhService(BasicWebservice.dbConn);
		JSONObject jsObj = new JSONObject();
		try {
			hs.setHocSinhId(Integer.parseInt(params.get("sinhvien_id").toString()));
			if(hsService.findById(hs.getHocSinhId())!=null) { 
				hs.setHocSinhName(params.get("sinhvien_name").toString());
				hs.setHocSinhBirthDay(Integer.parseInt(params.get("sinhvien_birthday").toString()));
				hs.setHocSinhClass(params.get("sinhvien_class").toString());
			}else {
				jsObj.put("rc", -1);
				jsObj.put("rd", "err"); 
				return jsObj.toJSONString();
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hsService.updateHocSinh(hs);
	}

}
