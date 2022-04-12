package com.santander.banco811.services.impl;

import com.santander.banco811.dto.requests.ContaRequest;
import com.santander.banco811.dto.responses.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.projection.ContaView;
import com.santander.banco811.repositories.ContaRepository;
import com.santander.banco811.repositories.UsuarioRepository;
import com.santander.banco811.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ContaResponse create(ContaRequest contaRequest) {

        Usuario usuario = usuarioRepository.findById(contaRequest.getUsuarioId()).orElseThrow();
        Conta conta = new Conta(contaRequest);
        conta.setUsuario(usuario);
        Conta salva = contaRepository.save(conta);
        return new ContaResponse(salva);
        }
    @Override
    public List<ContaView> getAllViewByTipoConta(TipoConta tipoConta){
        return contaRepository.findAllByTipoConta(tipoConta);
    }

    @Override
    public void delete(Integer id) {
        contaRepository.delete(contaRepository.getByContaId(id));
    }

    @Override
    public Page<Conta> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size
        );
            return contaRepository.findAll(pageRequest);
        }
}


