package com.dts.qlhs.controller;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.dts.qlhs.domain.entities.HocSinh;
import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.security.JwtGenetator;
import com.dts.qlhs.service.HocSinhService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SearchAllHocSinhController extends Handler {

	@Override
	public String doProcessGet(String param) {
		HocSinhService hsService = new HocSinhService(BasicWebservice.dbConn);
		return hsService.findAll().toString();
	}

	@Override
	public String doProcessPost(JSONObject params, String token) {
		return null;}

}
