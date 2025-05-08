package com.Gst.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Gst.Entity.Gst;
import com.Gst.Repository.GstRepository;

@Repository
public class GstDAO {
	@Autowired
	GstRepository gr;
	
	public String postObj(List<Gst>g) {
		gr.saveAll(g);
		return "Post successfull";
	}
	
	public int getPerByHsn(int a) {
		return gr.getPerByHsn(a);
	}
}
