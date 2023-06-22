package com.example.exercicio1jpa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
    @Id
  private  Long id;
  private String rua;
  private String cidade;
  private String estado;
  private String cep;
}
