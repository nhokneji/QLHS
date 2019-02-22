package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.service.AccountService;

public class SearchAllUserController extends Handler{

	@Override
	public String doProcessGet(String param) {
		AccountService accountService = new AccountService(BasicWebservice.dbConn);
		return accountService.findAll();
	}

	@Override
	public String doProcessPost(JSONObject params, String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
