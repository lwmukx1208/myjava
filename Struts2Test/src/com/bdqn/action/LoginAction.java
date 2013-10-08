package com.bdqn.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bdqn.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	//必须有一个无参的构造方法
	//属性名和请求参数名一致，提供get/set方法，没有不需要写
	private String uname="";
	private String upwd="";
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public LoginAction(){}
	public String execute(){
		UserService us=new UserService();
		boolean isok=us.login(uname, upwd);
		//启动session：与Servlet API有关
		//HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String, Object> map=ActionContext.getContext().getSession();
		//启动session:与API无关
		//request
		ActionContext.getContext().put("aaa", uname);
		
		if(isok){
			return "succ";
		}
		return "fail";
	}
}
