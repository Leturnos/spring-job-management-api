package rocketseat.gestao_vagas.modules.company.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocketseat.gestao_vagas.modules.company.entity.JobEntity;
import rocketseat.gestao_vagas.modules.company.useCase.CreateJobUseCase;

@RestController
@RequestMapping("/company/job")
@RequiredArgsConstructor
public class JobController {

    private final CreateJobUseCase createJobUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity){
        var result = createJobUseCase.execute(jobEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
