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
import model.bo.WorkTimeBO;

/**
 * Servlet implementation class Ad_task
 */
@WebServlet("/Ad_task")
public class Ad_task extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaskBO taskBO;
    private WorkTimeBO workTimeBO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ad_task() {
        super();
        taskBO = new TaskBO();
        workTimeBO = new WorkTimeBO();
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
		ArrayList<Task> tasks = taskBO.getTaskList();
		ArrayList<Worker> workers = workTimeBO.getRegisterList();
		request.setAttribute("tasks", tasks);
		request.setAttribute("workers", workers);
		// Trả lại các thông số mà người dùng đã nhập
		request.getRequestDispatcher("/WEB-INF/admin/ad-task.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
