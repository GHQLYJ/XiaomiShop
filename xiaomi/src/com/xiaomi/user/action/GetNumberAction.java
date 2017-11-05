package com.xiaomi.user.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaomi.bean.User;
import com.xiaomi.service.UserService;
import com.xiaomi.util.GetPhoneNumberUtil;

public class GetNumberAction extends ActionSupport {

	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String execute() throws Exception {
		
		long userPhone = user.getPhone();
		
		String phoneNumber = String.valueOf(userPhone);
		
		System.out.println(phoneNumber);
		
		GetPhoneNumberUtil getPhoneNumberUtil = new GetPhoneNumberUtil();
		
		getPhoneNumberUtil.sendSms(phoneNumber);
		
		//获取是否成功？success：loser
		String messges = getPhoneNumberUtil.isSuccess();
		
		String result = getPhoneNumberUtil.getID();
		
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("code", result);
		session.setAttribute("message", messges);
		
		
		System.out.println("stratu : "+messges);
		System.out.println("code:"+result);

		return NONE;
	}
	
	
	
	
	
	
	
	
	
	

}
