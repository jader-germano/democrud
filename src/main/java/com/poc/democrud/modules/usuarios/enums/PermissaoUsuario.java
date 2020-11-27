package com.poc.democrud.modules.usuarios.enums;

public enum PermissaoUsuario {
    ADMIN (1),
    USER (2);

    private final int permissaoUsuario;

    PermissaoUsuario(int permissaoUsuario) {
        this.permissaoUsuario = permissaoUsuario;
    }

}
