package com.example.ecommerce.service.impl;

import com.example.ecommerce.entities.Cliente;
import com.example.ecommerce.repository.ClienteRepository;
import com.example.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> getAll() throws Exception {
        try {
            return clienteRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage() +
                    " "+ e.getCause());
        }
    }

    @Override
    public Optional<Cliente> ById(Long id) throws Exception {
        try {
            return clienteRepository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {

        try {
            return clienteRepository.save(cliente);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<Cliente> update(Cliente cliente, Long id) throws Exception {

        try {
            if (clienteRepository.existsById(id)){
                clienteRepository.save(cliente);
            } else System.out.println("No se pudo completar la operación");

            return clienteRepository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public boolean delete(Long id) throws Exception {
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
