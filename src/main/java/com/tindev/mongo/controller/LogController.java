package com.tindev.mongo.controller;


import com.tindev.mongo.dto.LogDTO;
import com.tindev.mongo.entity.LogEntity;
import com.tindev.mongo.enums.TipoLog;
import com.tindev.mongo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/save-log")
    public void saveLog(TipoLog tipoLog, String descricao) {
        try {
            logService.log(tipoLog, descricao);
            new ResponseEntity<>("Log criado com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<LogDTO> list() {
        return logService.listAllLogs();
    }

    @GetMapping("/list-by-tipo-log")
    public List<LogEntity> listByTipoLog(TipoLog tipoLog) {
        return logService.listLogsByTipoLog(tipoLog);
    }





}
