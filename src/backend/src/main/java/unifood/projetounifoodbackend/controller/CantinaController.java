package unifood.projetounifoodbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import unifood.projetounifoodbackend.dto.CantinaDTO;
import unifood.projetounifoodbackend.dto.CantinaListagemDTO;
import unifood.projetounifoodbackend.service.CantinaService;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/cantinas")
@RequiredArgsConstructor
@Validated
@Slf4j
@CrossOrigin
public class CantinaController {
    private final CantinaService cantinaService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String registrarCantina(@Valid @RequestBody CantinaDTO cantinaDTO) {
        log.info("Chamada de endpoint de registrar cantina");
        Integer id = cantinaService.createCantina(cantinaDTO);
        return "Cantina registrada com sucesso. Id da cantina criada: " + id;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<CantinaDTO> buscarCantinas(){
        List<CantinaDTO> cantinas = cantinaService.buscarCantinas();
        return cantinas;
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CantinaListagemDTO buscarCantinasPorID(@PathVariable Integer id){
        CantinaListagemDTO cantinaListagemDTO = cantinaService.buscarCantinasPorID(id);
        return cantinaListagemDTO;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus (code = HttpStatus.OK)
    public String deletarCantinasPorID(@PathVariable Integer id){
        String message = cantinaService.deletarCantinasPorID(id);
        return message;

    }

    @PostMapping("/{id}/image")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String uploadImagemCantina(@PathVariable Integer id, @RequestBody MultipartFile image) throws IOException {
        String message = cantinaService.uploadImagemCantina(id, image);
        return message;
    }
}
