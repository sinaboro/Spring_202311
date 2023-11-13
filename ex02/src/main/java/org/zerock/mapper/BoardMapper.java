package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

public interface BoardMapper {

	//전체 데이타 조회
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

	//페이징 처리
	public List<BoardVO> getListWithPaging(Criterial cri);
	
	//insert문 bno값 알 필요없을때
	public void insert(BoardVO vo);
	//insert문 bno값 알 필요 있을 때
	public void inserteSelectKey(BoardVO vo);
	
	//bno로 데이타 조회
	public BoardVO read(Long bno);
	
	//bno값을 데이타 삭제
	public int delete(Long bno);
	
	public int update(BoardVO vo);
	
	
}
