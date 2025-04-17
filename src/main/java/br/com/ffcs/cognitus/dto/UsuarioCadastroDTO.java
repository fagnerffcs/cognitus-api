package br.com.ffcs.cognitus.dto;

import br.com.ffcs.cognitus.model.Usuario;

public record UsuarioCadastroDTO(Long id, String username, String email) {
    public static UsuarioCadastroDTO fromEntity(Usuario usuario) {
        return new UsuarioCadastroDTO(usuario.getId(), usuario.getUsername(), usuario.getEmail());
    }
}
