package ijeremic.smartgarden.repositories

import ijeremic.smartgarden.entities.PlantEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlantRepository : JpaRepository<PlantEntity, Long> {

}
