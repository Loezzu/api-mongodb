package com.tindev.mongo.dto;

import com.tindev.mongo.enums.TipoLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {

    private String id;

    @Enumerated(EnumType.STRING)
    private TipoLog tipoLog;

    private String descricao;

    private String data;

    public LogDTO(TipoLog tipoLog, String data, String descricao) {
        this.tipoLog = tipoLog;
        this.data = data;
        this.descricao = descricao;
    }
}
