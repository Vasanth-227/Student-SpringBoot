package com.StudentMarkSheet.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentMarkSheet.Entity.MarkSheet;
import com.StudentMarkSheet.Repository.MarkSheetRepository;

@Repository
public class MarkSheetDao {
	@Autowired
	MarkSheetRepository mr;
	
    public String getSave(List<MarkSheet> m) {
    	mr.saveAll(m);
    	return "Post Success";
    }
    
	public List<MarkSheet> getO() {
		return mr.findAll();
	}
}
