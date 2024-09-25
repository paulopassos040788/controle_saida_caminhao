package br.com.passos.controle_saida_caminhao.controller;

import br.com.passos.controle_saida_caminhao.models.Motorista;
import br.com.passos.controle_saida_caminhao.models.dto.MotoristaMapper;
import br.com.passos.controle_saida_caminhao.models.dto.MotoristaRequestDTO;
import br.com.passos.controle_saida_caminhao.service.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/motorista")
public class MotoristaController {

    private final MotoristaService motoristaService;

    @Autowired
    private MotoristaMapper motoristaMapper;

    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @PostMapping
    public ResponseEntity<Void> add (@Valid @RequestBody MotoristaRequestDTO motoristaRequestDTO){
        Motorista motorista = motoristaMapper.map(motoristaRequestDTO);
        motoristaService.add(motorista);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<MotoristaRequestDTO>> getAll(){
        List<Motorista> motoristas = motoristaService.findAll();
        List<MotoristaRequestDTO> dtos = motoristas.stream().map(motoristaMapper::map).toList();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);

    }

}
