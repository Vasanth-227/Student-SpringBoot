package com.StudentMarkSheet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentMarkSheet.Entity.MarkSheet;
import com.StudentMarkSheet.Service.MarkSheetService;

@RestController
public class MarkSheetController {
	@Autowired
	MarkSheetService ms;
	
	@PostMapping(value="/savePost")
	public String getSave(@RequestBody List<MarkSheet> m) {
	    return ms.getSave(m);
	}
	@GetMapping(value = "/getAll")
	public List<MarkSheet> getO() {
		return ms.getO();
	}
}
