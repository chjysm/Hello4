package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.board")
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		// 커맨드맞는지 확인
		System.out.println(command);
		if (command.equals("/goBoard.board")) {

			// 보여줄수있는 곳으로가야함.
			request.getRequestDispatcher("/BOARD/boardView.jsp").forward(request, response);

		} else if (command.equals("/goWrite.board")) {
			String title = request.getParameter("title");
			String contents = request.getParameter("contetns");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
