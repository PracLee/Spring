package model.board;

import java.util.List;

public interface BoardService {
	public BoardVO getOne(BoardVO vo);
	public List<BoardVO> getAll(BoardVO vo);
	public void update(BoardVO vo);
	public void delete(BoardVO vo);
	public void insert(BoardVO vo);
}
