package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
					.bno(1L)
					.reply("댓글 테스트 ")
					.replyer("댓글자 ")
					.build();
			mapper.insert(vo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testMapper() {
		log.info(">>>>>>>>>>" + mapper);
	}
	
}
