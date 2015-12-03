package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.RecommendRead;

public interface RecommendReadManager {  

//为view层提供直接调用的接口
public RecommendRead  getReccomendRead(long id);  

public void insertRecommendRead(RecommendRead rr);  

public boolean delRecommendRead(long id);  

public boolean updateRecommendRead(RecommendRead rr);

public List<RecommendRead> getAllRecommendReadByCollector(String collectorId);//根据采编id得到所有的软文

public List<RecommendRead> getAllExaminedRecommendReadByCollector(String collectorId);//根据采编id得到所有已经审核的软文

public List<RecommendRead> getAllUnexaminedRecommendReadByCollector(String collectorId);//根据采编id得到所有未审核的软文



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