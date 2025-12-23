package kg.webproject.quiz.service;

import kg.webproject.quiz.service.serviceInterfaces.PasswordStrengthService;
import kg.webproject.quiz.shared.dto.PasswordCheckResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordStrengthServiceImpl implements PasswordStrengthService {

    @Override
    public PasswordCheckResponseDto check(String password) {
        PasswordCheckResponseDto res = new PasswordCheckResponseDto();
        List<String> issues = new ArrayList<>();
        List<String> tips = new ArrayList<>();

        if (password == null) password = "";
        int len = password.length();

        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        int raw = 0;

        if (len >= 8) raw++; else issues.add("Длина меньше 8 символов");
        if (len >= 12) raw++; else tips.add("Сделай пароль длинее 12+ символов");
        if (hasLower && hasUpper) raw++; else tips.add("Используй и строчные, и заглавные буквы");
        if (hasDigit) raw++; else tips.add("Добавь цифры");
        if (hasSpecial) raw++; else tips.add("Добавь спецсимволы");

        // нормализация в 0..4
        if (raw <= 1) res.score = 0;
        else if (raw == 2) res.score = 1;
        else if (raw == 3) res.score = 2;
        else if (raw == 4) res.score = 3;
        else res.score = 4;

        switch (res.score) {
            case 0: res.level = "VERY_WEAK"; break;
            case 1: res.level = "WEAK"; break;
            case 2: res.level = "OK"; break;
            case 3: res.level = "GOOD"; break;
            default: res.level = "STRONG";
        }

        res.issues = issues.toArray(new String[0]);
        res.tips = tips.toArray(new String[0]);
        return res;
    }
}
