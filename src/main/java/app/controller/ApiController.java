package app.controller;


import app.entity.Articles;
import app.entity.Tech;
import app.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/news")
    public Tech news(){
        return apiService.getNews();
    }

  /*  @GetMapping("/allnews")
    public String news(Model model) {
        List<Tech> articles = apiService.allNews();
        model.addAttribute("news", articles);
        return "main-page";
    }*/

    /*@GetMapping("/allnews")
    public ModelAndView allNews() {
        List<Articles> articles = apiService.allNews();
        ModelAndView mav = new ModelAndView("main-page");
        mav.addObject("news", articles);
        return mav;
    }*/
}
