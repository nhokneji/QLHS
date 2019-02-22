package com.dts.qlhs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dts.qlhs.connection.DBConnection;
import com.dts.qlhs.domain.entities.Account;
import com.dts.qlhs.domain.reponse.BaseReponse;

public class AccountService extends BaseReponse {
	DBConnection dbConn = null;
	Statement state = null;
	PreparedStatement pre = null;
	Connection conn;
	ResultSet rs = null;

	public AccountService(DBConnection dbConn) {
		this.dbConn = dbConn;
		conn = dbConn.getConnection();
	}

	public String findAll() {
		final String SELECT_ALL_USER = "select * from account";
		JSONObject jsObj = new JSONObject();
		JSONArray jsArr = new JSONArray();
		String r = null; 
		try { 
			pre = conn.prepareStatement(SELECT_ALL_USER);
			rs = pre.executeQuery();
			while (rs.next()) {
				jsObj.put("accID", rs.getInt("account_id"));
				jsObj.put("accName", rs.getString("account_name"));
				jsObj.put("accPass", rs.getString("account_pass"));
				jsObj.put("accEmail", rs.getString("account_email"));
				jsObj.put("accRole", rs.getInt("account_role"));
				jsObj.put("token", rs.getString("token"));
				jsArr.add(jsObj);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			r = buildResult(-1, "server Err");
		}
		r = buildResult(0, "ok", jsArr);
		return r;
	}
	
	
	public String searchUserById(int id) {
		final String SELECT_USER = "select * from account where account_id ='" + id +"'";
		JSONObject jsObj = new JSONObject(); 
		String r = null;
		int n = 0;
		try {
			pre = conn.prepareStatement(SELECT_USER); 
			rs = pre.executeQuery();;
			while(rs.next()) {
				jsObj.put("accID", rs.getInt("account_id"));
				jsObj.put("accName", rs.getString("account_name"));
				jsObj.put("accPass", rs.getString("account_pass"));
				jsObj.put("accEmail", rs.getString("account_email"));
				jsObj.put("accRole", rs.getInt("account_role"));
				jsObj.put("token", rs.getString("token"));
				n=1;
			}
			if(n==1) {
				r = buildResult(0, "ok", jsObj);
			}
			else return null;
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		return r;
	}

	public String searchUserByName(String name) {
		final String SELECT_USER = "select * from account where account_name ='" + name +"'";
		JSONObject jsObj = new JSONObject(); 
		try {
			pre = conn.prepareStatement(SELECT_USER); 
			rs = pre.executeQuery();
			while(rs.next()) {
				jsObj.put("accID", rs.getInt("account_id"));
				jsObj.put("accName", rs.getString("account_name"));
				jsObj.put("accPass", rs.getString("account_pass"));
				jsObj.put("accEmail", rs.getString("account_email"));
				jsObj.put("accRole", rs.getInt("account_role"));
				jsObj.put("token", rs.getString("token"));
			}
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		return jsObj.toJSONString();
	}
	
	public String AddUser(Account acc) {
		final String SELECT_USER = "INSERT INTO account (account_name, account_pass, account_email,accRole) VALUES (?,?,?)";
		String r = null;
		try {
			pre = conn.prepareStatement(SELECT_USER); 
			pre.setString(1, acc.getAccName());
			pre.setString(2, acc.getAccPass());
			pre.setString(3, acc.getAccEmail());
			pre.executeUpdate();
		} catch (Exception e) {
			r = buildResult(-1, e.getMessage());
		}
		r = buildResult(0,"ok");
		return r;
	}

	public String updateToken(Account acc, String token) {
		final String UPDATE_TOKEN = "UPDATE account SET token =? WHERE account.account_id = " + acc.getAccId();
		String r; 
		try {
			pre = conn.prepareStatement(UPDATE_TOKEN);
			pre.setString(1, token);
			pre.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			r = buildResult(-1, "Err");
			return r;
		}
		r = buildResult(0, "ok");
		return r;
	}
	
	public String UpdateUser(Account acc) {
		final String SELECT_USER = "select * from account where account_id ='" + acc.getAccId() +"'";
		JSONObject jsObj = new JSONObject(); 
		String r = null;
//		try {
//			pre = conn.prepareStatement(SELECT_USER);
//			pre.setString(1, acc.getAccName());
//			pre.setInt(2, acc.get());
//			pre.setString(3, hs.getHocSinhClass());
//			pre.executeUpdate();
//		} catch (Exception e) {
//			r = buildResult(-1, e.getMessage());
//		}
		r = buildResult(0,"ok");
		return r;
		
	}

	public int login(Account acc) {
		final String SELECT_account = "select account_name,account_role, token from account where account_name='"+ acc.getAccName() + "' AND account_pass = " + acc.getAccPass();
		int n = 0;
		try {
			pre = conn.prepareStatement(SELECT_account);
			rs = pre.executeQuery();
			while (rs.next()) {
				n = 1;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return n;
	}

}
