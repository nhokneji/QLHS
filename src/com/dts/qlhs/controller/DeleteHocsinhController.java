package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.service.HocSinhService;

public class DeleteHocsinhController extends Handler{

	@Override
	public String doProcessGet(String param) {
		HocSinhService hsService = new HocSinhService(BasicWebservice.dbConn);
		try {
			if (param.contains("/deleteHs/")) {
				int id = Integer.parseInt(param.substring(10));
				return hsService.deleteHocSinh(id);
			}
		} catch (Exception e) {
			return "invalid params";
		}
		return "";
	}

	@Override
	public String doProcessPost(JSONObject obj, String param) {
		return null;
	}

}
