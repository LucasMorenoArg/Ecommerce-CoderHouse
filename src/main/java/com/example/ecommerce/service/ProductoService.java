package com.example.ecommerce.service;

import com.example.ecommerce.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> getAll()throws Exception;
    Optional<Producto> byId(Long id)throws Exception;
    Producto save (Producto producto)throws Exception;
    Optional<Producto> update(Producto cliente)throws Exception;
    boolean delete(Long id)throws Exception;
}
