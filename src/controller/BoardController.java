package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.ncs.dao.BoardDAO;
import kh.ncs.dto.BoardDTO;

@WebServlet("*.board")
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDTO bdto = new BoardDTO();

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		try {
			// 커맨드맞는지 확인
			System.out.println(command);
			if (command.equals("/goBoard.board")) {

				// 보여줄수있는 곳으로가야함.
				request.getRequestDispatcher("/BOARD/boardMain.jsp").forward(request, response);

			} else if (command.equals("/goWrite.board")) {
				BoardDAO bdao = new BoardDAO();
				List<BoardDTO> list = new ArrayList<>();
				request.getSession().getAttribute("id");

			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
