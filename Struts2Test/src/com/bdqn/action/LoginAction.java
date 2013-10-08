package com.bdqn.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bdqn.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	//������һ���޲εĹ��췽��
	//�����������������һ�£��ṩget/set������û�в���Ҫд
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
		//����session����Servlet API�й�
		//HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String, Object> map=ActionContext.getContext().getSession();
		//����session:��API�޹�
		//request
		ActionContext.getContext().put("aaa", uname);
		
		if(isok){
			return "succ";
		}
		return "fail";
	}
}
