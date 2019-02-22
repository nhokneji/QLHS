package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.domain.entities.Account;
import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.service.AccountService;

public class CreateUserController extends Handler {

	@Override
	public String doProcessGet(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doProcessPost(JSONObject params, String token) {
		Account acc = Account.getInstence();
		AccountService accService = new AccountService(BasicWebservice.dbConn);
		acc.setAccId(Integer.parseInt(params.get("account_id").toString()));
			acc.setAccName(params.get("account_name").toString());
			acc.setAccPass(params.get("account_pass").toString());
			acc.setAccEmail(params.get("account_email").toString());
			acc.setRole(Integer.parseInt(params.get("account_role").toString()));
		return accService.AddUser(acc);
	}


}
