package app.entity;


import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Data
@Getter
@Entity
@Table(name="user")
public class User {

    @Id
    private int id;

    private String fullName;

    private String email;

    private String password;


}
