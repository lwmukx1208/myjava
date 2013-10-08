package com.bdqn.dao.imp;
import org.hibernate.Query;
import org.hibernate.Session;

import com.bdqn.dao.IUsersDAO;
import com.bdqn.facory.HibernateSessionFactory;
import com.bdqn.pojo.Users;

public class UsersDAOImp implements IUsersDAO {

	public Users findByAll(String parUname) {
		Session session=HibernateSessionFactory.getSession();
		String hql="from Users u where u.uname=?";
		Query query=session.createQuery(hql);
		query.setString(0, parUname);
		Users u=(Users)query.uniqueResult();
		return u;
	}
}
