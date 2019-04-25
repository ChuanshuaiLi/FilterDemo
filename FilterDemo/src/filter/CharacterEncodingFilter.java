package filter;

/**
 * 字符集编码过滤器
 * @author lcs
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//字符集编码过滤器
public class CharacterEncodingFilter implements Filter {
	
	//获取参数对象
	private FilterConfig config;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//对请求进行编码集处理,将请求的编码集设置成web.xml配置的编码
		request.setCharacterEncoding(config.getInitParameter("charset"));// 根据过滤器配置字符集，设置请求字符集编码

		 System.out.println("characterEncodingFilter 请求预处理");//测试过滤器（链）工作流程使用
		//告诉过滤器链可以进行下一步的拦截处理
		chain.doFilter(request, response);
		// System.out.println("characterEncodingFilter 响应后处理");//测试过滤器（链）工作流程使用

	}

	@Override
	//初始化操作
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
