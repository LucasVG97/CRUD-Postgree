package com.santander.banco811.repository;

import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.repositories.ContaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Arrays;

@DataJpaTest
@ActiveProfiles("test")
public class ContaRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ContaRepository contaRepository;

    @Test
    public void validar_se_existem_contas(){

        var contas = contaRepository.findAll();

        Assertions.assertEquals(Arrays.asList(), contas);
    }

}
