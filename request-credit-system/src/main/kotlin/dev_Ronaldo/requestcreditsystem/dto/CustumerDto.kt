package dev_Ronaldo.requestcreditsystem.dto

import dev_Ronaldo.requestcreditsystem.entity.Address
import dev_Ronaldo.requestcreditsystem.entity.Custumer
import java.math.BigDecimal

data class CustumerDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
) {

    fun toEntity(): Custumer = Custumer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )

    )
}