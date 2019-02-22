package com.dts.qlhs.serviceImpl;

import java.util.List;

import org.json.simple.JSONObject;

import com.dts.qlhs.domain.entities.HocSinh;
import com.dts.qlhs.domain.reponse.BaseReponse;

public interface HocSinhServiceImpl extends BaseService<HocSinh>{
	public String addHocSinh(HocSinh hs);
	public String deleteHocSinh(int hocSinhId);
	public String updateHocSinh(HocSinh hs);
}
