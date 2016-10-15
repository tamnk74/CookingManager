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
import model.bo.SchedulerBO;

/**
 * Servlet implementation class CreateScheduler
 */
@WebServlet("/CreateScheduler")
public class CreateScheduler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SchedulerBO schedulerBO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateScheduler() {
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
		
		// Trả lại các thông số mà người dùng đã nhập
		int week = schedulerBO.getNextWeek();
		if(schedulerBO.createScheduler(week)){
			request.setAttribute("msg", "Tạo lịch thành công!");
		};
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
