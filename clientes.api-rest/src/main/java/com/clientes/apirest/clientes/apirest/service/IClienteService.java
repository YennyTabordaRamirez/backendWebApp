package com.clientes.apirest.clientes.apirest.service;

import com.clientes.apirest.clientes.apirest.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {

    public List<ClienteEntity> findAll();
    public Page<ClienteEntity> findAll(Pageable pageable);
    public ClienteEntity findById(Long id);
    public ClienteEntity save(ClienteEntity clienteEntity);
    //public ClienteEntity update(ClienteEntity clienteEntity);
    public void deleteById(Long id);
}
