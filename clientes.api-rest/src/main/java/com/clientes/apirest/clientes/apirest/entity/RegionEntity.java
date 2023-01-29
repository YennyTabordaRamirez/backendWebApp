package com.clientes.apirest.clientes.apirest.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "regiones")
public class RegionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message ="no puede estar vacio")
    @Size(min = 4, max = 20, message = "Debe tener entre 4 y 20 letras")
    @Column(nullable = false)
    private String nombre;

}
