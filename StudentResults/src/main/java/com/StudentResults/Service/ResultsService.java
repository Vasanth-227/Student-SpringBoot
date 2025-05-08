package com.StudentResults.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.StudentResults.MarkSheetPojo;
import com.StudentResults.StudentPojo;
import com.StudentResults.Dao.ResultsDao;
import com.StudentResults.Entity.Results;
import com.StudentResults.Repository.ResultsRepository;

@Service

public class ResultsService {
	@Autowired
	ResultsDao rd;
	@Autowired
	RestTemplate rt;
	@Autowired
	ResultsRepository rr;
	
	public String postObject() {
		String url_stud="http://localhost:8080/getObj";// post object of student
		String url_marksheet="http://localhost:8081/getAll";// post object of marksheet
		
		ResponseEntity<List<StudentPojo>> response=rt.exchange(url_stud, HttpMethod.GET, null, new ParameterizedTypeReference<List<StudentPojo>>() {});
        List<StudentPojo> stud = response.getBody();
        
        ResponseEntity<List<MarkSheetPojo>>markresponse=rt.exchange(url_marksheet, HttpMethod.GET, null, new ParameterizedTypeReference<List<MarkSheetPojo>>() {});
		List<MarkSheetPojo> mark=markresponse.getBody();
		
        List<Results> resul = new ArrayList<>();
        
        for(StudentPojo x: stud) {
        	for(MarkSheetPojo y: mark) {
        		if(x.getRollNumber()==y.getRollNumber()) {
        			
                    // Calculate total marks
        			int totalMarks=(y.getSem1Total()+y.getSem2Total())/2;
        			
                    // If attendance is >= 90%, add 5 marks (but don't exceed 100)
        			if(x.getAttendance()>=90) {
        				totalMarks=Math.min(totalMarks+5, 100);
        			}
        			
                    // Calculate percentage
        			int percentage=(totalMarks*100)/100;
        			
                    // Create the Results object
        			Results re=new Results();
        			re.setRollNumber(x.getRollNumber());
        			re.setName(x.getName());
        			re.setTotalMarks(totalMarks);
        			re.setPercentage(percentage);
        			
                    // Add the result to the list
        			resul.add(re);
        		}
        	}
        }
         rr.saveAll(resul);
         return "Post Success";
	}
	
	public List<Results> getAllRes() {
		return rr.findAll();
	}
	
    public Results getTopper() {
    	List<Results> x=rr.findAll();
    	Results result= x.stream().max(Comparator.comparing(Results::getTotalMarks)).get();
    	return result;
    }
    
    public List<Results> getTopThree() {
    	List<Results> x=rr.findAll();
    	List<Results>result= x.stream().sorted(Comparator.comparing(Results::getTotalMarks).reversed()).limit(3).collect(Collectors.toList());
    	return result;
    }
    
    public List<Results> getByMarksRange(int min, int max) {
    	List<Results> y=rr.findAll();
    	List<Results>result= y.stream().filter(x->(x.getTotalMarks()>=min && x.getTotalMarks()<=max)).collect(Collectors.toList());
    	return result;
    }

}
