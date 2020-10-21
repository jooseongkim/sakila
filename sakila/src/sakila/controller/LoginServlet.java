package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;
import sakila.vo.Stats;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private StatsService statsService;
	private StaffService staffService;

	// 로그인 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		// 로그인 되어있으면 indexServlet으로 넘어가고 안되어있으면 로그인 페이지로
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		Stats todayStats = (Stats) map.get("todayStats");
		int totalCnt = (Integer) map.get("totalCnt");
		request.setAttribute("todayStats", todayStats);
		request.setAttribute("totalCnt", totalCnt);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	// 로그인 액션으로 이동(예정)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		staffService = new StaffService();
		Staff staff = new Staff(); // 리퀘스트 사용

		staff.setStaffId(Integer.parseInt(request.getParameter("staffId")));
		staff.setPassword(request.getParameter("staffPw"));
		System.out.println(staff.getStaffId() + "<--아이디");
		System.out.println(staff.getPassword() + "<--비밀번호");

		Staff returnStaff = staffService.getStaffByKey(staff);
		System.out.println(returnStaff + "<-reurnStaff"); // 확인

		System.out.println(returnStaff.getStaffId() + "<- getstaffId 값 확인");
		System.out.println(returnStaff.getUserName() + "<- getusrName 값 확인");

		HttpSession session = request.getSession();

		if (returnStaff == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		} else {
			session.setAttribute("loginStaff", returnStaff.getStaffId());
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
		}
	}
}
