package com.clientes.apirest.clientes.apirest.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class RolEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message ="no puede estar vacio")
    @Column(unique = true, length = 20)
    private String nombre;

    //@ManyToMany(mappedBy = "roles")
    //private List<UsuarioEntity> usuarios;

}
