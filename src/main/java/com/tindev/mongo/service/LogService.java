package com.tindev.mongo.service;

import com.tindev.mongo.entity.LogEntity;
import com.tindev.mongo.enums.TipoLog;
import com.tindev.mongo.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public void logUser(String descricao) {
        LogEntity log = new LogEntity();
        log.setTipoLog(TipoLog.USER);
        log.setData(sdf.format(new Date()));
        log.setDescricao(descricao);
        logRepository.save(log);
    }

    public void logPersonInfo(String descricao) {
        LogEntity log = new LogEntity();
        log.setTipoLog(TipoLog.PERSONINFO);
        log.setData(sdf.format(new Date()));
        log.setDescricao(descricao);
        logRepository.save(log);
    }

    public void logAddress(String descricao) {
        LogEntity log = new LogEntity();
        log.setTipoLog(TipoLog.ADDRESS);
        log.setData(sdf.format(new Date()));
        log.setDescricao(descricao);
        logRepository.save(log);
    }

    public void logLike(String descricao) {
        LogEntity log = new LogEntity();
        log.setTipoLog(TipoLog.LIKE);
        log.setData(sdf.format(new Date()));
        log.setDescricao(descricao);
        logRepository.save(log);
    }

    public void logMatch(String descricao) {
        LogEntity log = new LogEntity();
        log.setTipoLog(TipoLog.MATCH);
        log.setData(sdf.format(new Date()));
        log.setDescricao(descricao);
        logRepository.save(log);
    }

    public List<LogEntity> listAllLogs() {
        return logRepository.findAll();
    }

    public List<LogEntity> listLogsByTipoLog(TipoLog tipoLog) {
        return logRepository.findAllByTipoLog(tipoLog);
    }

}
