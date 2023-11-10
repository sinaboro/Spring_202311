package org.zerock.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
//@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/ex10")
	public ResponseEntity<String> ex10(){
		log.info("ex10");
		String msg = "{\"name\" : \"홍길동\"}";
		
		HttpHeaders headers  = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		
		return new ResponseEntity<String>(msg, headers, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/ex09")
	public void ex09(@RequestBody SampleDTO dto) {
		log.info("ex09.........");
		log.info(dto.getName());
		log.info(dto.getAge());
		
	}

	@GetMapping("/ex08")
	public @ResponseBody SampleDTO ex08() {
//	public SampleDTO ex08() {
		log.info("ex08.........");
		SampleDTO dto = new SampleDTO();
		dto.setName("유비");
		dto.setAge(20);
		
		return dto;
	}
	
	
	@DeleteMapping("/ex07/{id}")
	public String ex07(@PathVariable("id") int id) {
		//삭제 작업..
		return "ex07";
	}
	
	@GetMapping("/ex06/{name}/{age}")
	public String ex06(@PathVariable("name") String name, @PathVariable("age") int age) {
		log.info("name>> " + name);
		log.info("age>> " + age);
		
		return "ex06";
	}
	
	@GetMapping("/ex05")
	public void ex05(String name, int age) {
		log.info(name);
		log.info(age);
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page , Model model) {
		log.info(dto);
		log.info(page);
		model.addAttribute("page", page);
		return "sample/ex04";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list >> " + list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,
			@RequestParam("age") int age2 ) {
//		public String ex02(String name,	int age ) {
		log.info("name >> " + name);
		log.info("age >> " + (age2+10));
		return "ex02";
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto , Model model) {
		log.info("dot >> " + dto);
		log.info("dot >> " + dto.getName());
		log.info("dot >> " + (dto.getAge()+10));
		model.addAttribute("dto", dto);
		return "ex01";
	}
	
	@RequestMapping("")
	public void basic2() {
		log.info("basic........");
	}

	//@RequestMapping(value = "/basic", method = RequestMethod.GET)
	@GetMapping(value = "/basic")
	public void basic() {
		log.info("basic....get");
	}

	//@RequestMapping(value = "/basic", method = RequestMethod.POST)
	@PostMapping("/basic")
	public void basic3() {
		log.info("basic....post");
	}

//	@RequestMapping(value = "/basic", method = RequestMethod.DELETE)
	@DeleteMapping("/basic")
	public void basic4() {
		log.info("basic....DELETE");
	}
	
	@RequestMapping("first")
	public void first() {
		log.info("first........");
	}

	@RequestMapping("second")
	public void second() {
		log.info("second........");
	}
}
