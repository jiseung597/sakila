package com.example.sakila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/on/staff/staffList")
	public String staffList() {
		// OnInterceptor 호출
		return "/on/staff/staffList";
		
	}
	
	@GetMapping("/on/film/addFilm")
	public String addFilm() {
		// OnInterceptor 호출
		return "/on/file/addFilm";
	}
	
}
