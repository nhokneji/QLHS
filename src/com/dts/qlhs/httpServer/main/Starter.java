package com.dts.qlhs.httpServer.main;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.dts.qlhs.controller.CreateHocsinhController;
import com.dts.qlhs.controller.CreateUserController;
import com.dts.qlhs.controller.DeleteHocsinhController;
import com.dts.qlhs.controller.LoginController;
import com.dts.qlhs.controller.SearchAllHocSinhController;
import com.dts.qlhs.controller.SearchAllUserController;
import com.dts.qlhs.controller.SearchHocSinhByIdController;
import com.dts.qlhs.controller.UpdateHocSinhController;
import com.dts.qlhs.controller.UpdateUserController;
import com.sun.net.httpserver.HttpServer;

public class Starter {
	
	public void start() throws IOException {
		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(9000), 0);
			server.createContext("/searchAllHs", new SearchAllHocSinhController());
			server.createContext("/searchHsById", new SearchHocSinhByIdController());
			server.createContext("/createHs", new CreateHocsinhController());
			server.createContext("/deleteHs", new DeleteHocsinhController());
			server.createContext("/updateHs", new UpdateHocSinhController());
			
			 
			server.createContext("/login", new LoginController());
			server.createContext("/createUser", new CreateUserController());
			server.createContext("/updateUser", new UpdateUserController());
			server.createContext("/selectAllUser", new SearchAllUserController());
			
			server.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
