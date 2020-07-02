package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Tech {

   /* @Transient
    private Articles arc = new Articles();*/


    private List<Articles> articles;

    /*@Transient
    Articles a = articles.get(0);

    *Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int a1 = a.getId()

    String author = a.getAuthor();

    String title = a.getTitle();

    String description = a.getDescription();*/
}
