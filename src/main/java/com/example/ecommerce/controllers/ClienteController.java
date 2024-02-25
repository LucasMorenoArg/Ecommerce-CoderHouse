package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Cliente;
import com.example.ecommerce.service.impl.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/cliente/")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.getAll());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.ById(id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }


@Operation(summary = "creacion de nuevo usuario", description = "Crea nuevo usuario")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "operacion completada"),
        @ApiResponse(responseCode = "400", description = "parametros incorrectos",
        content = {@Content(mediaType="application/json",
        schema = @Schema(implementation = ErrorAttributes.class))}
        )})
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Cliente entity){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/updateId/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cliente  entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(entity, id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clienteService.delete(id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }
}

