package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �û���¼��ȫ���ƹ�����
 * 
 * @author lcs
 *
 */
public class SessionFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// �漰��HTTP������ת�ʹ���
		HttpServletRequest hrequest = (HttpServletRequest) request;
		// �漰��HTTP������ת�ʹ���
		HttpServletResponse hresponse = (HttpServletResponse) response;
		// �ж��û��Ƿ�����˵�¼������session���Ƿ�洢�û���
		String loginUser = (String) hrequest.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			// δ��¼��ϵͳǿ���ض�������¼ҳ��
			hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp?flag=1");
			return;
		} else {
			chain.doFilter(hrequest, hresponse);
			return;
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
