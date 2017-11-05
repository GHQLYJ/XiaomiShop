package com.xiaomi.user.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaomi.bean.User;
import com.xiaomi.service.UserService;
import com.xiaomi.util.IsValidate;

public class UserRegisterAction extends ActionSupport {

	private User user;

	private UserService service;

	private boolean result;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {

		service.addUser(user);

		if (result) {
			return SUCCESS;
		}

		return INPUT;
	}

	@Override
	public void validate() {

		HttpSession session = ServletActionContext.getRequest().getSession();

		String inCode = ServletActionContext.getRequest().getParameter(
				"validateCode");

		String code = (String) session.getAttribute("code");

		String message = (String) session.getAttribute("message");

		System.out.println("incode:" + inCode);
		System.out.println("code:" + code);
		System.out.println("message:" + message);

		IsValidate is = new IsValidate();

		result = is.isValidate(inCode, code);

		if (result == false) {

			addFieldError("phoneMessge", "验证码错误！");

		}

	}

}
