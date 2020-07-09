package app.service;

import app.entity.Tech;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestApi {


    private final RestTemplate rest;

    String url ="http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=e2dd807810914248a41703de4015754f";

    public TestApi(RestTemplate rest) {
        this.rest = rest;
    }


    public Tech getNews() {
        //HttpEntity<Object> obj = new HttpEntity<>(headers());
        //ResponseEntity<String> exchange = rest.exchange(url, HttpMethod.GET, obj, String.class);

        return rest.getForObject(url, Tech.class);

    }
}
