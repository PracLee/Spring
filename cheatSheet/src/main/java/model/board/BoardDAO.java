package model.board;

import java.util.List;


public class BoardDAO {
	private final String insertSQL="insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateSQL="update board set title=?,content=? where id=?";
	private final String deleteSQL="delete board where id=?";
	private final String getBoardSQL="SELECT * FROM board WHERE id = ? ";
	private final String getBoardListSQL="SELECT * FROM board WHERE content LIKE ? ";


	public void insertBoard(BoardVO vo) {

	}


	public void updateBoard(BoardVO vo) {


	}

	public void deleteBoard(BoardVO vo) {

	}


	public List<BoardVO> getBoardList() {

		return;
	}
	public BoardVO getBoard(BoardVO vo) {
		Object[] args= { vo.getId() };
		return;
	}

}

