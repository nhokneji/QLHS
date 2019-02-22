package com.dts.qlhs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dts.qlhs.connection.DBConnection;
import com.dts.qlhs.domain.entities.HocSinh;
import com.dts.qlhs.domain.reponse.BaseReponse;
import com.dts.qlhs.serviceImpl.HocSinhServiceImpl;

public class HocSinhService extends BaseReponse implements HocSinhServiceImpl {
	
	
	
	DBConnection dbConn = null;
	Statement state = null;
	PreparedStatement pre = null;
	Connection conn = null;
	ResultSet rs = null;

	public HocSinhService(DBConnection dbConn) {
		this.dbConn = dbConn; 
		conn = dbConn.getConnection();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public String findById(int id) {
		final String SELECT_HS_BY_ID = "select sinhvien_name, sinhvien_birthday, sinhvien_class from sv where sinhvien_id="+ id;
		JSONObject jsObj = new JSONObject();
		String r = null;
		int n = 0; 
		try {
			pre = conn.prepareStatement(SELECT_HS_BY_ID);
			rs = pre.executeQuery();
			while (rs.next()) { 

				jsObj.put("hocSinhName", rs.getString("sinhvien_name"));
				jsObj.put("hocSinhBirthDay", rs.getInt("sinhvien_birthday"));
				jsObj.put("hocSinhClass", rs.getString("sinhvien_class"));
				n=1;
			}
			if(n==1) {
				r = buildResult(0, "ok", jsObj);
			}
			else return null;
			 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return r;
	}

	@Override
	public String addHocSinh(HocSinh hs) {
		final String INSERT_HS = "INSERT INTO sv (sinhvien_name, sinhvien_birthday, sinhvien_class) VALUES (?,?,?)";
//		int n = 0;
		String r = null;
		try {
			pre = conn.prepareStatement(INSERT_HS);
			pre.setString(1, hs.getHocSinhName());
			pre.setInt(2, hs.getHocSinhBirthDay());
			pre.setString(3, hs.getHocSinhClass());
			pre.executeUpdate();
		} catch (Exception e) {
			r = buildResult(-1, e.getMessage());
		}
		r = buildResult(0,"ok");
		return r;
	}

	@Override
	public String findAll() {
		final String SELECT_ALL_HS = "select * from sv";
		String r = null;
		JSONArray jsArr = new JSONArray();
		try {
			pre = conn.prepareStatement(SELECT_ALL_HS);
			rs = pre.executeQuery();
			while (rs.next()) { 
				JSONObject jsObj = new JSONObject();
				jsObj.put("hocSinhId", rs.getInt("sinhvien_id"));
				jsObj.put("hocSinhName", rs.getString("sinhvien_name"));
				jsObj.put("hocSinhBirthDay", rs.getInt("sinhvien_birthday"));
				jsObj.put("hocSinhClass", rs.getString("sinhvien_class"));
				jsArr.add(jsObj);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return buildResult(-1, "err");
		}
		r = buildResult(0, "ok", jsArr);
		return r;
	}

	@Override
	public String deleteHocSinh(int hocSinhId) {
		final String DELETE_HS = "DELETE FROM sv WHERE sinhvien_id =" + hocSinhId;
		JSONObject jsObj = new JSONObject();
		String r;
		try {
			pre = conn.prepareStatement(DELETE_HS);
			 pre.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return buildResult(-1, "err");
		}
		r= buildResult(-1, "ok",jsObj);
		return r; 
	}

	@Override
	public String updateHocSinh(HocSinh hs) {
		final String UPDATE_HS = "UPDATE sv SET sinhvien_name=?,sinhvien_birthday=?,sinhvien_class=? WHERE sinhvien_id=?";
		try {
			pre = conn.prepareStatement(UPDATE_HS);  
			pre.setString(1, hs.getHocSinhName());
			pre.setInt(2, hs.getHocSinhBirthDay());
			pre.setString(3, hs.getHocSinhClass()); 
			pre.setInt(4, hs.getHocSinhId());
			pre.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return buildResult(-1, "err");
		}
		return buildResult(0, "ok");

	}

}
