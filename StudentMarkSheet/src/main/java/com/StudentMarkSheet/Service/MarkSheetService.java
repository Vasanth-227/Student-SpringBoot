package com.StudentMarkSheet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentMarkSheet.Dao.MarkSheetDao;
import com.StudentMarkSheet.Entity.MarkSheet;

@Service
public class MarkSheetService {
	@Autowired
	MarkSheetDao md;
	
    public String getSave(List<MarkSheet> m) {
    	for(MarkSheet x: m) {
    		x.setSem1Total(x.getSem1Theory()+x.getSem1Practicals());
    		x.setSem2Total(x.getSem2Theory()+x.getSem2Practicals());
    	}
    	return md.getSave(m);
    }
    
	public List<MarkSheet> getO() {
		return md.getO();
	}
}
