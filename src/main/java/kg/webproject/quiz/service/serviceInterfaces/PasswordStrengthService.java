package kg.webproject.quiz.service.serviceInterfaces;

import kg.webproject.quiz.shared.dto.PasswordCheckResponseDto;

public interface PasswordStrengthService {
    PasswordCheckResponseDto check(String password);
}
