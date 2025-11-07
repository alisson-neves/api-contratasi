package com.projeto.api_contratasi.entity.Enuns;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;


public enum EstadoUsuario {
    ATIVO("A","Ativo"),// User cadastrado
    INATIVO("I","Inativo"); // User não cadastrado

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String descricao;

    private EstadoUsuario (String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @JsonValue
    public String getCodigo() {
        return codigo;
    }

    //Receber o codigo do Front e traduzir de acordo com a descrição
    @JsonCreator
    public static EstadoUsuario valor(String codigo){
        if(codigo.equals("A")){
            return ATIVO;
        }else if (codigo.equals("I")){
            return INATIVO;
        }else{
            return null;
        }
    }
}
