package com.dts.qlhs.controller;

import org.json.simple.JSONObject;

import com.dts.qlhs.domain.entities.Account;
import com.dts.qlhs.domain.reponse.BaseReponse;
import com.dts.qlhs.httpServer.main.BasicWebservice;
import com.dts.qlhs.security.JwtGenetator;
import com.dts.qlhs.service.AccountService;

public class LoginController extends Handler {

	@Override
	public String doProcessGet(String param) {
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
			token = jwt.generate(account);
			 System.out.println(token); 
			if (accService.login(account) == 1) { 
				accService.updateToken(account, token);
				jsObj.put("Datas", token);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jsObj.toJSONString();
	}

}
