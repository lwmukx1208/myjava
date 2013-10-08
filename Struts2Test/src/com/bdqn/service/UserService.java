package com.bdqn.service;

import com.bdqn.dao.imp.UsersDAOImp;
import com.bdqn.pojo.Users;

public class UserService {
	public boolean login(String uname,String upwd){
		UsersDAOImp ud=new UsersDAOImp();
		Users u=ud.findByAll(uname);
		if(u!=null){
			if(u.getUpwd().equals(upwd)){
				return true;
			}
		}
		return false;
	}
}
