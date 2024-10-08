package unifood.projetounifoodbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import unifood.projetounifoodbackend.dto.AlunoDTO;
import unifood.projetounifoodbackend.dto.LoginDTO;
import unifood.projetounifoodbackend.service.LoginService;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Validated
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/aluno")
    @ResponseStatus(code = HttpStatus.OK)
    public AlunoDTO registrarAluno(@Valid @RequestBody LoginDTO loginAlunoDTO) {
        AlunoDTO alunoDTO = loginService.loginAluno(loginAlunoDTO.getEmail(), loginAlunoDTO.getSenha());
        return alunoDTO;
    }
}
