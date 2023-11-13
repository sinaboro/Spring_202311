package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;
import org.zerock.mapper.BoardMapper;
import org.zerock.persistence.DataSourceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImpleTests {

	@Autowired
	private BoardService boardService;
	
	@Test
	public void testRegister() {
		/*
		 * BoardVO board = BoardVO.builder() .title("새로 작성하는 글") .content("새로 작성하는 내용")
		 * .writer("newbie") .build();
		 */
		
//		boardService.register(board);
	}
	
	@Test
	public void testGetList() {
		Criterial cri = new Criterial();
		boardService.getList(cri)
			.forEach(board->log.info(board));
	}

	@Test
	public void testGetByBno() {
		BoardVO vo  = boardService.get(10L);
		log.info(vo);
	}

	@Test
	public void testModify() {
		//BoardVO board = BoardVO.builder()
		/*		.title("새로 수정하는 글")
				.content("새로 수정하는 내용")
				.writer("newbie2")
				.bno(15L)
				.build();
		
		boolean result  = boardService.modify(board);
		log.info("result >>" + result);*/
	}

	@Test
	public void testDelete() {

		boolean result  = boardService.remove(15L);
		log.info("result >>" + result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
