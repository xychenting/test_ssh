package cn.edu.xmu.oneonezero.view;

import cn.edu.xmu.oneonezero.entity.RecommendRead;
import cn.edu.xmu.oneonezero.service.RecommendReadManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 采编
 * Created by Fernando on 2015/12/1.
 */
@Controller
@RequestMapping("/editing")
public class EditingController {

    @Resource(name="recommendReadManager")
    private RecommendReadManager recommendReadManager;

    @RequestMapping(value="/addNews",method = RequestMethod.GET)
    public String addNews(HttpServletRequest request){
    	RecommendRead recommendRead=new RecommendRead();
    	recommendRead.setName(request.getParameter("RRname"));
    	recommendRead.setContent(request.getParameter("RRcontent"));
    	recommendRead.setPicUrl(request.getParameter("img"));
//    	recommendRead.setCollector(request.get..getClass().);//TODO 获取登录后采编名称
        recommendReadManager.insertRecommendRead(recommendRead);
        return "成功"; //TODO
    }

    @RequestMapping("/editNews")
    public String editNews(HttpServletRequest request){
    	RecommendRead recommendRead=(RecommendRead) request.getAttribute("RR");
    	recommendRead.setName(request.getParameter("RRname"));
    	recommendRead.setContent(request.getParameter("RRcontent"));
    	recommendRead.setPicUrl(request.getParameter("img"));
        recommendReadManager.updateRecommendRead(recommendRead);
        return "成功";
    }

    @RequestMapping("/delNews")
    public String delNews(long newsId,HttpServletRequest request){
        recommendReadManager.delRecommendRead(newsId);//删除审核未通过和未审核
        return "成功";
    }

    @RequestMapping("/getAllNewsPush")
    public String getAllNewsPush(String userId,HttpServletRequest request){
        request.setAttribute("newsList", recommendReadManager.getAllRecommendReadByCollector(userId));
        return "登录进入首页";
    }


    //获取所有未审核
    @RequestMapping("/getAllUnreviewed")
    public String getAllUnreviewed(String userName,HttpServletRequest request){
        request.setAttribute("RRLIST",recommendReadManager.getAllUnexaminedRecommendReadByCollectorName(userName));//TODO
        return "editor_rr_1";
    }

    @RequestMapping("getUnreviewedByNewsName")
    public String getUnreviewedByNewsName(String newsName,HttpServletRequest request){
        request.setAttribute("RRLIST",recommendReadManager.getAllUnexaminedRecommendReadByName(newsName));//TODO
        return  "editor_rr_1";
    }

    //未通过
    @RequestMapping("/getAllFailPass")
    public String getAllFailPass(String userName,HttpServletRequest request){
        request.setAttribute("RRLIST",recommendReadManager.getAllUnPassedRecommendReadByCollectorName(userName));//TODO
        return "editor_rr_2";
    }

    @RequestMapping("getFailPassByNewsName")
    public String getFailPassByNewsName(HttpServletRequest request){
        request.setAttribute("RRLIST",recommendReadManager.getAllUnPassedRecommendReadByRecommendReadName(request.getParameter("RRname")));//TODO
        return  "editor_rr_2";
    }

    //已通过
    @RequestMapping("/getAllSuccessPass")
    public String getAllSuccessPass(String userName,HttpServletRequest request){
        request.setAttribute("RRLIST",recommendReadManager.getAllPassedRecommendReadByCollectorName(userName));//TODO
        return "editor_rr_3";
    }

    @RequestMapping("getSuccessPassByNewsName")
    public String getSuccessPassByNewsName(HttpServletRequest request){
        request.setAttribute("RRLIST",recommendReadManager.getAllPassedRecommendReadByRecommendReadName(request.getParameter("RRname")));//TODO
        return  "editor_rr_3";
    }

    @RequestMapping("/getNews")
    public String getNews(long newsId,HttpServletRequest request){
        request.setAttribute("RR",recommendReadManager.getReccomendRead(newsId));
        return "editor_rr_edit";
    }
}
