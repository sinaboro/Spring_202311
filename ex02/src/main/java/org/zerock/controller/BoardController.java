package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@RequiredArgsConstructor  
//@AllArgsConstructor >> private BoardService service;
public class BoardController {
	
//	private BoardService service; 
	private final BoardService service; 
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
	
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/get")
	public void get(Long bno) {
		log.info("get");
	}
	
	@PostMapping("/remove")
	public void remove(Long bno) {
		log.info("remove");
	}
	
	@PostMapping("/modify")
	public void modify(BoardVO board) {
		log.info("modify");
	}
}














