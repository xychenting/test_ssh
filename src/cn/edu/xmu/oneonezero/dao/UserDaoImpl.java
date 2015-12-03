package cn.edu.xmu.oneonezero.dao;



import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.User;


public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	


	@Override
	public boolean delUser(long id) {
		String hql = "delete User u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public User getUser(long id) {
		
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (User)query.uniqueResult();
	}


	@Override
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean updateUser(User user) {
		String hql = "update User u set u.address= ?,u.bankCardAccount=?,u.headPhoto=?,"
				+ "u.mobile=?,u.name=?,u.password=?,u.ps=?,u.role=? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getAddress());
		query.setString(1, user.getBankCardAccount());
		query.setString(2, user.getHeadPhoto());
		query.setString(3, user.getMobile());
		query.setString(4, user.getName());
		query.setString(5, user.getPassword());
		query.setString(6, user.getPs());
		query.setString(7, user.getRole());
		query.setLong(8, user.getId());
		
		return (query.executeUpdate() > 0);
		
	}
	
	
	
	
	

}
