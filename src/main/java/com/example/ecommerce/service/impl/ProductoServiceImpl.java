package com.example.ecommerce.service.impl;

import com.example.ecommerce.entities.Cliente;
import com.example.ecommerce.entities.Producto;
import com.example.ecommerce.repository.ProductoRepository;
import com.example.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService<Producto> {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> findAll() throws Exception {
        try {
            return productoRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage() +
                    " "+ e.getCause());
        }
    }

    @Override
    public Producto findById(Integer id) throws Exception {

        try {
            Optional<Producto> personaOptional= productoRepository.findById(id);
            return personaOptional.get();

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Producto save(Producto entity) throws Exception {

        try {
            entity = productoRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Producto update(Integer id, Producto entity) throws Exception {

        try {
            Optional<Producto> personaOptional = productoRepository.findById(id);
            Producto cliente = personaOptional.get();
            return cliente = productoRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {

        try {
            if (productoRepository.existsById(id)){
                productoRepository.deleteById(id);
                return true;}
            else throw new Exception("Error al borrar");
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
