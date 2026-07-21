package netlify.zidcode.SpringBootCore.StudentServer.Exception;

import jakarta.servlet.http.HttpServletRequest;
import netlify.zidcode.SpringBootCore.StudentServer.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class GlobalExceptionHandler {
    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(
            RuntimeException ex, HttpServletRequest request) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(500).body(response);
    }
}
