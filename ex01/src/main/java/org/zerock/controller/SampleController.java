package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
//@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, Integer page , Model model) {
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
	public String ex02(@RequestParam("name") String name2,
			@RequestParam("age") int age2 ) {
//		public String ex02(String name,	int age ) {
		log.info("name >> " + name2);
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
