package app.service;


import app.entity.Tech;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {


    //private final TechRepo repo;
    //private final ArticlesRepo arepo;

    private RestTemplate rest = new RestTemplate();

    String url ="http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=e2dd807810914248a41703de4015754f";


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
        //repo.save(forObject);
        return forObject;

        //return exchange.getBody();
    }
}
