package com.santander.banco811.services;

import com.santander.banco811.dto.requests.ContaRequest;
import com.santander.banco811.dto.responses.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.projection.ContaView;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContaService {

    ContaResponse create(ContaRequest contaRequest);

    List<ContaView> getAllViewByTipoConta(TipoConta tipoConta);

    void delete(Integer id);

    Page<Conta> getAll(int page, int size);
}
