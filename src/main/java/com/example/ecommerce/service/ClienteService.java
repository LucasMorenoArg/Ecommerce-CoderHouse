package com.example.ecommerce.service;

import com.example.ecommerce.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> getAll()throws Exception;
    Optional<Cliente> ById(Long id)throws Exception;
    Cliente save (Cliente cliente)throws Exception;
    Optional<Cliente> update(Cliente cliente,Long id)throws Exception;
    boolean delete(Long id)throws Exception;
}
