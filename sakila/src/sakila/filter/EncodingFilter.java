package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	public EncodingFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncodingFilter ���� : reqeuest utf-8 ���ڵ� Ȯ�ο�");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

// final | static
// thorws Exception
// try | catch | finally
// connection commit | rollback
// List / Map(ex: HashMap) / Set (ex: hashSet)
// ArrayList / HashMap / ResultSet

//1. filter
//2. servlet
//3. listener
