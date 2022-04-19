package com.tindev.mongo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tindev.mongo.dto.LogCreateDTO;
import com.tindev.mongo.dto.LogDTO;
import com.tindev.mongo.dto.LogDTOContador;
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

    SimpleDateFormat sdfComplete = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    SimpleDateFormat sdfDayMonthYear = new SimpleDateFormat("dd-MM-yyyy");

    public void salvarLog(LogDTO logDTO) {
        var log = new LogEntity();
        BeanUtils.copyProperties(logDTO, log);
        log.setData(sdfComplete.format(new Date()));
        logRepository.save(log);
    }

    public List<LogDTO> listAllLogs() {
       return logRepository.findAll().stream().map(log -> objectMapper.convertValue(log, LogDTO.class)).collect(Collectors.toList());
    }

    public List<LogDTO> listLogsByTipoLog(TipoLog tipoLog) {
        return logRepository.findAllByTipoLog(tipoLog).stream().map(log -> objectMapper.convertValue(log, LogDTO.class)).collect(Collectors.toList());
    }

    public List<LogDTOContador> groupByTipoLogAndCount() {
        return this.logRepository.groupByTipoLogAndCount().stream().map(l->{
            return new LogDTOContador(l.getTipoLog(), l.getQuantidade());
        }).collect(Collectors.toList());
    }

    public List<LogDTO> listAllByData(String date) throws Exception {
        String dataCorrected = date.replace("/","-");
        Date dataAtual = new Date();
        Date dateReceived = sdfDayMonthYear.parse(dataCorrected);
        if(dateReceived.after(dataAtual)){
            throw new Exception("Esse dia não chegou!");
        }
        return logRepository.findAllByDataContains(date).stream().map(logEntity -> objectMapper.convertValue(logEntity, LogDTO.class)).collect(Collectors.toList());
    }

    public LogDTOContador countLogsByTipo(TipoLog tipoLog){
        LogDTOContador log = new LogDTOContador();
        log.setQuantidade(logRepository.countByTipoLog(tipoLog));
        log.setTipoLog(tipoLog);
        return log;
    }
}
