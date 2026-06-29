package kr.co.sboard.repository;

import kr.co.sboard.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
}
