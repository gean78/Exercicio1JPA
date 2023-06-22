package com.example.exercicio1jpa.Repository;

import com.example.exercicio1jpa.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface EnderecoRepository extends JpaRepository<Endereco, Long> {


    Endereco findByCidade(String cidade);
     List<Endereco> findAllByCidade(String cidade);
    Endereco findByCep(String cep);
    List<Endereco> findAllByCep(String cep);
    Endereco findByRua(String rua);
    List<Endereco> findAllByRua(String rua);
}

