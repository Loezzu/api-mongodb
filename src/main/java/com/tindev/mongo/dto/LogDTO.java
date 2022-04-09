package com.tindev.mongo.dto;

import com.tindev.mongo.enums.TipoLog;
import lombok.Data;

@Data
public class LogDTO {

    private String id;

    private TipoLog tipoLog;

    private String descricao;

    private String data;
}
