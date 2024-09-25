package br.com.passos.controle_saida_caminhao.models.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MotoristaRequestDTO {

    @NotEmpty
    private String nome;

    private Integer cnh;

}
