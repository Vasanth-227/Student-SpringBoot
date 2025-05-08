package com.StudentResults.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentResults.Entity.Results;
import com.StudentResults.Service.ResultsService;

@RestController

public class ResultsController {
	@Autowired
	ResultsService rs;
	
    @PostMapping(value="/postObject") 
	public String postObject() {
		return rs.postObject();
	}
    
    @GetMapping(value = "/getAllResult")
	public List<Results> getAllRes() {
		return rs.getAllRes();
	}
    
    @GetMapping("/topper")
    public Results getTopper() {
        return rs.getTopper();
    }

    @GetMapping("/top3")
    public List<Results> getTopThree() {
        return rs.getTopThree();
    }

    @GetMapping(value="/range")
    public List<Results> getByMarksRange(@RequestParam int min, @RequestParam int max) {
        return rs.getByMarksRange(min, max);
    }

}
