package br.com.passos.controle_saida_caminhao.service;

import br.com.passos.controle_saida_caminhao.models.Motorista;
import br.com.passos.controle_saida_caminhao.repository.MotoristaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    public List<Motorista> findAll() {
        List<Motorista> motoristas = motoristaRepository.findAll();
        return motoristas.stream().sorted(Comparator.comparing(Motorista::getNome)).toList();
    }

    public Motorista findByCnh(int cnh) {
        return Optional.ofNullable(this.motoristaRepository.findByCnh(cnh))
                .orElseThrow(() -> new NotFoundException("Motorista com CNH " + cnh + " não encontrado."));
    }

    public void update(long id, Motorista motorista) {
        Motorista motoristaAtual = this.motoristaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Motorista não encontrado."));

        motoristaAtual.setNome(motorista.getNome());
        motoristaAtual.setCnh(motorista.getCnh());

        this.motoristaRepository.save(motoristaAtual);
    }

    public void delete(long id) {
        this.motoristaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Motorista não encontrado."));

        this.motoristaRepository.deleteById(id);
    }

}
