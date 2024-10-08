// LoginControllerTest.java

package unifood.projetounifoodbackend.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import unifood.projetounifoodbackend.dto.AlunoDTO;
import unifood.projetounifoodbackend.dto.LoginDTO;
import unifood.projetounifoodbackend.exception.BadRequestException;
import unifood.projetounifoodbackend.service.LoginService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Mock
    private LoginService loginService;

    @InjectMocks
    private LoginController loginController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegistrarAluno_Success() throws Exception {

        String email = "victor.reis.carlotta@gmail.com";
        String senha = "1234567";


        AlunoDTO expectedDTO = new AlunoDTO();
        expectedDTO.setCpf("13930556642");

        when(loginService.loginAluno(email, senha)).thenReturn(expectedDTO);


        mockMvc.perform(post("/login/aluno")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"" + email + "\",\"senha\":\"" + senha + "\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.cpf").value(expectedDTO.getCpf()));


        verify(loginService, times(1)).loginAluno(email, senha);
    }

    @Test
    void testRegistrarAluno_Failure() throws Exception {

        String email = "victor.resa.carlota@gmail.co";
        String senha = "123";
        when(loginService.loginAluno(email, senha)).thenThrow(new BadRequestException("Email ou senha incorretos."));


        mockMvc.perform(post("/login/aluno")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"" + email + "\",\"senha\":\"" + senha + "\"}"))
                .andExpect(status().isBadRequest());


        verify(loginService, times(1)).loginAluno(email, senha);
    }


}