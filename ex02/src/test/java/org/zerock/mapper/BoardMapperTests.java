package org.zerock.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

//	@Setter(onMethod_ = @Autowired)
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		 List<BoardVO> list = mapper.getList();
//		 for(BoardVO vo  : list)
//			 log.info(vo);
		
		mapper.getList().forEach(board-> log.info(board));
	
	}
	
	@Test
	public void testInsert() {

		/*
		 * BoardVO vo = BoardVO.builder() .title("인서트4") .content("인서트 내용2")
		 * .writer("조운2") .build();
		 * 
		 * mapper.insert(vo);
		 */
	}

	@Test
	public void testInserteSelectKey() {
		
		/*
		 * BoardVO vo = BoardVO.builder() .title("인서트5") .content("인서트 내용3")
		 * .writer("미방") .build();
		 * 
		 * mapper.inserteSelectKey(vo);
		 */
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(1L);
		log.info("vo >>" + vo);
	}

	@Test
	public void testDelete() {
		mapper.delete(11L);
	}
	
	@Test
	public void testUpdate() {
		/*
		 * BoardVO vo = BoardVO.builder() .bno(9L) .title("수정 제목2") .content("수정 내용2")
		 * .writer("수정자2") .build();
		 * 
		 * int result = mapper.update(vo); log.info("result >> " + result);
		 */
	}
	
	@Test
	public void testGetListWithPaggin() {
		
		Criterial cri = new Criterial();
		cri.setPageNum(3);
		cri.setAmount(20);
		List<BoardVO> list =  mapper.getListWithPaging(cri);
		
		list.forEach(board-> log.info(board));
	}
	
	
	@Test
	public void testCount() {
		
		Criterial cri = new Criterial();
		cri.setType("TCW");
		cri.setKeyword("자바");
		log.info(mapper.getTotalCount(cri));
	}
	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("T", "조조");
		map.put("C", "자바");
		map.put("W", "허균");
		
		Map<String , Map<String,String>> outer = 
				new HashMap<String, Map<String,String>>();
		
		outer.put("map", map);
		
		List<BoardVO> list = mapper.searchTest(outer);
		log.info(list);
	}
	
	
	@Test
	public void testSearchPaging() {
		Criterial cri = new Criterial();
		cri.setType("");
		cri.setKeyword("");
		
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		log.info(list);
		
		mapper.getListWithPaging(cri).forEach(list-> log.info(list));
	}
	
	
	
	
	
	
	
	
	
}
