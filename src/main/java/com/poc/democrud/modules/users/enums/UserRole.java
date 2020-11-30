package com.poc.democrud.modules.users.enums;

public enum UserRole {
    ADMIN (1),
    USER (2);

    private final int permissaoUsuario;

    UserRole(int permissaoUsuario) {
        this.permissaoUsuario = permissaoUsuario;
    }

}
