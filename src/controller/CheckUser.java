package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBO userBO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        userBO = new UserBO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// Kiểm tra quyền hạn.
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null ) request.getRequestDispatcher("index.jsp").forward(request, response);
		if(!user.isAdmin()) request.getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
		
		String username = request.getParameter("username");
		String msg;
		
		msg = userBO.isValidUser(username) ? "invalid": "valid";
		response.setContentType("text/plain");
		response.getWriter().write(msg);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
