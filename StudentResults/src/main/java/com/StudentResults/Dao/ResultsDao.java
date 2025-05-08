package com.StudentResults.Dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentResults.Repository.ResultsRepository;

@Repository

public class ResultsDao {
	@Autowired
	ResultsRepository rr;
		

}
