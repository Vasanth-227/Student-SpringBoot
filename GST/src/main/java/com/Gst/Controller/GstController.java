package com.Gst.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Gst.Entity.Gst;
import com.Gst.Service.GstService;

@RestController
public class GstController {
	@Autowired
	GstService gs;
	
	@PostMapping(value="/postObj")
	public String postObj(@RequestBody List<Gst>g) {
		return gs.postObj(g);
	}
	@GetMapping(value="/getPerByHsn/{a}")
	public int getPerByHsn(@PathVariable int a) {
		return gs.getPerByHsn(a);
	}
}
