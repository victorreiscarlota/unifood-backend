package unifood.projetounifoodbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifood.projetounifoodbackend.dto.AlunoDTO;
import unifood.projetounifoodbackend.entity.Aluno;
import unifood.projetounifoodbackend.exception.BadRequestException;
import unifood.projetounifoodbackend.mapper.AlunoMapper;
import unifood.projetounifoodbackend.repository.AlunoRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoDTO loginAluno(String email, String senha) {

        boolean exists = alunoRepository.existsByEmailAndSenha(email, senha);

        if (exists) {
            Aluno aluno = alunoRepository.findOneByEmail(email);
            AlunoDTO alunoDTO = alunoMapper.toDTO(aluno);
            return alunoDTO;
        }

        throw new BadRequestException("Email ou senha incorretos.");
    }
}
