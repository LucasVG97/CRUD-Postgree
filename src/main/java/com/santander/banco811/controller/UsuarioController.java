package com.santander.banco811.controller;

import com.querydsl.core.types.Predicate;
import com.santander.banco811.dto.requests.UsuarioRequest;
import com.santander.banco811.dto.responses.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.repositories.UsuarioRepository;
import com.santander.banco811.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public Page<Usuario> getAll(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size){
        return usuarioService.getAll(nome, page, size);
    }

    @GetMapping("/cpf")
    public Page<UsuarioResponse> getAllByCpf(
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
    ){
        return usuarioService.getAllByCpf(cpf, page, size);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id){
        return usuarioService.getById(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.update(usuarioRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        usuarioService.delete(id);
    }

    @GetMapping("/search")
    public List<Usuario> search(@RequestParam String search){
        return usuarioService.search(search);
    }

    @GetMapping("/search/dsl")
    public Iterable<Usuario> searchDsl(@QuerydslPredicate(root = Usuario.class) Predicate predicate){
        return usuarioRepository.findAll(predicate);

    }


}
