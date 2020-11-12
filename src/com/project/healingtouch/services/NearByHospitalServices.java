package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.NearByHospitalDB;
import com.project.healingtouch.dto.NearByHospitalBean;

public class NearByHospitalServices {

	public ArrayList<NearByHospitalBean> getNearByHospitalData(NearByHospitalBean bean) {
		NearByHospitalDB  db= new  NearByHospitalDB();
		ArrayList<NearByHospitalBean> list=db.getNearByHopitalLatlongList(bean);
		return list;
	}

}
