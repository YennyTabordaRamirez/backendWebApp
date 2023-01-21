package com.clientes.apirest.clientes.apirest.repository;

import com.clientes.apirest.clientes.apirest.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<ClienteEntity, Long> {
}
