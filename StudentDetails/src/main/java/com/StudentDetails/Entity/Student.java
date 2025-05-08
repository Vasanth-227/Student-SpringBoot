package com.StudentDetails.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="student")
@Data

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id; 
	private String name;
	private int rollNumber;
	private String gender;
	private int age;
	private String course;
	private int attendance;

}
