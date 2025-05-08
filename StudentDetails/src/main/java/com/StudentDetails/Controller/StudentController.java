package com.StudentDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentDetails.Entity.Student;
import com.StudentDetails.Exception.AgeException;
import com.StudentDetails.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@PostMapping(value="/getPost")
	public String getPost(@RequestBody List<Student>s) {
		return ss.getPost(s);
	}
	
	@GetMapping(value = "/getObj")
	public List<Student> getObj() {
		return ss.getObj();
	}
	
	@PutMapping(value="/getModify/{n}")
	public String getModif(@PathVariable int n,@RequestBody Student s) {
		return ss.getModif(n,s);
	}
	@DeleteMapping(value="/delete/{n}")
	public String getD(@PathVariable int n) {
		return ss.getD(n);
	}
	
	@PostMapping(value="/PostSingle")
	public String getSing(@RequestBody Student s) throws AgeException {
		return ss.getSing(s);
	}

}
