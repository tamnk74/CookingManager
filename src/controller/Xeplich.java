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
import model.bo.SchedulerBO;

/**
 * Servlet implementation class Xeplich
 */
@WebServlet("/Xeplich")
public class Xeplich extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SchedulerBO schedulerBO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xeplich() {
        super();
        schedulerBO = new SchedulerBO();
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
		
		schedulerBO.createScheduler(schedulerBO.getNextWeek());
		// Trả lại các thông số mà người dùng đã nhập
		request.getRequestDispatcher("Ad_task").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
