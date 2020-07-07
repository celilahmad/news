package app.repo;

import app.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticlesRepo extends JpaRepository<Articles, Integer> {



    Optional<Articles> getArticlesByTitle(String title);
}
