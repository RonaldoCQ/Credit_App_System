package dev_Ronaldo.requestcreditsystem.dto

import dev_Ronaldo.requestcreditsystem.entity.Custumer
import java.math.BigDecimal

data class CustumerUpdateDto (
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
){
    fun toEntity(custumer: Custumer): Custumer {
        custumer.firstName = this.firstName
        custumer.lastName = this.lastName
        custumer.income = this.income
        custumer.address.zipCode = this.zipCode
        custumer.address.street = this.street
        return custumer
    }
}
