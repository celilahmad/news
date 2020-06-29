package app.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "feed")
public class News {

    @Id
    private int id;

    private String head;

    private String body;

    private String detail;

    private String date;

    private String source;

    private String imgurl;
}
