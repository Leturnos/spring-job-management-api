package rocketseat.gestao_vagas.modules.company.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocketseat.gestao_vagas.modules.company.entity.CompanyEntity;
import rocketseat.gestao_vagas.modules.company.useCase.CreateCompanyUseCase;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CreateCompanyUseCase createCompanyUseCases;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity){
        var result = createCompanyUseCases.execute(companyEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
