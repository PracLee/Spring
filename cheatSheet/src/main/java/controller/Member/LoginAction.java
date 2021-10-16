package controller.Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward action = new ActionForward();
		MemberVO mvo = new MemberVO();
		MemberDAO mdao = new MemberDAO();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		mvo.setId(id);
		mvo.setPw(pw);
		mvo = mdao.getOne(mvo);
		if(mvo!=null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("member", mvo);
			action.setPath("main.do");
			action.setRedirect(false);			
		}else {
			// 로그인 실패
			action.setPath("index.jsp");
			action.setRedirect(false);
		}
		return action;
	}

}
