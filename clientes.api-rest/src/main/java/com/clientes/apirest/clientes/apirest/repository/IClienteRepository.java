package com.clientes.apirest.clientes.apirest.repository;

import com.clientes.apirest.clientes.apirest.entity.ClienteEntity;
import com.clientes.apirest.clientes.apirest.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Query("from RegionEntity")
    public List<RegionEntity> findAllRegiones();
}
