package com.tindev.mongo.controller;


import com.tindev.mongo.dto.LogDTO;
import com.tindev.mongo.dto.LogDTOContador;
import com.tindev.mongo.enums.TipoLog;
import com.tindev.mongo.service.LogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
@Api(value = "Log API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Log API"})
public class LogController implements LogAPI{

    @Autowired
    private LogService logService;

    @GetMapping("/list")
    public List<LogDTO> list() {
        return logService.listAllLogs();
    }

    @GetMapping("/list-by-tipo-log")
    public List<LogDTO> listByTipoLog(TipoLog tipoLog) {
        return logService.listLogsByTipoLog(tipoLog);
    }

    @GetMapping("/group-by-tipo-and-count")
    public List<LogDTOContador> groupByTipoLogAndCount() {
        return logService.groupByTipoLogAndCount();
    }

    @GetMapping("/count-logs-by-tipo")
    public LogDTOContador getCountByTipoLog(TipoLog tipoLog){
        return logService.countLogsByTipo(tipoLog);
    }

    @GetMapping("/find-all-by-data")
    public List<LogDTO> getByData(String data) throws Exception {
        return logService.listAllByData(data);
    }

    @GetMapping("count-all-by-data")
    public Long countLogsToday() throws Exception {
        return logService.countLogsByData();
    }

}
