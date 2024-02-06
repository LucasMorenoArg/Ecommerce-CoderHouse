package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Venta;
import com.example.ecommerce.service.impl.VentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/venta")
public class VentaController {

    @Autowired
    private VentaServiceImpl ventaService;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(ventaService.findAll());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(ventaService.findById(id));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Venta entity){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(ventaService.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Venta entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.update(id,entity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ventaService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }

    }


}
