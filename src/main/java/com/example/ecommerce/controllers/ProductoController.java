package com.example.ecommerce.controllers;


import com.example.ecommerce.entities.Producto;
import com.example.ecommerce.service.impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/producto")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(productoService.findAll());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(productoService.findById(id));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Producto entity){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(productoService.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Producto  entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.update(id,entity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }

    }
}
