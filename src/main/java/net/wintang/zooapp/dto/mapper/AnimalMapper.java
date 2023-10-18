package net.wintang.zooapp.dto.mapper;

import net.wintang.zooapp.dto.request.AnimalRequestDTO;
import net.wintang.zooapp.dto.response.AnimalResponseDTO;
import net.wintang.zooapp.entity.Animal;
import net.wintang.zooapp.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalMapper {

    private final SpeciesRepository speciesRepository;

    @Autowired
    public AnimalMapper(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Object mapToAnimalDTO(List<Animal> animals) {
        return animals.stream().map(AnimalResponseDTO::new).toList();
    }

    public Animal mapToAnimalEntity(AnimalRequestDTO dto) {
        return Animal.builder()
                .name(dto.getName())
                .sex(dto.isSex())
                .arrivalDate(dto.getArrivalDate())
                .dateOfBirth(dto.getDateOfBirth())
                .origin(dto.getOrigin())
                .species(speciesRepository.findByName(dto.getSpecies()))
                .imgUrl(dto.getImgUrl())
                .build();
    }
}
