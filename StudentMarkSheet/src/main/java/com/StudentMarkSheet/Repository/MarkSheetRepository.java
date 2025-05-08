package com.StudentMarkSheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentMarkSheet.Entity.MarkSheet;

public interface MarkSheetRepository extends JpaRepository<MarkSheet,Integer> {

}
