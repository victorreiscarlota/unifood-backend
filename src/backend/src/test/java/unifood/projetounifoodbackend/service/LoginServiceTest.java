// LoginServiceTests.java

package unifood.projetounifoodbackend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import unifood.projetounifoodbackend.dto.AlunoDTO;
import unifood.projetounifoodbackend.entity.Aluno;
import unifood.projetounifoodbackend.exception.BadRequestException;
import unifood.projetounifoodbackend.mapper.AlunoMapper;
import unifood.projetounifoodbackend.repository.AlunoRepository;

@SpringBootTest
class LoginServiceTests {

    @Mock
    private AlunoRepository alunoRepository;

    @Mock
    private AlunoMapper alunoMapper;

    @InjectMocks
    private LoginService loginService;

    @Test
    void testLoginAluno_Success() {

        String email = "test@example.com";
        String senha = "validPassword123";
        Aluno aluno = new Aluno();
        aluno.setEmail(email);
        aluno.setSenha(senha);
        AlunoDTO expectedDTO = new AlunoDTO();
        expectedDTO.setCpf("12345678901");

        when(alunoRepository.existsByEmailAndSenha(email, senha)).thenReturn(true);
        when(alunoRepository.findOneByEmail(email)).thenReturn(aluno);
        when(alunoMapper.toDTO(aluno)).thenReturn(expectedDTO);


        AlunoDTO result = loginService.loginAluno(email, senha);


        assertNotNull(result);
        assertEquals(expectedDTO, result);
        verify(alunoRepository, times(1)).existsByEmailAndSenha(email, senha);
        verify(alunoRepository, times(1)).findOneByEmail(email);
        verify(alunoMapper, times(1)).toDTO(aluno);
    }

    @Test
    void testLoginAluno_Failure() {

        String email = "victor.reis.carlota@gml.com";
        String senha = "123";
        when(alunoRepository.existsByEmailAndSenha(email, senha)).thenReturn(false);


        assertThrows(BadRequestException.class, () -> loginService.loginAluno(email, senha));


        verify(alunoRepository, times(1)).existsByEmailAndSenha(email, senha);
        verify(alunoRepository, never()).findOneByEmail(any());
        verify(alunoMapper, never()).toDTO(any());
    }
}
