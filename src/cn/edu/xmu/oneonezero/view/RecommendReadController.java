package cn.edu.xmu.oneonezero.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.service.RecommendReadManager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 软文推送
 * Created by Fernando on 2015/12/1.
 */
@Controller
@RequestMapping("/newsPush")
public class RecommendReadController {
    @Resource(name = "recommendReadManager")
    private RecommendReadManager recommendReadManager;

    @RequestMapping("/getNews")
    public String getNews(Date startTime,Date endTime,HttpServletRequest request){
//        request.setAttribute("newsList",recommendReadManager.getNewsByTime(startTime,endTime));
        return "home";
    }

}
