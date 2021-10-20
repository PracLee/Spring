package controller.Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
			return "main.do";
		}else {
			// 로그인 실패
			return "index";	// viewResolver가 경로를 완성시켜줄 것이기 때문에 .jsp가 필요 없음!
		}
	}

}
