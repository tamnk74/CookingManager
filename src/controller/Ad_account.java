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
import model.bo.TaskBO;
import model.bo.UserBO;

/**
 * Servlet implementation class Ad_account
 */
@WebServlet("/Ad_account")
public class Ad_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaskBO taskBO;
    private UserBO userBO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ad_account() {
        super();
        taskBO = new TaskBO();
        userBO = new UserBO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// Kiểm tra quyền hạn.
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null ) request.getRequestDispatcher("index.jsp").forward(request, response);
		ArrayList<User> users = userBO.getListUser();
		request.setAttribute("users", users);
		// Trả lại các thông số mà người dùng đã nhập
		request.getRequestDispatcher("/WEB-INF/ad-account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
