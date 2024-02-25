package com.example.ecommerce.service.impl;

import com.example.ecommerce.entities.Comprobante;
import com.example.ecommerce.entities.Producto;
import com.example.ecommerce.repository.ComprobanteRepository;
import com.example.ecommerce.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ComprobanteServiceImpl implements ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;
    @Autowired
    private ProductoServiceImpl productoService;

    @Override
    public List<Comprobante> getAll() throws Exception {

        try {
            return comprobanteRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage() +
                    " "+ e.getCause());
        }
    }

    @Override
    public Optional<Comprobante> byId(Long id) throws Exception {
        try {

            return comprobanteRepository.findById(id);

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void horaComprobante(Comprobante comprobante) throws Exception {

       try {
           RestTemplate restTemplate = new RestTemplate();
           String url = "http://worldclockapi.com/api/json/utc/no";
           Map<String, String> mapa = restTemplate.getForObject(url, Map.class);
           comprobante.setFechaComprobante(mapa.get("currentDateTime"));


           if (mapa.get("currentDateTime")==null) {
               LocalDate localDate = LocalDate.now();
               comprobante.setFechaComprobante(localDate.toString());

           }
       }catch (Exception e){
           throw new Exception(e.getMessage());
       }
    }

    @Override
    public boolean StockAndPrecioTotal(Comprobante comprobante) throws Exception {

        try {
            Optional<Producto> prod= productoService.byId(comprobante.getProducto().getId());
            Long precioProd;
            if (prod.isPresent() && prod.get().getStock()>=comprobante.getCantidad()){
                prod.get().setStock(prod.get().getStock()-comprobante.getCantidad());
                productoService.save(prod.get());
                precioProd=prod.get().getPrecio();
                comprobante.setPrecioTotal(precioProd*comprobante.getCantidad());
                return true;
            } else return false;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public Comprobante save(Comprobante comprobante) throws Exception {

        try {
            comprobante = comprobanteRepository.save(comprobante);
            return comprobante;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String totalProductosVendidos() throws Exception {

        try {
            List<Comprobante> lista= comprobanteRepository.findAll();
            int parcial;
            int total=0;
            String mensaje= "Total de Articulos vendidos";
            for (Comprobante comprobante : lista) {

                parcial= comprobante.getCantidad();
                total+=parcial;
            }
            return mensaje + " " + total;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Optional<Comprobante> update(Comprobante comprobante, Long id) throws Exception {
        try {
            if (comprobanteRepository.existsById(id)){
                comprobanteRepository.save(comprobante);
            } else System.out.println("No se pudo completar la operación");

            return comprobanteRepository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (comprobanteRepository.existsById(id)){
                comprobanteRepository.deleteById(id);
                return true;}
            else throw new Exception("Error al borrar");
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
