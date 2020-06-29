package app.controller;

import app.entity.News;
import app.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @GetMapping
    public String getAllNews(Model model){

        List<News> news = newsService.allNews();
        model.addAttribute("news", news);
        return "main-page";


    }
}
