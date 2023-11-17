package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {
			1015842L,1015823L,1015822L,1015821L,1015820L
	};
	
	@Test
	public void testGetListWithPaging() {
		
		mapper.getListWithPaging(new Criterial(3,2), 1015842L)
			.forEach(reply->log.info(reply));
	}
	
	//1015842 public int getCountByBno(Long bno);
	@Test
	public void testGetCountByBno() {
		mapper.getCountByBno(1015842L);
	}
	
	@Test
	public void testUpdate() {
	
		ReplyVO vo = ReplyVO.builder()
				.reply("댓글수정2") 
				.rno(1L)
				.build();
		mapper.update(vo);
	}
	
	
	@Test
	public void testDelete() {
		log.info(mapper.delete(12L));
	}
	
	
	@Test
	public void testRead() {
		log.info(mapper.read(1L));
	}
	
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1,  10).forEach(i -> {
			ReplyVO vo = ReplyVO.builder()
					.bno(bnoArr[i % 5])
					.reply("댓글 테스트 " + i)
					.replyer("댓글자 " + i)
					.build();
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testCreate2() {
		
			ReplyVO vo = ReplyVO.builder()
					.bno(1015842L)
					.reply("댓글 테스트4 ")
					.replyer("댓글러 4")
					.build();
			mapper.insert(vo);
		
	}
	
	
	@Test
	public void testMapper() {
		log.info(">>>>>>>>>>" + mapper);
	}
	
	
	
	
	
	
	
	
	
	
	
}
