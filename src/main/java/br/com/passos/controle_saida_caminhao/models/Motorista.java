package br.com.passos.controle_saida_caminhao.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(length = 80, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer cnh;

}
