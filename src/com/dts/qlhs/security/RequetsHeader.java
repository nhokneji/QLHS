package com.dts.qlhs.security;
//package com.dts.qlhs.session;
//
//import java.util.List;
//import java.util.Map;
//
//import com.dts.qlhs.domain.entities.Account;
//import com.dts.qlhs.domain.entities.HocSinh;
//import com.sun.net.httpserver.Headers;
//import com.sun.net.httpserver.HttpExchange;
//
//public class RequetsHeader {
//	protected Account validateToken(HttpExchange headersEx) {
//			String token = null;
//			String acc = null;
//			JwtValidator jwt = new JwtValidator();
//			Headers requestHeaders = headersEx.getRequestHeaders();
//			for (Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {
//				String key = header.getKey();
//				List<String> value = header.getValue();
//	
//				if (key.equals("Token")) {
//					token = value.get(0);
//					acc = jwt.validate(token);
//				}
//			}
//			return acc;
//		}
//}
//
