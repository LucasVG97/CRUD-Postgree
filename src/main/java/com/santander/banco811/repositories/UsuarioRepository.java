package com.santander.banco811.repositories;

import com.santander.banco811.dto.responses.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>, JpaSpecificationExecutor<Usuario>, QuerydslPredicateExecutor<Usuario> {

    //findBy é proveniente nativo do JpaRepository, só é preciso colocar a identificação do que esta buscando, nesse exemplo, nome
    Page<Usuario> findByNome(String nome, Pageable pageable);
    @Query("select new com.santander.banco811.dto.responses.UsuarioResponse(u.id, u.cpf, u.nome, u.dataCriacao, u.dataAtualizacao) from Usuario u where u.cpf = :cpf")
    Page<UsuarioResponse> findByCpf(@Param("cpf") String cpf, Pageable pageable);

}


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
