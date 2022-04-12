package com.santander.banco811.repository;

import com.santander.banco811.model.Usuario;
import com.santander.banco811.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@DataJpaTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void validar_findAll_vazio_se_repository_em_branco(){

        var usuarios = usuarioRepository.findAll();

        Assertions.assertEquals(Arrays.asList(), usuarios);
    }

    @Test
    public void trazer_usuarios_cadastrados_no_findAll(){

        Usuario usuario = new Usuario();
        usuario.setNome("andre");
        usuario.setSenha("12345678");
        usuario.setCpf("33344432112");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("flor");
        usuario2.setSenha("12345679");
        usuario2.setCpf("11122233398");

        entityManager.persist(usuario);
        entityManager.persist(usuario2);

        var usuarios = usuarioRepository.findAll();

        Assertions.assertEquals(Arrays.asList(usuario, usuario2), usuarios);
    }

}
