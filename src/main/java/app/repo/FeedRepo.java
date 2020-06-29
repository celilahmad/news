package app.repo;

import app.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepo extends JpaRepository<News, Integer> {
}
