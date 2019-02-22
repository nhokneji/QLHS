package com.dts.qlhs.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.dts.qlhs.connection.DBConnection;
import com.dts.qlhs.domain.entities.Account;
import com.dts.qlhs.domain.entities.HocSinh;
import com.dts.qlhs.domain.reponse.BaseReponse;
import com.dts.qlhs.security.JwtGenetator;
import com.dts.qlhs.security.JwtUser;
import com.dts.qlhs.security.JwtValidator;
import com.dts.qlhs.security.SessionManager;
import com.dts.qlhs.service.AccountService;
import com.dts.qlhs.service.HocSinhService;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class Handler implements HttpHandler {

	@Override
	public void handle(HttpExchange xchg) throws IOException {
		// TODO Auto-generated method stub
		DBConnection dbConn = DBConnection.getInstence();
		HocSinhService hsService = new HocSinhService(dbConn);
		Headers headers = xchg.getRequestHeaders();
		// String m = method(xchg);  
		String method = xchg.getRequestMethod();
		URI uri = xchg.getRequestURI();
		System.out.println("uri = " + uri.toString());
		String response = null;

		JSONObject jsObj = new JSONObject();
		String accID = null;
		try {
			AccountService accService = new AccountService(dbConn);
			JwtValidator jwtVal = new JwtValidator();
			jsObj = getRequestBody(xchg); 
			String token = requetsHeader(xchg); 
 			Account acc = jwtVal.validate(token); 
			if (accService.searchUserByName(acc.getAccName()) != null) {
				if (method.equalsIgnoreCase("get")) {
					response = doProcessGet(uri.toString());

				} else {
					response = doProcessPost(jsObj, token == null ? "" : token);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendResp(xchg, response);
	}

	public abstract String doProcessGet(String param);

	public abstract String doProcessPost(JSONObject params, String token);
	// public abstract String doProcessPost(JSONObject params);

	private JSONObject getRequestBody(HttpExchange xchg) throws IOException, ParseException {
		InputStream ins = xchg.getRequestBody();
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = ins.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		String data = result.toString("UTF-8");
		if (data == null || data.isEmpty()) {
			return null;
		}
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(data);

		return obj;
	}

	private void sendResp(HttpExchange xchg, String resp) throws IOException {
		if (xchg == null) {
			return;
		}
		xchg.sendResponseHeaders(200, resp.getBytes("UTF-8").length);
		try (OutputStream os = xchg.getResponseBody()) {
			os.write(resp.getBytes("UTF-8"));
		}
	}

//	private String getToken(JSONObject jsObj) {
//		if (jsObj == null) {
//			return null;
//		}
//		try {
//			String token = (String) jsObj.get("token");
//			return token;
//		} catch (Exception ex) {
//		}
//		return null;
//	}

	//
	protected String requetsHeader(HttpExchange headersEx) {
		String token = null;
		Account jwtUser =  Account.getInstence();
		JwtGenetator jwt = new JwtGenetator();

		Headers requestHeaders = headersEx.getRequestHeaders();

		for (Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {
			String key = header.getKey();
			List<String> value = header.getValue();

			if (key.equals("Token")) {
				token = value.get(0);
//				 jwtUser = jwt.validate(token);
				return token;
			}
		}
		return "";
	}

}
