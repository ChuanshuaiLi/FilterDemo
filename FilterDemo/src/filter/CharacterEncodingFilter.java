package filter;

/**
 * �ַ������������
 * @author lcs
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//�ַ������������
public class CharacterEncodingFilter implements Filter {
	
	//��ȡ��������
	private FilterConfig config;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//��������б��뼯����,������ı��뼯���ó�web.xml���õı���
		request.setCharacterEncoding(config.getInitParameter("charset"));// ���ݹ����������ַ��������������ַ�������

		 System.out.println("characterEncodingFilter ����Ԥ����");//���Թ�������������������ʹ��
		//���߹����������Խ�����һ�������ش���
		chain.doFilter(request, response);
		// System.out.println("characterEncodingFilter ��Ӧ����");//���Թ�������������������ʹ��

	}

	@Override
	//��ʼ������
	public void init(FilterConfig config) throws ServletException {
		this.config = config;

	}

	//	getter setter
	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}

}
