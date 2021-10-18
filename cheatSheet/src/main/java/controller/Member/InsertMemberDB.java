package controller.Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.member.MemberDAO;
import model.member.MemberVO;

public class InsertMemberDB implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward action = new ActionForward();
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		dao.insert(vo);
		action.setPath("index.jsp");
		action.setRedirect(false);
		return action;
	}

}
