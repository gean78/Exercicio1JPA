package com.example.exercicio1jpa.Service;

import com.example.exercicio1jpa.Entity.Endereco;
import com.example.exercicio1jpa.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {


        @Autowired
        private EnderecoRepository enderecoRepository;

        public Endereco salvarEndereco(Endereco endereco){
            return enderecoRepository.save(endereco);
        }

        public Endereco buscarEndereco(Long id){
            return enderecoRepository.findById(id).get();
        }

        public List<Endereco> buscarenderecos(){
            return enderecoRepository.findAll();
        }

        public Endereco atualizarEndereco(Endereco endereco){
            return enderecoRepository.save(endereco);
        }

        public void apagarEndereco(Long id){
            if(enderecoRepository.existsById(id)) {
                enderecoRepository.deleteById(id);
            }else {
                throw new RuntimeException("Endereco não encontrado");
            }
        }
    public List<Endereco> buscarEnderecoPorCidade(String cidade){
        return enderecoRepository.findAllByCidade(cidade);
    }
    public List <Endereco> buscarEnderecoPorCep(String cep){
        return enderecoRepository.findAllByCep(cep);
    }
    public List<Endereco> buscarEnderecoPorRua(String rua){
        return  enderecoRepository.findAllByRua(rua);
    }



    }

