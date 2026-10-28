package dev.java.curriVitae.infrastructure.exception.handle;

import dev.java.curriVitae.infrastructure.exception.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandle {

    // Anotação faz com que sempre que o sistema lançar essa excessão, ele seja interceptado por esse método
    @ExceptionHandler(ResourceNotFoundException.class)
    // é entregada automaticamente pelo Spring a exceção lançada
    public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
        // monta um corpo de resposta simples, padronizado — um JSON com a chave "error" e o valor sendo a mensagem
        // que você escreveu ao lançar a exceção
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // 404
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRunTime(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "erro interno no servidor");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // 400
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleBadCredentials(BadCredentialsException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "email ou senha inválidos");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Este item está em uso e não pode ser removido");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}
