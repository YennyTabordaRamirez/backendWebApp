package com.clientes.apirest.clientes.apirest.repository;

import com.clientes.apirest.clientes.apirest.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    public UsuarioEntity findByUserName(String userName);

    @Query("select u from usuarios u where u.userName=?1")
    public UsuarioEntity findByUserName2(String userName);
}
