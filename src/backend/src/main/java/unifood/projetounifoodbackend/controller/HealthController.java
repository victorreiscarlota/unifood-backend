package unifood.projetounifoodbackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/health")
@RequiredArgsConstructor
@Validated
@CrossOrigin
public class HealthController {

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String checkHealth() {
        String message = "Unifood API is up and running!";
        log.info(message);
        return message;
    }
}
