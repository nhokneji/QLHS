package com.dts.qlhs.security;

import java.io.Serializable;

public class User implements Serializable {
    
	private static final long serialVersionUID = -7957250669413431289L;
	private String userId;
    private long startTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}