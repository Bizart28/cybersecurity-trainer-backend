package kg.webproject.quiz.ui.controllers;

import kg.webproject.quiz.io.entities.QuestionEntity;
import kg.webproject.quiz.io.entities.Quiz;
import kg.webproject.quiz.io.repositories.QuestionRepository;
import kg.webproject.quiz.io.repositories.QuizRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminQuestionsController {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public AdminQuestionsController(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @PostMapping("/sections/{sectionId}/questions")
    public QuestionEntity createInSection(@PathVariable Long sectionId, @RequestBody QuestionEntity q) {
        Quiz quiz = quizRepository.findById(sectionId).orElseThrow();
        q.setQuiz(quiz);
        return questionRepository.save(q);
    }

    @PutMapping("/questions/{id}")
    public QuestionEntity update(@PathVariable Long id, @RequestBody QuestionEntity body) {
        QuestionEntity q = questionRepository.findById(id).orElseThrow();
        q.setQuestionContent(body.getQuestionContent());
        q.setExplanation(body.getExplanation());
        // ответы обновлять можно отдельной логикой, если нужно (на фронте проще редактировать вопрос+ответы отдельно)
        return questionRepository.save(q);
    }

    @DeleteMapping("/questions/{id}")
    public void delete(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }
}
