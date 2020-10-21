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

	// �α��� ������ �̵�
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		// �α��� �Ǿ������� indexServlet���� �Ѿ�� �ȵǾ������� �α��� ��������
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		Stats todayStats = (Stats) map.get("todayStats");
		int totalCnt = (Integer) map.get("totalCnt");
		request.setAttribute("todayStats", todayStats);
		request.setAttribute("totalCnt", totalCnt);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	// �α��� �׼����� �̵�(����)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		staffService = new StaffService();
		Staff staff = new Staff(); // ������Ʈ ���

		staff.setStaffId(Integer.parseInt(request.getParameter("staffId")));
		staff.setPassword(request.getParameter("staffPw"));
		System.out.println(staff.getStaffId() + "<--���̵�");
		System.out.println(staff.getPassword() + "<--��й�ȣ");

		Staff returnStaff = staffService.getStaffByKey(staff);
		System.out.println(returnStaff + "<-reurnStaff"); // Ȯ��

		System.out.println(returnStaff.getStaffId() + "<- getstaffId �� Ȯ��");
		System.out.println(returnStaff.getUserName() + "<- getusrName �� Ȯ��");

		HttpSession session = request.getSession();

		if (returnStaff == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		} else {
			session.setAttribute("loginStaff", returnStaff.getStaffId());
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
		}
	}
}
