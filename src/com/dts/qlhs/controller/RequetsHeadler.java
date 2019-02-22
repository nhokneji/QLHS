package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.domain.entities.Account;
import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.security.JwtGenetator;
import com.dts.qlhs.service.AccountService;

public class RequetsHeadler extends Handler {

	@Override
	public String doProcessGet(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doProcessPost(JSONObject params, String token) {
		Account account =  Account.getInstence();
		AccountService accService = new AccountService(BasicWebservice.dbConn);
		JwtGenetator jwt = new JwtGenetator();
		JSONObject jsObj = new JSONObject();
		try {
			account.setAccId(Integer.parseInt(params.get("account_id").toString()));
			account.setAccName(params.get("account_name").toString());
			account.setAccPass(params.get("account_pass").toString());
			account.setAccEmail(params.get("account_email").toString());
			account.setRole(Integer.parseInt(params.get("Role").toString()));
			account.setToken(params.get("token").toString());

		} catch (Exception e) {
			jsObj.put("rc", "-1");
			jsObj.put("rd", e.toString());
			return jsObj.toString();
		}

		return jsObj.toJSONString();
	}

}
//