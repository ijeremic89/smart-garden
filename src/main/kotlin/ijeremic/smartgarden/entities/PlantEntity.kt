package ijeremic.smartgarden.entities

import ijeremic.smartgarden.dtos.PlantDTO
import ijeremic.smartgarden.enums.PlantType
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "plants")
open class PlantEntity(

    @Column(name = "name", nullable = false)
    open var name: String = "",

    @Column(name = "description", nullable = false)
    open var description: String = "",

    @Column(name = "type", nullable = false)
    open var type: PlantType = PlantType.UNKNOWN,

    ) : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long = 0

    fun toDto(): PlantDTO = PlantDTO(
        id = id,
        name = name,
        description = description,
        type = type
    )
}