package user;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthenticationFilter implements javax.servlet.Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 当前访问路径
		String currentUrl = req.getRequestURI();
		// 获取session
		// HttpSession session = req.getSession();
		// 如果session为空，或者用户没有登录，则重定向输出登录页面
		// if (session == null | session.getAttribute("name") == null
		// || session.getAttribute("role") == null) {
		// res.sendRedirect(req.getContextPath() + "/index.jsp");
		// return;
		// }

		
		if (!currentUrl.contains("/index.jsp")
			&& !currentUrl.contains("welcome_user")) {
			res.sendRedirect(req.getContextPath() + "/index.jsp");
			return;
		}
		// 如果角色不是admin或者user，则验证失败，用户重新登录。
		// if (!session.getAttribute("role").equals("admin")
		// && !session.getAttribute("role").equals("user")) {
		// session.removeAttribute("name");
		// session.removeAttribute("role");
		// res.sendRedirect(req.getContextPath() + "/index.jsp");
		// return;
		// }
		// 过滤完成，filter链继续向下执行
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
