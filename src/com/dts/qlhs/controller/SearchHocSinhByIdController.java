package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.service.HocSinhService;

public class SearchHocSinhByIdController extends Handler {

	@Override
	public String doProcessGet(String param) {
		HocSinhService hsService = new HocSinhService(BasicWebservice.dbConn);
		try {
			if (param.contains("/findAll/")) {
				int id = Integer.parseInt(param.substring(9));
				return hsService.findById(id).toString();
			}
		} catch (Exception e) {
			return "invalid params";
		}
		return "";
	}

	@Override
	public String doProcessPost(JSONObject params, String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
