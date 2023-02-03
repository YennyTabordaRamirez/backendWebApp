package com.clientes.apirest.clientes.apirest.auth;

import com.clientes.apirest.clientes.apirest.entity.UsuarioEntity;
import com.clientes.apirest.clientes.apirest.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private IUsuarioService iUsuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        UsuarioEntity usuarioEntity = iUsuarioService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();

        info.put("info_adicional", "cualquier valor para ".concat(authentication.getName()));


       //info.put("nombre_usuario", usuarioEntity.getId()+ ": " +usuarioEntity.getUsername());
        //info.put("nombre", usuarioEntity.getNombre());
        //info.put("apellido", usuarioEntity.getApellido());
        //info.put("email", usuarioEntity.getEmail());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
