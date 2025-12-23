package kg.webproject.quiz.shared.dto;

import kg.webproject.quiz.io.entities.QuizTopic;

public class SectionSummaryDto {
    public long id;
    public String title;
    public String description;
    public QuizTopic topic;
    public boolean published;
    public int sortOrder;

    public int questionsCount;
}
