package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bean.UserBean;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public UserBean findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://user-info/" + id, UserBean.class);
		
	}
}
