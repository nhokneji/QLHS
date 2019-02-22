package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.domain.entities.Account;
import com.dts.qlhs.domain.entities.HocSinh;
import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.service.AccountService;
import com.dts.qlhs.service.HocSinhService;

public class UpdateUserController extends Handler{

	@Override
	public String doProcessGet(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doProcessPost(JSONObject params, String token) {
		 Account acc = Account.getInstence();
		AccountService accService = new AccountService(BasicWebservice.dbConn);
		JSONObject jsObj = new JSONObject();
		acc.setAccId(Integer.parseInt(params.get("account_id").toString()));
		if(acc.getAccId() == 1) {
			acc.setAccName(params.get("account_name").toString());
			acc.setAccPass(params.get("account_pass").toString());
			acc.setAccEmail(params.get("account_email").toString());
			acc.setRole(Integer.parseInt(params.get("account_role").toString()));
		}else {
			jsObj.put("rc", -1);
			jsObj.put("rd", "err"); 
			return jsObj.toJSONString();
		}
		return accService.UpdateUser(acc);
	}

}
