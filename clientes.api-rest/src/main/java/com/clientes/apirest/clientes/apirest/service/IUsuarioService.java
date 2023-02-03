package com.clientes.apirest.clientes.apirest.service;

import com.clientes.apirest.clientes.apirest.entity.UsuarioEntity;

public interface IUsuarioService {

    public UsuarioEntity findByUsername(String username);

}
