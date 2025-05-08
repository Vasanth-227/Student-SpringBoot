package com.UseProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController

public class UseRestController {
	@Autowired
	RestTemplate rt;
	
	@GetMapping(value="/findAll")
	public List<ProductPojo> get() {
		String url1="http://localhost:8080/getAll";
		String url2="http://localhost:8082/getPerByHsn/";
		
		ResponseEntity<List<ProductPojo>> prods=rt.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductPojo>>() {});
		List<ProductPojo>prod1=prods.getBody();
		prod1.forEach(x-> {
			int h=x.getHsncode();
			ResponseEntity<Integer>per=rt.exchange(url2+h, HttpMethod.GET, null, Integer.class);
			Integer per1=per.getBody();
			x.setPrice(x.getPrice()+x.getPrice()*per1/100);
		});
		return prod1;		
	}
}
