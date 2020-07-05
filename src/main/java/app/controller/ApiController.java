package app.controller;


import app.entity.Articles;
import app.entity.News;
import app.entity.Tech;
import app.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    /*@GetMapping("/news")
    public Tech news(){
        return apiService.getNews();
    }*/

    @GetMapping("/allnews")
    public String news(Model model) {
        List<Articles> articles = apiService.limitedNews();
        model.addAttribute("news", articles);
        return "main-page";
    }

    @RequestMapping("/detail/{id}")
    public String newsDetail(@ModelAttribute("id") int id, Model model){
        Articles news = apiService.oneArticle(id);
        model.addAttribute("detail", news);
        return "news-detail";

    }

    @RequestMapping("/mynews/")
    public String newsDetail(Model model){
        List<Articles> articles = apiService.allNews();
        model.addAttribute("all", articles);
        return "disable-news";

    }

    /*@GetMapping("/allnews")
    public ModelAndView allNews() {
        List<Articles> articles = apiService.allNews();
        ModelAndView mav = new ModelAndView("main-page");
        mav.addObject("news", articles);
        return mav;
    }*/
}
