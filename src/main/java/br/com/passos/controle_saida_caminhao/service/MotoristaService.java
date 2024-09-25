package br.com.passos.controle_saida_caminhao.service;

import br.com.passos.controle_saida_caminhao.models.Motorista;
import br.com.passos.controle_saida_caminhao.repository.MotoristaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public void add(Motorista motorista) {
        try {
            motoristaRepository.save(motorista);
        } catch (DataIntegrityViolationException e) {
            throw new MotoristaUniqueException("A CNH que você está tentando cadastrar, já pertence a outro motorista.");
        }
    }

}
