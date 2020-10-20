package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener {
	// ���� ���ӽ� 
	private StatsService statsService;
	public StatsListener() {
	}

	public void sessionCreated(HttpSessionEvent se) {
		if (se.getSession().isNew()) {
			//������ ���� �־����� �ƴϸ� ���� �����Ȱ����� Ȯ���ؾ���
			statsService = new StatsService();
			statsService.countStats();
			//������ ���� ������ �������ְ� ������ ī��Ʈ
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	}
}
