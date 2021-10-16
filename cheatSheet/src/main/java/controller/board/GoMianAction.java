package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;

public class GoMianAction implements Action{
	@Autowired
	BoardVO bvo;
	@Autowired
	BoardDAO bdao;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward action = new ActionForward();
		List<BoardVO> datas = bdao.getBoardList();
		request.setAttribute("datas", datas);
		action.setPath("main.jsp");
		action.setRedirect(false);
		return action;
	}

}
