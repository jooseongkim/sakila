package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {


    public DBListener() {
        
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("DBListener.contextInitialized() ���� Ȯ��");
        try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("mariaDB ����̺� �ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName() ���� ����");
			e.printStackTrace();
		}
    }
	
}