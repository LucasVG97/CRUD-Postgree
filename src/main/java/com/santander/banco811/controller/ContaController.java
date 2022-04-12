package com.santander.banco811.controller;

import com.santander.banco811.dto.requests.ContaRequest;
import com.santander.banco811.dto.requests.UsuarioRequest;
import com.santander.banco811.dto.responses.ContaResponse;
import com.santander.banco811.dto.responses.UsuarioResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.projection.ContaView;
import com.santander.banco811.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping
    public Page<Conta> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size){
        return contaService.getAll(page, size);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ContaResponse create(@RequestBody ContaRequest contaRequest){
        return contaService.create(contaRequest);
    }


    @GetMapping("/view")
    public List<ContaView> getAllContaViewByTipoConta(
            @RequestParam TipoConta tipoConta
    ){
        return contaService.getAllViewByTipoConta(tipoConta);
    }



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        contaService.delete(id);
    }

}
