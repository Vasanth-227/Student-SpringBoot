package com.Gst.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gst")

public class Gst {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private int hsncode;
	private int percentage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHsncode() {
		return hsncode;
	}
	public void setHsncode(int hsncode) {
		this.hsncode = hsncode;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
}
