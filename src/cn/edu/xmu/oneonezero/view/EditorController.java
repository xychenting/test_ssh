package cn.edu.xmu.oneonezero.view;

import cn.edu.xmu.oneonezero.entity.RecommendRead;
import cn.edu.xmu.oneonezero.service.RecommendReadManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 主编
 * Created by Fernando on 2015/12/1.
 */
@Controller
@RequestMapping("/editor")
public class EditorController {
    @Resource(name="recommendReadManager")
    private RecommendReadManager recommendReadManager;

    @RequestMapping("/getNews")
    public String getNews(long newsId,HttpServletRequest request){
        request.setAttribute("RR",recommendReadManager.getReccomendRead(newsId));
        return "editorinchief_checks";
    }

    @RequestMapping("/examineNews")
    public String examineNews(RecommendRead recommendRead,String type,HttpServletRequest request){
        if(type.equals("1")) {
        	recommendRead.setIsExamined(true);
        	recommendRead.setIsPassed(true);
            recommendReadManager.updateRecommendRead(recommendRead);
            request.setAttribute("RR", recommendRead);
            return "editorinchief_rr_edit";
        }
        else {
            recommendRead.setIsExamined(true);
            recommendRead.setIsPassed(true);
            recommendReadManager.updateRecommendRead(recommendRead);
            return "editorinchief_rr_2";
        }
    }

    @RequestMapping("/setNews")
    public String setNews(HttpServletRequest request){
    	RecommendRead recommendRead=(RecommendRead) request.getAttribute("RR");
        recommendRead.setRank(request.getParameter("rank"));
        recommendRead.setOnShowTime(request.getParameter("txtDate"));
        recommendReadManager.updateRecommendRead(recommendRead);
        return "redirect:/editor/getAllExamined";
    }

    @RequestMapping("/getAllExamined")
    public String getAllExamined(HttpServletRequest request){
        request.setAttribute("examineNewsList", recommendReadManager.getAllExaminedRecommendRead());
        return "editorinchief_rr_2";
    }
    @RequestMapping("/getExaminedByNewsName")
    public String getExaminedByNewsName(HttpServletRequest request){
        request.setAttribute("examineNewsList", recommendReadManager.getAllExaminedRecommendReadByName(request.getParameter("RRname")));
        return "editorinchief_rr_2";
    }

    @RequestMapping("/getAllUnreviewed")
    public String getAllUnreviewed(HttpServletRequest request){
        request.setAttribute("RRLIST",recommendReadManager.getAllUnexaminedRecommendRead());
        return "editorinchief_rr_1";
    }

    @RequestMapping("/getUnreviewedByNewsName")
    public String getUnreviewedByNewsName(HttpServletRequest request){
        request.setAttribute("RRLIST",recommendReadManager.getAllUnexaminedRecommendReadByName(request.getParameter("RRname")));
        return "editorinchief_rr_1";
    }
}
