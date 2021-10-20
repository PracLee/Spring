package controller.Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.member.MemberDAO;
import model.member.MemberVO;

public class InsertMemberDB implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		dao.insert(vo);

		return "index";
	}

}
