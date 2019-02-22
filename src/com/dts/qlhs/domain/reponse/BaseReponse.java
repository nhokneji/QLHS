package com.dts.qlhs.domain.reponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BaseReponse {
	protected String buildResult(int rc, String rd, JSONArray jsArr) {
		JSONObject jsObj = new JSONObject();
		jsObj.put("rc", rc);
		jsObj.put("rd", rd);
		jsObj.put("datas", jsArr);
		return jsObj.toJSONString();
	}
	
	protected String buildResult(int rc, String rd, JSONObject item) {
		JSONObject jsObj = new JSONObject();
		jsObj.put("rc", rc);
		jsObj.put("rd", rd);
		jsObj.put("datas", item);  
		return jsObj.toJSONString();
	}
	protected String buildResult(int rc, String rd) {
		JSONObject jsObj = new JSONObject();
		jsObj.put("rc", rc);
		jsObj.put("rd", rd);
		return jsObj.toJSONString();
	}
	
//	protected int rc;//response code
//    protected String rd;//posponse description
//	
//    public BaseReponse() {
//        this.rc = 0;
//        this.rd = "OK";
//    }
//
//    public void serverErr() {
//        this.rc = -1;
//        this.rd = "Server err";
//    }
//    
//    public void setItemNotFound(String rd ) {
//    	this.rc = 400;
//    	this.rd = rd;
//    }
//    
//    public void setItemNotFound() {
//    	setItemNotFound("Item not Found");
//    }
	
}
