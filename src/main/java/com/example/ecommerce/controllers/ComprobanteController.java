package com.example.ecommerce.controllers;


import com.example.ecommerce.entities.Comprobante;
import com.example.ecommerce.entities.Producto;
import com.example.ecommerce.service.impl.ClienteServiceImpl;
import com.example.ecommerce.service.impl.ComprobanteServiceImpl;
import com.example.ecommerce.service.impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {

    @Autowired
    private ComprobanteServiceImpl comprobanteService;
    @Autowired
    private ProductoServiceImpl productoService;


    @GetMapping("/prodTotales")
    public ResponseEntity<?> prodtotales() throws Exception {

        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(comprobanteService.totalProductosVendidos());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(comprobanteService.getAll());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return  ResponseEntity.status(HttpStatus.OK).
                    body(comprobanteService.byId(id));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.No se encontró registro.\"}");
        }
    }

    @PostMapping("/comprar")
    public ResponseEntity<?> save(@RequestBody Comprobante comprobante) {
        try {

            if(comprobanteService.StockAndPrecioTotal(comprobante)){
               comprobanteService.horaComprobante(comprobante);

                return ResponseEntity.status(HttpStatus.OK).
                        body(comprobanteService.save(comprobante));}

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("{\"error\":\"Stock insuficiente\"}");
    }

    @PutMapping("/updateId/{id}")
    public ResponseEntity<?> update(@RequestBody Comprobante comprobante, @PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(comprobanteService.update(comprobante,id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(comprobanteService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error.Por favor intente mas tarde\"}");
        }

    }
}
