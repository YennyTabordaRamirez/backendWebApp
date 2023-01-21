package com.clientes.apirest.clientes.apirest.service;

import com.clientes.apirest.clientes.apirest.entity.ClienteEntity;

import java.util.List;

public interface IClienteService {

    public List<ClienteEntity> findAll();
    public ClienteEntity findById(Long id);
    public ClienteEntity save(ClienteEntity clienteEntity);
    //public ClienteEntity update(ClienteEntity clienteEntity);
    public void deleteById(Long id);
}
