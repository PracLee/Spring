package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;

public class SelectOneAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward action = new ActionForward();
		int id = Integer.parseInt(request.getParameter("id"));
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		vo.setId(id);
		vo = dao.getBoard(vo);
		request.setAttribute("data", vo);
		action.setPath("showBoard.jsp");
		action.setRedirect(false);

		return action;
	}

}
