package app.controller;


import app.entity.Articles;
import app.entity.News;
import app.entity.Tech;
import app.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        //apiService.getNews();
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

    @RequestMapping("/search-detail/")
    public String searchDetail(@ModelAttribute("search") String search, Model model){
        List<Articles> searchedNews = apiService.searchedNews(search);
        model.addAttribute("news", searchedNews);
        return "search";

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
