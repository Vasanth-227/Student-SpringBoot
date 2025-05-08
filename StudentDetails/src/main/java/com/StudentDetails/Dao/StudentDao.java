package com.StudentDetails.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentDetails.Entity.Student;
import com.StudentDetails.Repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository sr;
	
	public String getPost(List<Student> s) {
		sr.saveAll(s);
		return "Post Success";
	}
	
	public List<Student> getObj() {
		return sr.findAll();
	}
	
	public String getModif(int n,Student s) {
		Student s1=sr.findById(n).get();
		s1.setName(s.getName());
		s1.setRollNumber(s.getRollNumber());
		s1.setGender(s.getGender());
		s1.setAge(s.getAge());
		s1.setCourse(s.getCourse());
		s1.setAttendance(s.getAttendance());
		sr.save(s1);
		return "Modified Successfully";	
	}
	public String getD(int n) {
		sr.deleteById(n);;
		return "Deleted Successfully";
	}
	
	public String getSing(Student s) {
		sr.save(s);
		return "Post Success";
	}
}
