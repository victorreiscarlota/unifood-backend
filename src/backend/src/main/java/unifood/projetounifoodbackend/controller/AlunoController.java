package unifood.projetounifoodbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import unifood.projetounifoodbackend.dto.AlunoDTO;
import unifood.projetounifoodbackend.service.AlunoService;

import java.util.List;


@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
@Validated
@CrossOrigin
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String registrarAluno(@Valid @RequestBody AlunoDTO alunoDTO) {
        Integer id = alunoService.registrarAluno(alunoDTO);
        return "Aluno registrado com sucesso. Id do aluno criado: " + id;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<AlunoDTO> buscarAlunos(){
        List<AlunoDTO> alunos = alunoService.buscarAlunos();
        return alunos;
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public AlunoDTO buscarAlunosPorID(@PathVariable Integer id){
        AlunoDTO alunoDTO = alunoService.buscarAlunosPorID(id);
        return alunoDTO;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus (code = HttpStatus.OK)
    public String deletarAlunosPorID(@PathVariable Integer id){
       String message = alunoService.deletarAlunosPorID(id);
       return message;

    }
}
