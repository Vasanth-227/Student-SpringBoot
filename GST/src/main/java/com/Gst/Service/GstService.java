package com.Gst.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gst.DAO.GstDAO;
import com.Gst.Entity.Gst;

@Service
public class GstService {
	@Autowired
	GstDAO gd;
	
	public String postObj(List<Gst>g) {
		return gd.postObj(g);
	}
	
	public int getPerByHsn(int a) {
		return gd.getPerByHsn(a);
	}
}
