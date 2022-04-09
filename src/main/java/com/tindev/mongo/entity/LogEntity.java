package com.tindev.mongo.entity;


import com.tindev.mongo.enums.Gender;
import com.tindev.mongo.enums.Pref;
import com.tindev.mongo.enums.ProgLangs;
import com.tindev.mongo.enums.TipoLog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "log_tindev")
@Getter
@Setter
public class LogEntity {

    @Id
    private String id;

    private TipoLog tipoLog;

    private String descricao;

    private String data;

}
