package br.com.passos.controle_saida_caminhao.models.dto;

import br.com.passos.controle_saida_caminhao.models.Motorista;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MotoristaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "cnh", source = "cnh")
    Motorista map(MotoristaRequestDTO motoristaRequestDTO);

    //@Mapping(target = "name", source = "nome")
    //UsuarioResponse map(UsuarioEntity usuarioEntity);
}
