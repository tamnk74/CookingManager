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
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBO userBO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccount() {
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
		String fullname = request.getParameter("fullname");
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setFullname(fullname);
		if(userBO.updateUser(newUser)) request.setAttribute("message", "An account has been updated successfully!");
		else request.setAttribute("error", "Failed to update this account!");;
		
		ArrayList<User> users = userBO.getListUser();
		request.setAttribute("users", users);
		// Trả lại các thông số mà người dùng đã nhập
		request.getRequestDispatcher("/WEB-INF/admin/account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
