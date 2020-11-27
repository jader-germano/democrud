package com.poc.democrud.modules.usuarios.enums;

public enum TipoContato {
    TELEFONE (1),
    EMAIL (2);

    private final int tipoContato;

    TipoContato(int tipoContato) {
        this.tipoContato = tipoContato;
    }

}
