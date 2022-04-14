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
public class LogCreateDTO {
    @Enumerated(EnumType.STRING)
    private TipoLog tipoLog;
    private String descricao;

}
