package unifood.projetounifoodbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifood.projetounifoodbackend.dto.AlunoDTO;
import unifood.projetounifoodbackend.entity.Aluno;
import unifood.projetounifoodbackend.exception.BadRequestException;
import unifood.projetounifoodbackend.mapper.AlunoMapper;
import unifood.projetounifoodbackend.repository.AlunoRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    @Transactional
    public Integer registrarAluno(AlunoDTO alunoDTO) {

        if (verificarAlunoExiste(alunoDTO))
            throw new BadRequestException("Aluno já registrado. CPF ou Email ou Telefone já está cadastrado!");

        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        aluno = alunoRepository.save(aluno);
        return aluno.getId();
    }

    public List<AlunoDTO> buscarAlunos() {
        List<Aluno> listaAlunos = alunoRepository.findAll();
        List<AlunoDTO> listaAlunosDTO = new ArrayList<>();
        for (Aluno aluno : listaAlunos) {
            AlunoDTO alunoDTO = alunoMapper.toDTO(aluno);
            listaAlunosDTO.add(alunoDTO);
        }
        return listaAlunosDTO;
    }

    public AlunoDTO buscarAlunosPorID(Integer id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new BadRequestException("Aluno não encontrado com o ID: " + id));
        AlunoDTO alunoDTO = alunoMapper.toDTO(aluno);
        return alunoDTO;
    }

    @Transactional
    public String deletarAlunosPorID(Integer id) {
        alunoRepository.deleteById(id);
        return "Deletado aluno com o id: " + id;
    }

    public boolean verificarAlunoExiste(AlunoDTO alunoDTO) {
        if (alunoRepository.existsByCpf(alunoDTO.getCpf()))
            return true;

        if (alunoRepository.existsByEmail(alunoDTO.getEmail()))
            return true;

        if (alunoRepository.existsByTelefone(alunoDTO.getTelefone()))
            return true;

        return false;
    }
}
