package com.example.ecommerce.service.impl;

import com.example.ecommerce.entities.Producto;
import com.example.ecommerce.repository.ProductoRepository;
import com.example.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAll() throws Exception {
        try {
            return productoRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage() +
                    " "+ e.getCause());
        }
    }

    @Override
    public Optional<Producto> byId(Long id) throws Exception {
        try {

            return productoRepository.findById(id);

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public Producto save(Producto producto) throws Exception {

        try {
            return productoRepository.save(producto);

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<Producto> update(Producto producto) throws Exception {
        try {

            if (productoRepository.existsById(producto.getId())){
                productoRepository.save(producto);

            } else System.out.println("No se pudo completar la operación");

            return productoRepository.findById(producto.getId());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {

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
