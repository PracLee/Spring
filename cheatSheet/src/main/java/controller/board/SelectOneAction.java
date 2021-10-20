package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class SelectOneAction implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		vo.setId(id);
		vo = dao.getBoard(vo);
		request.setAttribute("data", vo);


		return "showBoard";
	}

}
