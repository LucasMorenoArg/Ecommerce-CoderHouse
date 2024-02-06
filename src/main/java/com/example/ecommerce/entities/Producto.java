package com.example.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table(name="producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String descripcion;
    private Double precio;
    //ManyToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn(name ="venta" )
    //private Venta venta;
}
