package com.clientes.apirest.clientes.apirest.service;

import com.clientes.apirest.clientes.apirest.entity.UsuarioEntity;
import com.clientes.apirest.clientes.apirest.repository.IUsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserName(username);

        if(usuarioEntity == null){
            logger.error("Error en el login: o existe el usuario: " + username + " en el sistema");
            throw new UsernameNotFoundException("Error en el login: o existe el usuario: " + username + " en el sistema");
        }

        List<GrantedAuthority> authorities = usuarioEntity.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> logger.info("Rol: "+ authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuarioEntity.getUserName(), usuarioEntity.getPassword(),
                usuarioEntity.isEnabled(), true, true, true, authorities);
    }
}
