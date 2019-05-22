package controller;

import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kh.ncs.dao.MemberDAO;
import kh.ncs.dto.MemberDTO;

@WebServlet("*.me")
public class MemberController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		MemberDAO dao = null;
		try {
			dao = new MemberDAO();
		} catch (Exception e) {
			response.sendRedirect("error.html");
		}
		
		if(command.equals("/goIndex.me")) {
			request.getRequestDispatcher("logIndex.jsp").forward(request, response);
		}else if (command.equals("/login.me")) {
			String id =request.getParameter("id");
			String pw =request.getParameter("pw");
			int result=0;
			try {
				result = dao.login(id,pw);
				if(result==0) {
					request.getRequestDispatcher("logIndex.jsp").forward(request, response);
				}else {
					request.getSession().setAttribute("loginID", id);
					request.getRequestDispatcher("logIndex.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
		}else if (command.equals("/goJoinForm.me")) {
			request.getRequestDispatcher("joinForm.jsp").forward(request, response);
		}else if (command.equals("/idCheck.me")) {
			PrintWriter pw = response.getWriter();
			String id=request.getParameter("id");
			try {
				int re=dao.idCheck(id);
				pw.print(re);
			} catch (Exception e) {
				response.sendRedirect("error.html");
			}
		}else if (command.equals("/sign.me")) {
			String id =request.getParameter("id");
			String pw =request.getParameter("pw");
			String name =request.getParameter("name");
			String phone =request.getParameter("phone");
			String email =request.getParameter("email");
			try {
				int result=dao.sign(new MemberDTO(id,pw,name,phone,email));
				request.getRequestDispatcher("logIndex.jsp").forward(request, response);
			} catch (Exception e) {
				response.sendRedirect("error.html");
			}
		}else if(command.equals("/logOut.me")) { // 로그아웃
			request.getSession().invalidate();
			request.getRequestDispatcher("logIndex.jsp").forward(request, response);
		}else if(command.equals("/signOut.me")) {//비밀번호 확인창으로 이동
			request.getRequestDispatcher("leave.jsp").forward(request, response);
		}else if(command.equals("/leave.me")) { //회원탈퇴 
			String id = (String)request.getSession().getAttribute("loginID");
			String pw = request.getParameter("password");
			System.out.println(id +":" + pw);
			int result =0;
			try {
				result = dao.login(id,pw);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 아이디랑 패스워드가 일치하는지 
			
			if(result > 0 ) { // 아이디랑 패스워드가 일치한다면
				System.out.println("일치!");
				
				int deleteMember=0;
				try {
					deleteMember = dao.deleteMember(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 아이디를 이용해서 삭제
				if(deleteMember > 0) {//삭제가 됬으면
					System.out.println("삭제됨");
					request.getSession().invalidate();
				}else {
					System.out.println("삭제안됨");
				}
				request.setAttribute("deleteMember", deleteMember);
				request.getRequestDispatcher("leaveView.jsp").forward(request, response);
			}
		}else if(command.equals("/goToIndex.me")) {//인덱스 페이지로 가기 
			request.getRequestDispatcher("logIndex.jsp").forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
