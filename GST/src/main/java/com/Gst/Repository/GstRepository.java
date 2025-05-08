package com.Gst.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Gst.Entity.Gst;

public interface GstRepository extends JpaRepository<Gst,Integer> {
	
	@Query(value="Select x.percentage from Gst x where x.hsncode= :a")
	public int getPerByHsn(@Param("a") int a); 
	
}
