package com.StudentDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentDetails.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
