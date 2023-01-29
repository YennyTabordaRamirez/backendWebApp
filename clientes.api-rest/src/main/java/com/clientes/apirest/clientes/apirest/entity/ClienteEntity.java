package com.clientes.apirest.clientes.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "clientes")
public class ClienteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message ="no puede estar vacio")
    @Size(min = 4, max = 12, message = "Debe tener entre 4 y 12 letras")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message ="no puede estar vacio")
    private String apellido;

    @NotEmpty(message ="no puede estar vacio")
    @Email(message="no es una dirección de correo bien formada")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message ="no puede estar vacio")
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String foto;

    @NotNull(message = "La región no puede ser vacía")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private RegionEntity region;

    private static final long serialVersionUID = 1L;

    //@PrePersist
    //public void prePersist(){
        //createAt = new Date();}

}
