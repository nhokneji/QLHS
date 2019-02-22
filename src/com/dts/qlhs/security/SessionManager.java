package com.dts.qlhs.security;

import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import com.dts.qlhs.common.MD5;

public class SessionManager {
	private BlockingQueue<String> tokenList = new ArrayBlockingQueue<String>(10000000);
	// private Timer timer = new Timer();
	private boolean isRun = true;
	private RedisSessionRepo redisSessionRepo;

	public String getTokenByUserId(String userID) {
		if (userID == null) {
			return null;
		}
		for (String token : tokenList) {
			User u = redisSessionRepo.find(token);
			if (u == null) {
				continue;
			}
			String uID = u.getUserId();
			if (userID.equals(uID)) {
				return token;
			} 
		}
		return null;
	}

	public String addUserSession(String userID) {
		String token = userID + System.currentTimeMillis();
		try {
			token = MD5.hash(token);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		User u = new User();
		u.setStartTime(System.currentTimeMillis());
		u.setUserId(userID);
		redisSessionRepo.save(token, u);
		tokenList.add(token);
		return token;
	}

	public String removeUserToken(String token) {
		String userID = getTokenByUserId(token);
		if (userID != null) {
			tokenList.remove(token);
			redisSessionRepo.delete(token);
		}
		return userID;
	}

	public String getUserByToken(String token) { 
		if (token == null) {
			return null;
		} 
		User u = redisSessionRepo.find(token);
		 if(u == null) {
			return "@";
		}
		u.setStartTime(System.currentTimeMillis());
		redisSessionRepo.save(token, u);
		return u.getUserId();
	}

	public long getAliveTime(String token) {
		User u = redisSessionRepo.find(token);
		if (u != null) {
			long startTime = u.getStartTime();
			return (System.currentTimeMillis() - startTime);
		}
		return -1l;
	}
}
