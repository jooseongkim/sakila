package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener {
	// 세션 접속시 
	private StatsService statsService;
	public StatsListener() {
	}

	public void sessionCreated(HttpSessionEvent se) {
		if (se.getSession().isNew()) {
			//세션이 원래 있었는지 아니면 새로 생성된거인지 확인해야함
			statsService = new StatsService();
			statsService.countStats();
			//없으면 새로 세션을 생성해주고 있으면 카운트
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	}
}
