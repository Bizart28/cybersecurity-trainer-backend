package kg.webproject.quiz.shared.dto;

public class PasswordCheckResponseDto {
    public int score;      // 0..4
    public String level;   // VERY_WEAK / WEAK / OK / GOOD / STRONG
    public String[] issues;
    public String[] tips;
}
