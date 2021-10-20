package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class GoMianController implements Controller{
	BoardVO bvo;
	BoardDAO bdao;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardVO> datas = bdao.getBoardList();
		request.setAttribute("datas", datas);

		return "main";
	}

}
