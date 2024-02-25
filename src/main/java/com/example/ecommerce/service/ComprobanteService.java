package com.example.ecommerce.service;

import com.example.ecommerce.entities.Comprobante;

import java.util.List;
import java.util.Optional;

public interface ComprobanteService {

    List<Comprobante> getAll()throws Exception;
    Optional<Comprobante> byId(Long id) throws Exception;
    void horaComprobante(Comprobante comprobante) throws Exception;
    boolean StockAndPrecioTotal(Comprobante comprobante)throws Exception;
    Comprobante save(Comprobante comprobante)throws Exception;
    String totalProductosVendidos()throws Exception;
    Optional<Comprobante> update (Comprobante comprobante, Long id)throws Exception;
    boolean delete(Long id)throws Exception;

}
