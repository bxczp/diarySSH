package com.bx.action;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.bx.entity.User;
import com.bx.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @date 2016年4月7日 LoginAction.java
 * @author CZP
 * @parameter
 */
@Controller
public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;

	private User user;
	private HttpServletRequest request;
	private String rember;
	private HttpServletResponse response;

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	public String login() throws Exception {
		User currentUser = userService.login(user);
		if (currentUser != null) {
			if ("rember".equals(rember)) {
				this.remberMe(user);
			}
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", currentUser);
			return "success";
		} else {
			request.setAttribute("errorMsg", "用户名或密码错误");
			request.setAttribute("user", currentUser);
			return "error";
		}
	}

	private void remberMe(User user) {
		Cookie cookie = new Cookie("user", user.getUserName() + "-" + user.getPassword());
		// 秒为单位
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRember() {
		return rember;
	}

	public void setRember(String rember) {
		this.rember = rember;
	}

	@Override
	public void setServletResponse(HttpServletResponse resp) {
		this.response = resp;
	}

}
