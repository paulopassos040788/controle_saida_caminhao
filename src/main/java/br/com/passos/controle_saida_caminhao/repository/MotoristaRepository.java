package br.com.passos.controle_saida_caminhao.repository;

import br.com.passos.controle_saida_caminhao.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    @Query("select motorista from Motorista motorista where motorista.cnh = :cnh")
    public Motorista findByCnh(@Param("cnh") int cnh);

}
