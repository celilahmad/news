package app.controller;

import app.entity.Tech;
import app.service.TestApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RController {

    private final TestApi test;

    public RController(TestApi test) {
        this.test = test;
    }

    @GetMapping
    public Tech handle(){
        return test.getNews();
    }
}
