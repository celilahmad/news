package app.repo;

import app.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepo extends JpaRepository<Articles, Integer> {
}
