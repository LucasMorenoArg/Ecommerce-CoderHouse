package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Cliente;
import com.example.ecommerce.service.impl.ClienteServiceImpl;
import com.example.ecommerce.service.impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/cliente/")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.findAll());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.findById(id));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Cliente entity){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(clienteService.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/updateBy{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente  entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id,entity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @DeleteMapping("/deletebyId/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clienteService.delete(id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }
    //-------------------------------------------------------------------------------------------

}
