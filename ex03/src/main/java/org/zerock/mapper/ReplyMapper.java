package org.zerock.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);  //Create
	public ReplyVO read(Long rno);  //Read
	public int update(ReplyVO vo);  //Update
	public int delete(Long rno);    //Delete
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criterial cri,
			@Param("bno") Long bno
			);
	
}
