package com.santander.banco811.repositories;

import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.projection.ContaView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository <Conta, Integer> {
    List<ContaView> findAllByTipoConta(TipoConta tipoConta);

    @Query("select c from Conta c where c.id = :id")
    Conta getByContaId(@Param("id") Integer id);

}


//    List<Conta> findBySaldoLessThan(BigDecimal saldo);
//    List<Conta> findBySaldoLessThanEqual(BigDecimal saldo);
//    List<Conta> findBySaldoGreaterThan(BigDecimal saldo);
//    List<Conta> findBySaldoGreaterThanEqual(BigDecimal saldo);
//    List<Conta> findBySaldoBetween(BigDecimal saldoInicial, BigDecimal saldoFinal);
//    List<Conta> findBySaldoIn(List<BigDecimal > saldos);
//    List<Conta> findByTipoConta(TipoConta tipoConta);
//    List<Conta> findByUsuario_Cpf(String cpf);
//    Boolean existsByTipoConta(TipoConta tipoConta);
//Em alguns casos mais complexos, o Jpa não consegue interpretar a sintaxe e a query não pode ser criada, nesses casos deve-se usar @Query com a sentença requirida, tem-se 2 escritas possíveis:
//    @Query("select c from Conta c where(c.tipoConta = ?1 and c.agencia = ?2) or (c.tipoConta = ?1 or c.saldo = ?3)")
//    List<Conta> findByTipoContaAndAgenciaOrTipoContaAndSaldo(
//            TipoConta tipoConta,
//            String agencia,
//            BigDecimal saldo);
//    @Query("select c from Conta c where(c.tipoConta = :tipoConta and c.agencia = :agencia) or (c.tipoConta = :tipoConta and c.saldo = :saldo)")
//    List<Conta> findByTipoContaAndAgenciaOrTipoContaAndSaldo(
//    @Param("tipoConta") TipoConta tipoConta,
//    @Param("agencia") String agencia,
//    @Param("saldo") BigDecimal saldo);
//vale salientar que é possivel utilizar a linguagem nativa do banco de dados, dentro do query, desde que após os final das " tenha-se ,nativeQuery = true. exemplo:
//    @Query(value = "select * from Conta c where(c.tipo_conta = :tipoConta AND c.agencia = :agencia) OR (c.tipo_conta = :tipoConta AND c.saldo = :saldo)", nativeQuery = true)