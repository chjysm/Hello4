package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.ncs.dao.MemberDAO;


@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(command.equals("logOut.member")) { // 로그아웃
			request.getSession().invalidate();
			request.getRequestDispatcher("logIndex.jsp").forward(request, response);
		}if(command.equals("leave.member")) { //회원탈퇴 
			String id = (String)request.getSession().getAttribute("loginID");
			String pw = request.getParameter("password");
			
			int result = dao.login(id,pw); // 아이디랑 패스워드가 일치하는지 
			
			if(result > 0 ) { // 아이디랑 패스워드가 일치한다면
				int deleteMember = dao.deleteMember(String id); // 아이디를 이용해서 삭제
				
				if(deleteMember > 0) {//삭제가 됬으면
					System.out.println("삭제됨");
				}else {
					System.out.println("삭제안됨");
				}
				request.setAttribute("deleteMember", deleteMember);
				request.getRequestDispatcher("leaveView.jsp").forward(request, response);
			}
			
		}else if(command.equals("goToIndex.member")) {//인덱스 페이지로 가기 
			request.getRequestDispatcher("logIndex.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
