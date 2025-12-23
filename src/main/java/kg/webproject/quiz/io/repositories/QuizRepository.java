package kg.webproject.quiz.io.repositories;

import kg.webproject.quiz.io.entities.Quiz;
import kg.webproject.quiz.io.entities.QuizTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findAllByPublishedTrueOrderBySortOrderAscTitleAsc();
    List<Quiz> findAllByTopicAndPublishedTrueOrderBySortOrderAscTitleAsc(QuizTopic topic);
}