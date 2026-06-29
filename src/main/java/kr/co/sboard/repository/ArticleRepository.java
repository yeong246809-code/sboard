package kr.co.sboard.repository;

import kr.co.sboard.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Integer> {
}
