package app.service;

import app.entity.News;
import app.repo.FeedRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final FeedRepo feedRepo;

    public NewsService(FeedRepo feedRepo) {
        this.feedRepo = feedRepo;
    }

    public List<News> allNews(){
        return feedRepo.findAll();
    }

    public News oneNews(int id){
        return feedRepo.findById(id).get();
    }


}
