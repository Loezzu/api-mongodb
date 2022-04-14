package com.tindev.mongo.controller;

import com.tindev.mongo.dto.LogDTO;
import com.tindev.mongo.dto.LogDTOContador;
import com.tindev.mongo.enums.TipoLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Api
@Validated
public interface LogAPI {

    @ApiOperation(value = "Mostra uma lista de logs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de logs"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    List<LogDTO> list();

    @ApiOperation(value = "Retorna uma lista de logs por tipo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de logs por tipo"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    List<LogDTO> listByTipoLog(TipoLog tipoLog);

    @ApiOperation(value = "Agrupa os logs por tipo e mostra quantidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna os logs contados"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    List<LogDTOContador> groupByTipoLogAndCount();


    @ApiOperation(value = "Agrupa o log por tipo e mostra quantidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o log contado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    LogDTOContador getCountByTipoLog(TipoLog tipoLog);

    @ApiOperation(value = "Retorna os logs por data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna os logs por data"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    List<LogDTO> getByData(String data) throws Exception;
}
