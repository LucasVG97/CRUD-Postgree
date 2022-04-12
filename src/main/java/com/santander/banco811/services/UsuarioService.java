package com.santander.banco811.services;

import com.santander.banco811.dto.requests.UsuarioRequest;
import com.santander.banco811.dto.responses.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsuarioService {
    Page<Usuario> getAll(String nome, int page, int size);

    Page<UsuarioResponse> getAllByCpf(String cpf, int page, int size);

    UsuarioResponse create(UsuarioRequest usuarioRequest);

    Usuario getById(Integer id);

    Usuario update(UsuarioRequest usuarioRequest, Integer id);

    void delete(Integer id);

    List<Usuario> search(String search);
}
