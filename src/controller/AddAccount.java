package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Task;
import model.bean.User;
import model.bean.Worker;
import model.bo.TaskBO;
import model.bo.UserBO;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBO userBO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccount() {
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
		String password = request.getParameter("password");
		boolean isAdmin = request.getParameterValues("isadmin") == null ? false : true;
		
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setFullname(fullname);
		newUser.setAdmin(isAdmin);
		System.out.println(username + password + fullname + isAdmin + request.getParameterValues("isadmin"));
		if(userBO.addUser(newUser)) request.setAttribute("message", "An user has been created successfully!");
		else request.setAttribute("error", "Failed to create new account!");
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
