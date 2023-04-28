package ijeremic.smartgarden.dtos

import ijeremic.smartgarden.enums.PlantType

data class PlantDTO(
    val id: Long,
    val name: String,
    val description: String,
    val type: PlantType
)