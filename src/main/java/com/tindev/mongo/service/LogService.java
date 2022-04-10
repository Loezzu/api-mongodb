package com.tindev.mongo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tindev.mongo.dto.LogDTO;
import com.tindev.mongo.entity.LogEntity;
import com.tindev.mongo.enums.TipoLog;
import com.tindev.mongo.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    private final ObjectMapper objectMapper;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public void log(TipoLog tipoLog, String descricao) {
        var log = new LogEntity();
        BeanUtils.copyProperties(new LogDTO(tipoLog, sdf.format(new Date()), descricao), log);
        logRepository.save(log);
    }

    public List<LogDTO> listAllLogs() {
       return logRepository.findAll().stream().map(log -> objectMapper.convertValue(log, LogDTO.class)).collect(Collectors.toList());
    }

    public List<LogEntity> listLogsByTipoLog(TipoLog tipoLog) {
        return logRepository.findAllByTipoLog(tipoLog);
    }

}
