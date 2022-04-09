package com.tindev.mongo.repository;

import com.tindev.mongo.entity.LogEntity;
import com.tindev.mongo.enums.TipoLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends MongoRepository<LogEntity, String> {

    List<LogEntity> findAllByTipoLog(TipoLog tipoLog);

}
