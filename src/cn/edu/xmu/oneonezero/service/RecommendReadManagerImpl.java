package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.RecommendReadDao;
import cn.edu.xmu.oneonezero.dao.UserDao;
import cn.edu.xmu.oneonezero.entity.RecommendRead;
import cn.edu.xmu.oneonezero.entity.User;

public class RecommendReadManagerImpl implements RecommendReadManager {

	private RecommendReadDao recommendReadDao; //创建一个UserDao实例

	public void setRecommendReadDao(RecommendReadDao recommendReadDao) {  
	    this.recommendReadDao=recommendReadDao;
	}
	

	@Override
	public boolean delRecommendRead(long id) {
		return recommendReadDao.delRecommendRead(id);
	}


	@Override
	public RecommendRead getReccomendRead(long id) 
	{
		return recommendReadDao.getRecommendRead(id);
	}

	@Override
	public void insertRecommendRead(RecommendRead rr)
	{
		recommendReadDao.insertRecommendRead(rr);
	}
	

	@Override
	public boolean updateRecommendRead(RecommendRead rr) {
		return recommendReadDao.updateReccomendRead(rr);
	}


	@Override
	public List<RecommendRead> getAllRecommendReadByCollector(String collector) {
		return recommendReadDao.getAllRecommendReadByCollector(collector);
	}


	@Override
	public List<RecommendRead> getAllExaminedRecommendReadByCollector(String collector) {
		return recommendReadDao.getAllExaminedRecommendReadByCollector(collector);
	}



	@Override
	public List<RecommendRead> getAllUnexaminedRecommendReadByCollector(String collector) {
		return recommendReadDao.getAllUnexaminedRecommendReadByCollector(collector);
	}


	@Override
	public List<RecommendRead> getAllExaminedRecommendRead() {
		return recommendReadDao.getAllExaminedRecommendRead();
	}


	@Override
	public List<RecommendRead> getAllUnexaminedRecommendRead() {
		return recommendReadDao.getAllUnexaminedRecommendRead();
	}


	@Override
	public List<RecommendRead> getAllExaminedRecommendReadByName(String recommendReadName) {
		return recommendReadDao.getAllExaminedRecommendReadByName(recommendReadName);
	}


	@Override
	public List<RecommendRead> getAllUnexaminedRecommendReadByName(String recommendReadName) {
		return recommendReadDao.getAllUnexaminedRecommendReadByName(recommendReadName);
	}


	@Override
	public List<RecommendRead> getAllUnexaminedRecommendReadByCollectorName(String collectorName) {
		return recommendReadDao.getAllUnexaminedRecommendReadByCollectorName(collectorName);
	}


	@Override
	public List<RecommendRead> getAllUnPassedRecommendReadByCollectorName(String collectorName) {
		return recommendReadDao.getAllUnPassedRecommendReadByCollectorName(collectorName);
	}


	@Override
	public List<RecommendRead> getAllPassedRecommendReadByCollectorName(String collectorName) {
		return recommendReadDao.getAllPassedRecommendReadByCollectorName(collectorName);
	}


	@Override
	public List<RecommendRead> getAllUnPassedRecommendReadByRecommendReadName(String recommendReadName) {
		return recommendReadDao.getAllUnPassedRecommendReadByRecommendReadName(recommendReadName);
	}


	@Override
	public List<RecommendRead> getAllPassedRecommendReadByRecommendReadName(String recommendReadName) {
		return recommendReadDao.getAllPassedRecommendReadByRecommendReadName(recommendReadName);
	}
	
}
