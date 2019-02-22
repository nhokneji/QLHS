package com.dts.qlhs.httpServer.main;
//package com.dts.qlhs.httpServer;
//
//import org.omg.CORBA.Request;
//
//import com.mysql.fabric.Response;
//
//public abstract class RequestHandlers {
//	public enum Methods {
//		POST, GET, PUT, DELETE
//	}
//
//	public Response handle(RequestHandlers request) {
//		if (request.getMethod().compareToIgnoreCase(Methods.GET.toString()) == 0)
//			return Get(request);
//		else if (request.getMethod().compareToIgnoreCase(Methods.PUT.toString()) == 0)
//			return Put(request);
//		else if (request.getMethod().compareToIgnoreCase(Methods.POST.toString()) == 0)
//			return Post(request);
//		else if (request.getMethod().compareToIgnoreCase(Methods.DELETE.toString()) == 0)
//			return Delete(request);
//		else
//			return null;
//	}
//
//	public abstract Response Get(Request request);
//
//	public abstract Response Post(Request request);
//
//	public abstract Response Put(Request request);
//
//	public abstract Response Delete(Request request);
//}
