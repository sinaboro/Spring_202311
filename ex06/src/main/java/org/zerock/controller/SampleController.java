package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController {

	
	@GetMapping("/all")
	public void doAll() {
		System.out.println("all access everybody");
	}
	
	@GetMapping("/member")
	public void doMember() {
		System.out.println("logined member");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		System.out.println("admin access");
	}
}
















