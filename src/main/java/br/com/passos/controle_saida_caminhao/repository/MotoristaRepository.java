package br.com.passos.controle_saida_caminhao.repository;

import br.com.passos.controle_saida_caminhao.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
}
