package com.dts.qlhs.httpServer.main;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.dts.qlhs.connection.DBConnection;
import com.dts.qlhs.controller.SearchAllHocSinhController;
import com.dts.qlhs.controller.LoginController;
import com.dts.qlhs.security.JwtGenetator;
import com.sun.net.httpserver.HttpServer;
 
public class BasicWebservice {
	public static DBConnection dbConn = DBConnection.getInstence();

	public static void main(String[] args) throws IOException {
		Starter st = new Starter();
		st.start();
	}
}
	
	
