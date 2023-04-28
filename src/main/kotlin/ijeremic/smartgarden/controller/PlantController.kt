package ijeremic.smartgarden.controller

import ijeremic.smartgarden.dtos.PlantDTO
import ijeremic.smartgarden.services.PlantService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/plants")
class PlantController(
    private val plantService: PlantService
) {

    @GetMapping("/getPlant/{id}")
    fun getPlant(@PathVariable id: Long): PlantDTO {
        return plantService.findById(id)
    }

    @GetMapping("/getPlants")
    fun getPlants(): List<PlantDTO> {
        return plantService.findAll()
    }

    @PostMapping("/createPlant")
    fun createPlant(@RequestBody plantDTO: PlantDTO) {
        return plantService.create(plantDTO)
    }

    @PostMapping("/editPlant/{id}")
    fun editPlant(@RequestBody plantDTO: PlantDTO, @PathVariable id: Long) {
        return plantService.edit(plantDTO, id)
    }

    @DeleteMapping("/deletePlant/{id}")
    fun deletePlant(@PathVariable id: Long) {
        return plantService.delete(id)
    }
}