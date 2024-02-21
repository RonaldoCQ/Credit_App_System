package dev_Ronaldo.requestcreditsystem.service

import dev_Ronaldo.requestcreditsystem.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save (credit: Credit): Credit
    fun findAllByCustumer(custumerId: Long): List<Credit>
    fun findByCreditCode(custumerId: Long, creditCode: UUID): Credit
}