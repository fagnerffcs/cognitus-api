package br.com.ffcs.cognitus.service;

import br.com.ffcs.cognitus.dto.UsuarioCadastroDTO;
import br.com.ffcs.cognitus.dto.UsuarioDTO;
import br.com.ffcs.cognitus.model.Usuario;
import br.com.ffcs.cognitus.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioCadastroDTO cadastrar(UsuarioDTO request) {
        if (repository.findByUsername(request.username())!=null) {
            throw new RuntimeException("Usuário já existe");
        }

        Usuario usuario = Usuario.builder()
                                 .username(request.username())
                                 .password(passwordEncoder.encode(request.password()))
                                 .build();
        usuario.setUsername(request.username());
        usuario.setPassword(passwordEncoder.encode(request.password()));

        repository.save(usuario);
        return UsuarioCadastroDTO.fromEntity(usuario);
    }
}
