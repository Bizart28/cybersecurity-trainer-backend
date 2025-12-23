package kg.webproject.quiz.ui.controllers;

import kg.webproject.quiz.io.entities.Quiz;
import kg.webproject.quiz.io.repositories.QuizRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/sections")
public class AdminSectionsController {

    private final QuizRepository quizRepository;

    public AdminSectionsController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @PutMapping("/{id}")
    public Quiz update(@PathVariable Long id, @RequestBody Quiz body) {
        Quiz quiz = quizRepository.findById(id).orElseThrow();
        quiz.setTitle(body.getTitle());
        quiz.setDescription(body.getDescription());
        quiz.setTopic(body.getTopic());
        quiz.setSortOrder(body.getSortOrder());
        quiz.setPublished(body.getPublished());
        return quizRepository.save(quiz);
    }

    @PatchMapping("/{id}/publish")
    public Quiz publish(@PathVariable Long id, @RequestParam boolean value) {
        Quiz quiz = quizRepository.findById(id).orElseThrow();
        quiz.setPublished(value);
        return quizRepository.save(quiz);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        quizRepository.deleteById(id);
    }
}
