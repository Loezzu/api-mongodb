package com.tindev.mongo.entity;

import com.tindev.mongo.enums.TipoLog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "log_tindev")
@Getter
@Setter
public class LogByTipo {

    @Id
    private TipoLog tipoLog;
    private Integer quantidade;

}
