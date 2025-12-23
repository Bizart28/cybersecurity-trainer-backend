package kg.webproject.quiz.ui.controllers;

import kg.webproject.quiz.io.entities.Quiz;
import kg.webproject.quiz.io.entities.QuestionEntity;
import kg.webproject.quiz.io.repositories.QuizRepository;
import kg.webproject.quiz.io.repositories.QuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizController(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping
    public List<Quiz> getAll() {
        return quizRepository.findAll();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable Long id) {
        return quizRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @PostMapping("/{quizId}/questions")
    public QuestionEntity createQuestionInQuiz(@PathVariable Long quizId, @RequestBody QuestionEntity question) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow();
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }
}
