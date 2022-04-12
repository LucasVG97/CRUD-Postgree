package com.santander.banco811.services.impl;

import com.santander.banco811.dto.requests.UsuarioRequest;
import com.santander.banco811.dto.responses.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.repositories.UsuarioRepository;
import com.santander.banco811.services.UsuarioService;
import com.santander.banco811.specification.UsuarioSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> getAll(String nome, int page, int size) {

        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC, "nome"
        );
        if (nome != null){
            return usuarioRepository.findByNome(nome, pageRequest);
        } else {
            return usuarioRepository.findAll(pageRequest);
        }
    }

    @Override
    public Page<UsuarioResponse> getAllByCpf(String cpf, int page, int size){
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC, "nome"
        );
        return usuarioRepository.findByCpf(cpf, pageRequest);
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest);
        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    @Override
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public Usuario update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuario);
    }

    @Override
    public List<Usuario> search(String search){
        UsuarioSpecificationBuilder builder = new UsuarioSpecificationBuilder();
        //padrão regex para alfanumerico, operador e alfanumerico ex: nome: Maria
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");

        while(matcher.find()){
            builder.with(
                    //mathcher.group irá procurar os 3 grupos alfanum. op. e alfanum.
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3)
            );
        }

        Specification<Usuario> spec = builder.build();

        return  usuarioRepository.findAll(spec);
    }

}
