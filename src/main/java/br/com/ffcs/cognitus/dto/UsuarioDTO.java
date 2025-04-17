package br.com.ffcs.cognitus.dto;

import br.com.ffcs.cognitus.model.Usuario;

public record UsuarioDTO(String username, String password, String email) {
    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(usuario.getUsername(), usuario.getPassword(), usuario.getEmail());
    }
}
