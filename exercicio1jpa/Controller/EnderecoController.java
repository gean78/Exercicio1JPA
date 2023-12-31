package com.example.exercicio1jpa.Controller;

import com.example.exercicio1jpa.Entity.Endereco;
import com.example.exercicio1jpa.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

    @RestController
    @RequestMapping("api/v1")
public class EnderecoController {
        @Autowired
        private
        EnderecoService enderecoService;

        @PostMapping("salvaendereco")
        public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco) {
            return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvarEndereco(endereco));
        }


        @GetMapping("endereco/{id}")
        public ResponseEntity<Endereco> buscarendereco(@PathVariable Long id) {
            Endereco endereco = enderecoService.buscarEndereco(id);
            if (endereco == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(endereco);
            }
        }

        @GetMapping("enderecos")
        public ResponseEntity<List<Endereco>> buscarEnderecos() {
            return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarenderecos());
        }

        @PutMapping("atualizaendereco")
        public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco) {
            return ResponseEntity.status(HttpStatus.OK).body(enderecoService.atualizarEndereco(endereco));
        }

        @DeleteMapping("apagaendereco/{id}")
        public ResponseEntity<String> apagarEndereco(@PathVariable Long id) {
            try {
                enderecoService.apagarEndereco(id);
                return ResponseEntity.status(HttpStatus.OK).body("Endereco com id " + id + " excluído com sucesso!");
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }
        }


        @GetMapping("endereco/cidade/{nomecidade}")
        public ResponseEntity<List<Endereco>> buscarEnderecosCidade(@PathVariable String nomecidade) {
            return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecoPorCidade(nomecidade));
        }

            @GetMapping("endereco/cep/{qualcep}")
        public ResponseEntity<List<Endereco>> buscarEnderecosCep(@PathVariable String qualcep){
                return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecoPorCep(qualcep));
        }
            @GetMapping("endereco/rua/{nomerua}")
        public ResponseEntity<List<Endereco>> buscarEnderecosRua(@PathVariable String nomerua){
                return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecoPorRua(nomerua));
            }
        }













