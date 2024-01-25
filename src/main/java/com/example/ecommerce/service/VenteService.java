package com.example.ecommerce.service;

import java.util.List;

public interface VenteService <E>{

    List<E> findAll() throws Exception;
    E findById(Integer id) throws Exception;
    E save(E entity) throws Exception;
    E update(Integer id, E entity) throws Exception;
    boolean delete(Integer id) throws Exception;

}
