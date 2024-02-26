package dev_Ronaldo.requestcreditsystem.dto

import dev_Ronaldo.requestcreditsystem.entity.Address
import dev_Ronaldo.requestcreditsystem.entity.Custumer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CPF
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal

data class CustumerDto(
    @field:NotEmpty(message = "Invalid Input") val firstName: String,
    @field:NotEmpty(message = "Invalid Input") val lastName: String,
    @field:CPF(message = "Invalid CPF entry") val cpf: String,
    @field:NotNull("Invalid Numerical entry") val income: BigDecimal,
    @field:Email(message = "Invalid Email entry") val email: String,
    @field:NotEmpty(message = "Invalid Input") val password: String,
    @field:NotEmpty(message = "Invalid Input") val zipCode: String,
    @field:NotEmpty(message = "Invalid Input") val street: String
) {

    fun toEntity(): Custumer = Custumer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode, street = this.street
        )

    )
}
