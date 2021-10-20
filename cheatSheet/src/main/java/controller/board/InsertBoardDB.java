package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;
import model.member.MemberVO;

public class InsertBoardDB implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO bvo = new BoardVO();
		BoardDAO bdao = new BoardDAO();
		HttpSession session = request.getSession();
		MemberVO mvo = new MemberVO();
		mvo = (MemberVO)session.getAttribute("member");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		bvo.setWriter(mvo.getName());
		bvo.setTitle(title);
		bvo.setContent(content);
		bdao.insertBoard(bvo);
		
		
		return "main.do";
	}

}
