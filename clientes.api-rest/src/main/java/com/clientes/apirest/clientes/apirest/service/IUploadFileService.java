package com.clientes.apirest.clientes.apirest.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {

    public Resource cargarFoto(String nombreFoto) throws MalformedURLException;
    public String copiar(MultipartFile archivo) throws IOException;
    public boolean eliminarFoto(String nombreFoto);
    public Path getPath(String nombreFoto);
}
