package com.clientes.apirest.clientes.apirest.service;

import com.clientes.apirest.clientes.apirest.entity.ClienteEntity;
import com.clientes.apirest.clientes.apirest.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ClienteEntity> findAll() {
        return (List<ClienteEntity>) iClienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteEntity findById(Long id) {
        return iClienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public ClienteEntity save(ClienteEntity clienteEntity) {
        return iClienteRepository.save(clienteEntity);
    }

    @Override
    @Transactional()
    public void deleteById(Long id) {
        iClienteRepository.deleteById(id);
    }
}
