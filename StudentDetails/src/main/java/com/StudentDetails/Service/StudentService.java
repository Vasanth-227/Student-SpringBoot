package com.StudentDetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentDetails.Dao.StudentDao;
import com.StudentDetails.Entity.Student;
import com.StudentDetails.Exception.AgeException;

@Service

public class StudentService {
	@Autowired
	StudentDao sd;
	
	public String getPost(List<Student> s) {
		return sd.getPost(s);
	}
	
	public List<Student> getObj() {
		return sd.getObj();
	}
	
	public String getModif(int n,Student s) {
		return sd.getModif(n,s);
	}
	public String getD(int n) {
		return sd.getD(n);
	}
	
	public String getSing(Student s) throws AgeException {
		if(s.getAge()<18) {
			throw new AgeException("Age is less than 18 for Student: "+s.getName());
		}
		return sd.getSing(s);
		}
}
