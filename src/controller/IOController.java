package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.ncs.dao.InOutDAO;
import kh.ncs.dto.InOutDTO;


@WebServlet("*.io")
public class IOController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		InOutDAO dao = null;
		try {
		dao= new InOutDAO();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(command.equals("/input.io")) {
			String name=request.getParameter("name");
			String msg = request.getParameter("msg");
			InOutDTO dto = new InOutDTO(0,name,msg);
			int result=dao.insert(dto);
			request.setAttribute("result", result);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(command.equals("/output.io")) {
			List <InOutDTO> result = dao.output();
			request.setAttribute("List", result);
			request.getRequestDispatcher("output.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
