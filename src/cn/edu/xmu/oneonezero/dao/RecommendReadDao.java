package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.RecommendRead;

public interface RecommendReadDao {


public RecommendRead getRecommendRead(long id);  //根据软文ID得到对象

public void insertRecommendRead(RecommendRead rr);  //添加到数据库

public boolean delRecommendRead(long id);	//根据id删除对象

public boolean updateReccomendRead(RecommendRead rr);	//更新

public List<RecommendRead> getAllRecommendReadByCollector(String collector);

public List<RecommendRead> getAllUnexaminedRecommendReadByCollector(String collector);//未审核

public List<RecommendRead> getAllExaminedRecommendReadByCollector(String collector);//已经审核





public List<RecommendRead> getAllExaminedRecommendRead();//得到所有经过审核的软文

public List<RecommendRead> getAllUnexaminedRecommendRead();//得到所有未审核的软文

public List<RecommendRead> getAllExaminedRecommendReadByName(String recommendReadName);//根据软文名字得到所有经过审核的软文

public List<RecommendRead> getAllUnexaminedRecommendReadByName(String recommendReadName);//根据软文名字得到所有未审核的软文

public List<RecommendRead> getAllUnexaminedRecommendReadByCollectorName(String collectorName);//根据采编名字得到所有 未审核 的软文

public List<RecommendRead> getAllUnPassedRecommendReadByCollectorName(String collectorName);//根据采编名字得到所有 审核未通过 的软文

public List<RecommendRead> getAllPassedRecommendReadByCollectorName(String collectorName);//根据采编名字得到所有 审核通过 的软文

public List<RecommendRead> getAllUnPassedRecommendReadByRecommendReadName(String recommendReadName);//根据软文名字得到所有 审核未通过 的软文

public List<RecommendRead> getAllPassedRecommendReadByRecommendReadName(String recommendReadName);//根据软文名字得到所有 审核通过 的软文


}