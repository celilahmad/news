package app.service;

import app.entity.Articles;
import app.entity.Tech;
import app.repo.ArticlesRepo;
import app.repo.TechRepo;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

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

    public Tech getNews() {
        //HttpEntity<Object> obj = new HttpEntity<>(headers());
        //ResponseEntity<String> exchange = rest.exchange(url, HttpMethod.GET, obj, String.class);

        Tech forObject = rest.getForObject(url, Tech.class);
        //List<Articles> collect = forObject.getArticles().stream().filter(x -> !repo.findAll().contains(x.getTitle())).collect(Collectors.toList());
        //repo.deleteAll();
        forObject.getArticles().forEach(x-> arepo.save(x));
        repo.save(forObject);
        return forObject;

        //return exchange.getBody();
    }

    public List<Articles> allNews(){
        return arepo.findAll().stream().limit(5).collect(Collectors.toList());
    }
}
