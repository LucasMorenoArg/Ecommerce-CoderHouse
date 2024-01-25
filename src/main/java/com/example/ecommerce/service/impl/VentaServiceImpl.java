package com.example.ecommerce.service.impl;

import com.example.ecommerce.entities.Venta;
import com.example.ecommerce.repository.VentaRepository;
import com.example.ecommerce.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VenteService<Venta> {

    @Autowired
    private VentaRepository ventaRepository;
    @Override
    public List<Venta> findAll() throws Exception {
        try {
            return ventaRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage() +
                    " "+ e.getCause());
        }
    }

    @Override
    public Venta findById(Integer id) throws Exception {

        try {
            Optional<Venta> personaOptional= ventaRepository.findById(id);
            return personaOptional.get();

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Venta save(Venta entity) throws Exception {

        try {
            entity = ventaRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Venta update(Integer id, Venta entity) throws Exception {

        try {
            Optional<Venta> personaOptional = ventaRepository.findById(id);
            Venta cliente = personaOptional.get();
            return cliente = ventaRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {

        try {
            if (ventaRepository.existsById(id)){
                ventaRepository.deleteById(id);
                return true;}
            else throw new Exception("Error al borrar");
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
