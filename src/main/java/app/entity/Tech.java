package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Tech {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //@ElementCollection
    @OneToMany(mappedBy ="tech")
    private List<Articles> articles;

    /*@OneToOne
    @JoinColumn(name="id", referencedColumnName = "id")
    private Articles author;

    *//*private String title;

    private String description;

    private String url;

    private String urlToImage;

    private String publishedAt;

    private String content;*//*
*/






}
