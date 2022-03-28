package com.santander.banco811.repository;

import com.santander.banco811.model.Usuario;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

    //findBy é proveniente nativo do JpaRepository, só é preciso colocar a identificação do que esta buscando, nesse exemplo, nome
    List<Usuario> findByNome(String nome);
//    List<Usuario>findByNomeAndCpf(String nome, String cpf);
//    List<Usuario>findByNomeIs(String nome);
//    List<Usuario>findByNomeIsNot(String nome);
//    List<Usuario>findByNomeIsNull(String nome);
//    List<Usuario>findByNomeIsNotNull(String nome);
//    List<Usuario>findByCpfStartingWith(String cpf);
//    List<Usuario>findByCpfEndingWith(String cpf);
//    List<Usuario>findByNomeContaining(String nome);
//    Pode se passar tbm expressões regex
//    List<Usuario> findByNomeLike(String pattern);
//    List<Usuario> findByDataCriacaoAfter(LocalDateTime dataCriacao);
//    List<Usuario> findByDataCriacao(LocalDateTime dataCriacao);
//    List<Usuario> findByNomeOrderByNomeAsc(String nome);
//    List<Usuario> findByNomeAndDataCriacaoOrderByNomeDesc(String nome, LocalDateTime dataCriacao);
}
