package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StatsService;
import sakila.vo.Stats;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private StatsService statsService;

	// �α��� ������ �̵�
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		//�α��� �Ǿ������� indexServlet���� �Ѿ�� �ȵǾ������� �α��� ��������
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		Stats todayStats = (Stats)map.get("todayStats");
		int totalCnt = (Integer) map.get("totalCnt");
		request.setAttribute("todayStats", todayStats);
		request.setAttribute("totalCnt", totalCnt);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	// �α��� �׼����� �̵�(����)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
