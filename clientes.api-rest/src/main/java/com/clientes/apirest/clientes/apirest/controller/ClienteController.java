package com.clientes.apirest.clientes.apirest.controller;
import com.clientes.apirest.clientes.apirest.entity.ClienteEntity;
import com.clientes.apirest.clientes.apirest.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/clientes")
    public List<ClienteEntity>  getAllClientes(){
        return iClienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id){
        ClienteEntity clienteEntity = null;
        Map<String, Object> response = new HashMap<>();
        try {
            clienteEntity = iClienteService.findById(id);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta del id en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(clienteEntity == null){
            response.put("mensaje", "El cliente con id: ".concat(id.toString().concat(" no existe en la base de datos.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ClienteEntity>(clienteEntity, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> postCliente(@Valid @RequestBody ClienteEntity clienteEntity, BindingResult result){
        ClienteEntity clientenuevo = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()){
           /* List<String>errors = new ArrayList<>();
            for(FieldError err:  result.getFieldErrors()){
                errors.add("El campo '" + err.getField()+ "' " + err.getDefaultMessage());
            }*/ //esta es la forma anterior al JDK 8 la que sigue es la forma actualizada luego del JDK8

            List<String>errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField()+ "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            clientenuevo = iClienteService.save(clienteEntity);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el guardado del id en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Cliente creado con éxito");
        response.put("cliente", clientenuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> putCliente(@Valid  @RequestBody ClienteEntity clienteEntity, BindingResult result,
                                        @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()){
            List<String>errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField()+ "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        ClienteEntity clienteActual =  iClienteService.findById(id);
        ClienteEntity clienteActualizado = null;

        if(clienteActual == null){
            response.put("mensaje", "No se pudo editar. El cliente con id: ".concat(id.toString().concat(" no existe en la base de datos.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{
            clienteActual.setNombre(clienteEntity.getNombre());
            clienteActual.setApellido(clienteEntity.getApellido());
            clienteActual.setEmail(clienteEntity.getEmail());
            clienteActual.setCreateAt(clienteEntity.getCreateAt());

            clienteActualizado = iClienteService.save(clienteActual);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al actualizar el cliente en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Cliente actualizado con éxito");
        response.put("cliente", clienteActualizado);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        try {
            iClienteService.deleteById(id);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al eliminar el cliente de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Cliente eliminado con éxito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
