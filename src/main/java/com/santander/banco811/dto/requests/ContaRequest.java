package com.santander.banco811.dto.requests;

import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Setter
public class ContaRequest {
    private Integer usuarioId;
    private Integer numero;
    private Integer agencia;
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    private BigDecimal saldo;
    private Usuario usuario;


}
