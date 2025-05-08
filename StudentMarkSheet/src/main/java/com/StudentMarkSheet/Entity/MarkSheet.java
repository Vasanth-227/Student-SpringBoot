package com.StudentMarkSheet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="mark_sheet")
@Data

public class MarkSheet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private int rollNumber;
	private int sem1Theory;
	private int sem1Practicals;
	private int sem2Theory;
	private int sem2Practicals;
	private int sem1Total;
	private int sem2Total;

}
