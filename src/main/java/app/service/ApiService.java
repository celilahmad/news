package app.service;

import app.entity.Articles;
import app.entity.Tech;
import app.repo.ArticlesRepo;
import app.repo.TechRepo;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@Service
public class ApiService {


    private final TechRepo repo;
    private final ArticlesRepo arepo;

    private RestTemplate rest = new RestTemplate();

    String url ="http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=e2dd807810914248a41703de4015754f";

    public ApiService(TechRepo repo, ArticlesRepo arepo) {
        this.repo = repo;
        this.arepo = arepo;
    }


    public HttpHeaders headers(){
        return new HttpHeaders(){{
            add("x-rapidapi-host", new String("apidojo-yahoo-finance-v1.p.rapidapi.com"));
            add("x-rapidapi-key", new String("a15a7c1af5msh7290026254e5f72p164931jsn0f90fadbaa38"));
            //add("content-type", new String("application/x-www-form-urlencoded"));
        }};
    }

    @Bean
    public void getNews() {
        //HttpEntity<Object> obj = new HttpEntity<>(headers());
        //ResponseEntity<String> exchange = rest.exchange(url, HttpMethod.GET, obj, String.class);

        Tech forObject = rest.getForObject(url, Tech.class);
        forObject.getArticles().stream()
                .filter(x -> !arepo.getArticlesByTitle(x.getTitle()).isPresent())
                .forEach(x -> arepo.save(x));

        repo.save(forObject);
        //return forObject;

        //return exchange.getBody();
    }

    public List<Articles> allNews(){
        return arepo.findAll();
    }

    public Articles oneArticle(int id){
        return arepo.findById(id).get();
    }

    public List<Articles> limitedNews() {
        List<Articles> list = new ArrayList<>(arepo.findAll());
        Collections.reverse(list);
        return list.stream().limit(5).collect(Collectors.toList());
    }

    public List<Articles> searchedNews(String title){
        //List<Articles> articles = arepo.getAllByTitle(title).orElse(null);
        List<Articles> collect = arepo.findAll().stream().filter(x -> x.getTitle().contains(title)).collect(Collectors.toList());
        log.info(collect.size());
        return collect;
        /*log.info(articles.get(0));
        return articles;*/

        //if(arepo.getAllByTitleAndDescriptionAndContent().contains(title)) return
    }

}
