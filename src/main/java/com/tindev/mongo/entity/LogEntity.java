package com.tindev.mongo.entity;


import com.tindev.mongo.enums.TipoLog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Document(collection = "log_tindev")
@Getter
@Setter
public class LogEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private TipoLog tipoLog;

    private String descricao;

    private String data;

}
