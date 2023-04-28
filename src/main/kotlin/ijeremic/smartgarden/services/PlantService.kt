package ijeremic.smartgarden.services

import ijeremic.smartgarden.dtos.PlantDTO
import ijeremic.smartgarden.entities.PlantEntity
import ijeremic.smartgarden.repositories.PlantRepository
import org.springframework.stereotype.Service

@Service
class PlantService(
    private val repository: PlantRepository
) {
    fun findById(id: Long): PlantDTO =
        repository.findById(id).map { it.toDto() }.orElseThrow {
            Exception("Plant with ID:$id not found")
        }

    fun findAll(): List<PlantDTO> =
        repository.findAll().map { it.toDto() }

    fun create(plantDTO: PlantDTO) {
        val plant = PlantEntity(
            name = plantDTO.name,
            description = plantDTO.description,
            type = plantDTO.type
        )
        repository.save(plant)
    }

    fun edit(plantDTO: PlantDTO, id: Long) {
        repository.findById(id).map {
            it.name = plantDTO.name
            it.description = plantDTO.description
            it.type = plantDTO.type
            repository.save(it)
        }.orElseThrow {
            Exception("Plant with ID:$id not found")
        }
    }

    fun delete(id: Long) {
        repository.findById(id).map {
            repository.deleteById(id)
        }.orElseThrow {
            Exception("Plant with ID:$id not found")
        }
    }
}
