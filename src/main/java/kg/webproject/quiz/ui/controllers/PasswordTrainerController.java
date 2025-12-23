package kg.webproject.quiz.ui.controllers;

import kg.webproject.quiz.service.serviceInterfaces.PasswordStrengthService;
import kg.webproject.quiz.shared.dto.PasswordCheckRequestDto;
import kg.webproject.quiz.shared.dto.PasswordCheckResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/password")
public class PasswordTrainerController {

    private final PasswordStrengthService passwordStrengthService;

    public PasswordTrainerController(PasswordStrengthService passwordStrengthService) {
        this.passwordStrengthService = passwordStrengthService;
    }

    @PostMapping("/check")
    public PasswordCheckResponseDto check(@RequestBody PasswordCheckRequestDto req) {
        String password = (req == null) ? "" : req.password;
        return passwordStrengthService.check(password);
    }
}
