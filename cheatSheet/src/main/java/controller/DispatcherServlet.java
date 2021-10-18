package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Member.InsertMemberDB;
import controller.Member.LoginAction;
import controller.Member.LoginMoveAction;
import controller.board.GoMianAction;
import controller.board.InsertBoardDB;
import controller.board.SelectOneAction;

/**
 * Servlet implementation class FrontController
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());
		
		ActionForward forward =null;
		if(action.equals("/login.do")) {
			forward = new LoginMoveAction().execute(request, response);
		}
		else if(action.equals("/loginAction.do")) {
			forward = new LoginAction().execute(request, response);
		}
		else if(action.equals("/main.do")) {
			forward = new GoMianAction().execute(request, response);
		}
		else if(action.equals("/selectOneBorad.do")) {
			forward = new SelectOneAction().execute(request, response);
		}
		else if(action.equals("/insertMemberDB.do")) {
			forward = new InsertMemberDB().execute(request, response);
		}
		else if(action.equals("/insertBoardDB.do")) {
			forward = new InsertBoardDB().execute(request, response);
		}
		else {
			forward.setPath("error404.jsp");
			forward.setRedirect(false);
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
		
	}
}
