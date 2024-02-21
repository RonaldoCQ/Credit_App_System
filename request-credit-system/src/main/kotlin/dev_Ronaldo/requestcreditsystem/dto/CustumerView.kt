package dev_Ronaldo.requestcreditsystem.dto

import dev_Ronaldo.requestcreditsystem.entity.Custumer
import java.math.BigDecimal

data class CustumerView (
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
){
    constructor(custumer: Custumer): this (
        firstName = custumer.firstName,
        lastName = custumer.lastName,
        cpf = custumer.cpf,
        income = custumer.income,
        email = custumer.email,
        zipCode = custumer.address.zipCode,
        street = custumer.address.street
    )
}
