package dev_Ronaldo.requestcreditsystem.repository

import dev_Ronaldo.requestcreditsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
}