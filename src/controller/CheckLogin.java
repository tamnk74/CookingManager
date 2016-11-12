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
import model.bean.Task;
import model.bo.TaskBO;
import model.bo.UserBO;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserBO userBO;
    private TaskBO taskBO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        userBO = new UserBO();
        taskBO = new TaskBO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// Kiểm tra quyền hạn.
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userBO.getUser(username, password);
		if(user != null){
			session.setAttribute("user", user);
			if(user.isAdmin())	{
				
				request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/task.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("message", "Tài khoản không đúng!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		// Trả lại các thông số mà người dùng đã nhập
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
