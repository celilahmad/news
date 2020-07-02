package app.repo;

import app.entity.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepo extends JpaRepository<Tech, Integer> {
}
