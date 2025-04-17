package br.com.ffcs.cognitus.controller;

import br.com.ffcs.cognitus.dto.UsuarioCadastroDTO;
import br.com.ffcs.cognitus.dto.UsuarioDTO;
import br.com.ffcs.cognitus.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioCadastroDTO> cadastrar(@RequestBody @Valid UsuarioDTO request) {
        UsuarioCadastroDTO usuario = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
