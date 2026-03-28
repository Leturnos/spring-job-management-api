package rocketseat.gestao_vagas.modules.candidate.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocketseat.gestao_vagas.modules.candidate.entity.CandidateEntity;
import rocketseat.gestao_vagas.modules.candidate.useCase.CreateCandidateUseCase;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CreateCandidateUseCase createCandidateUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        var result = createCandidateUseCase.execute(candidateEntity);
        return ResponseEntity.ok().body(result);
    }
}
