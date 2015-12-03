package cn.edu.xmu.oneonezero.dao;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.RecommendRead;
import cn.edu.xmu.oneonezero.entity.User;


public class RecommendReadDaoImpl implements RecommendReadDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public RecommendRead getRecommendRead(long id) {
		String hql = "from RecommendRead rr where rr.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (RecommendRead)query.uniqueResult();
	}

	@Override
	public void insertRecommendRead(RecommendRead rr) {
		sessionFactory.getCurrentSession().save(rr);
	}

	@Override
	public boolean delRecommendRead(long id) {
		String hql = "delete RecommendRead rr where rr.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateReccomendRead(RecommendRead rr) {
		String hql = "update RecommendRead rr set rr.chiefEditor= ?,rr.collector=?,rr.content=?,"
				+ "rr.offShowTime=?,rr.onShowTime=?,rr.picUrl=?,rr.rank=?,rr.isExamined=?,rr.isPassed=? where rr.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, rr.getChiefEditor());
		query.setString(1, rr.getCollector());
		query.setString(2, rr.getContent());
		query.setString(3, rr.getOffShowTime());
		query.setString(4, rr.getOnShowTime());
		query.setString(5, rr.getPicUrl());
		query.setString(6, rr.getRank());
		query.setBoolean(7, rr.getIsExamined());
		query.setBoolean(8, rr.getIsPassed());
		query.setLong(9, rr.getId());
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public List<RecommendRead> getAllRecommendReadByCollector(String collector) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(((RecommendRead)query.list().get(i)).getCollector()==collector)
				alist.add((RecommendRead)query.list().get(i));
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllUnexaminedRecommendReadByCollector(String collector) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(((RecommendRead)query.list().get(i)).getCollector()==collector)
			{
				if(!((RecommendRead)query.list().get(i)).getIsExamined())
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllExaminedRecommendReadByCollector(String collector) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(((RecommendRead)query.list().get(i)).getCollector()==collector)
			{
				if(((RecommendRead)query.list().get(i)).getIsExamined())
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllExaminedRecommendRead() {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(((RecommendRead)query.list().get(i)).getIsExamined())
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllUnexaminedRecommendRead() {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(!(((RecommendRead)query.list().get(i)).getIsExamined()))
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllExaminedRecommendReadByName(String recommendReadName) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((RecommendRead)query.list().get(i)).getName()==recommendReadName)&&((RecommendRead)query.list().get(i)).getIsExamined())
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllUnexaminedRecommendReadByName(String recommendReadName) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((RecommendRead)query.list().get(i)).getName()==recommendReadName)&&!(((RecommendRead)query.list().get(i)).getIsExamined()))
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllUnexaminedRecommendReadByCollectorName(String collectorName) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((RecommendRead)query.list().get(i)).getCollector()==collectorName)&&!(((RecommendRead)query.list().get(i)).getIsExamined()))
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllUnPassedRecommendReadByCollectorName(String collectorName) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((RecommendRead)query.list().get(i)).getCollector()==collectorName)&&((RecommendRead)query.list().get(i)).getIsExamined()&&!(((RecommendRead)query.list().get(i)).getIsPassed()))
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllPassedRecommendReadByCollectorName(String collectorName) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((RecommendRead)query.list().get(i)).getCollector()==collectorName)&&((RecommendRead)query.list().get(i)).getIsExamined()&&(((RecommendRead)query.list().get(i)).getIsPassed()))
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllUnPassedRecommendReadByRecommendReadName(String recommendReadName) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((RecommendRead)query.list().get(i)).getName()==recommendReadName)&&((RecommendRead)query.list().get(i)).getIsExamined()&&(!((RecommendRead)query.list().get(i)).getIsPassed()))
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<RecommendRead> getAllPassedRecommendReadByRecommendReadName(String recommendReadName) {
		String hql = "from RecommendRead";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<RecommendRead> alist=new ArrayList<RecommendRead>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((RecommendRead)query.list().get(i)).getName()==recommendReadName)&&((RecommendRead)query.list().get(i)).getIsExamined()&&(((RecommendRead)query.list().get(i)).getIsPassed()))
			{
					alist.add((RecommendRead)query.list().get(i));
			}
		}
		
		return alist;
	}
	
	
	


	
	

}
