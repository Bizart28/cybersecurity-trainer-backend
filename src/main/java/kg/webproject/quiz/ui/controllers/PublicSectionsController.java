package kg.webproject.quiz.ui.controllers;

import kg.webproject.quiz.io.entities.Quiz;
import kg.webproject.quiz.io.repositories.QuizRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/sections")
public class PublicSectionsController {

    private final QuizRepository quizRepository;

    public PublicSectionsController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping
    public List<Quiz> getSections() {
        return quizRepository.findAllByPublishedTrueOrderBySortOrderAscTitleAsc();
    }

    @GetMapping("/{id}")
    public Quiz getSection(@PathVariable Long id) {
        // Возвращает раздел + вопросы + ответы (т.к. связь Quiz -> QuestionEntity -> Answers)
        return quizRepository.findById(id).orElseThrow();
    }
}
