package com.clientes.apirest.clientes.apirest.repository;

import com.clientes.apirest.clientes.apirest.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    public UsuarioEntity findByUserName(String userName);

    @Query("select u from UsuarioEntity u where u.userName=?1")
    public UsuarioEntity findByUserName2(String userName);
}
