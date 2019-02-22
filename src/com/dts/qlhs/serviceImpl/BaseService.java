package com.dts.qlhs.serviceImpl;

import org.json.simple.JSONArray;

import com.dts.qlhs.domain.reponse.BaseReponse;

public interface BaseService<T> {
	String findAll();
	String findById(int id);
}
