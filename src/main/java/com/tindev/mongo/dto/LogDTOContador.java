package com.tindev.mongo.dto;

import com.tindev.mongo.enums.TipoLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogDTOContador {

    private TipoLog tipoLog;
    private Integer quantidade;

}
