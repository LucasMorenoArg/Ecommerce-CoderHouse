package com.example.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name="comprobantes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comprobante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ventaId;
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    private int cantidad;

    private String fechaComprobante;

    private Long precioTotal;


}
