package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;
import org.zerock.domain.PageDTO;
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
	public void list(Criterial cri, Model model) {
		log.info("list >> " + cri);
		
//		cri.setPageNum(12);
//		cri.setAmount(10);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 125));
	}
	
	//localhost:8080/board/register
	@GetMapping("/register")
	public void register() {
		
	}
	
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
	
		return "redirect:/board/list";
	}

	//localhost:8080/board/get?bno= 값
	//localhost:8080/board/modify?bno= 값
	@GetMapping({"/get", "/modify"})
	public void get(Long bno, @ModelAttribute("cri")Criterial cri,  Model model) {
		log.info("/get or modify");
		
		model.addAttribute("board", service.get(bno));
	}
	
	//localhost:8080/board/remove
	@PostMapping("/remove")
	public String remove(Long bno, @ModelAttribute("cri")Criterial cri, RedirectAttributes rttr) {
		log.info("remove");
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri")Criterial cri,  RedirectAttributes rttr) {
		log.info("modify");
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	}
}














