package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Cliente;
import com.example.ecommerce.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api/ecommerce")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService ;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.findAll());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.findById(id));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Cliente entity){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente  entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id,entity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clienteService.delete(id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }
}
