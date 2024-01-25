package com.example.ecommerce.service.impl;

import com.example.ecommerce.entities.Cliente;
import com.example.ecommerce.repository.ClienteRepository;
import com.example.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() throws Exception {
        try {
            List<Cliente> entities = clienteRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage() +
                    " "+ e.getCause());
        }
    }

    @Override
    public Cliente findById(Integer id) throws Exception {

        try {
            Optional<Cliente> personaOptional= clienteRepository.findById(id);
            return personaOptional.get();

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente save(Cliente entity) throws Exception {

        try {
            entity = clienteRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente update(Integer id, Cliente entity) throws Exception {

        try {
            Optional<Cliente> personaOptional=clienteRepository.findById(id);
            Cliente cliente = personaOptional.get();
            return cliente = clienteRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        try {
            if (clienteRepository.existsById(id)){
                clienteRepository.deleteById(id);
                return true;}
            else throw new Exception("Error al borrar");
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
