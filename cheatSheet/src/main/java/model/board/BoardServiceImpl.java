package model.board;

import java.util.List;

public class BoardServiceImpl implements BoardService{

	BoardDAO dao;
	
	@Override
	public BoardVO getOne(BoardVO vo) {
		BoardVO data = dao.getBoard(vo);
		return data;
	}

	@Override
	public List<BoardVO> getAll(BoardVO vo) {
		// TODO Auto-generated method stub
		List<BoardVO>datas = dao.getBoardList();
		return datas;
	}

	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.updateBoard(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.deleteBoard(vo);
	}

	@Override
	public void insert(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.insertBoard(vo);
	}

}
