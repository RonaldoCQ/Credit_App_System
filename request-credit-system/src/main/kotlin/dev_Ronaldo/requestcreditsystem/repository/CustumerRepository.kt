package dev_Ronaldo.requestcreditsystem.repository

import dev_Ronaldo.requestcreditsystem.entity.Custumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustumerRepository : JpaRepository<Custumer, Long> {
}