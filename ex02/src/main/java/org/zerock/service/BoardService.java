package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

public interface BoardService {
	
	
//	public List<BoardVO> getList();
	public List<BoardVO> getList(Criterial cri);
	public BoardVO get(Long bno);
	public void register(BoardVO board);
	public boolean modify(BoardVO board);
	public boolean remove(Long bno);
	
	
}
