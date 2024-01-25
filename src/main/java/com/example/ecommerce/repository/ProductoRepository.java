package com.example.ecommerce.repository;

import com.example.ecommerce.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
