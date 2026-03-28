package rocketseat.gestao_vagas.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.gestao_vagas.exceptions.dto.ErrorMessageDTO;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorMessageDTO> dto = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(err -> {
                    String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
                    return new ErrorMessageDTO(message, err.getField());
                })
                .toList();

        return ResponseEntity.badRequest().body(dto);
    }
}
