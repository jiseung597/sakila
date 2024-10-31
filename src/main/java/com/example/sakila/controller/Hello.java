package com.example.sakila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class Hello {


	@GetMapping("/hello")
	public String hello() {
		// System.out.println("디버깅 코드");
		// loggin 프레임워크를 사용
		log.debug("로그 테스트...");
		return "hello";
	}
}
