package dev_Ronaldo.requestcreditsystem.dto

import dev_Ronaldo.requestcreditsystem.entity.Credit
import dev_Ronaldo.requestcreditsystem.entity.Custumer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    @field:NotNull("Invalid Numerical entry") val creditValue: BigDecimal,
    @field:Future val dayFirstInstallment: LocalDate,
    val numberOfInstallment: Int,
    @field:NotNull("Invalid Input") val custumerId: Long
) {

    fun toEntity (): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallment = this.numberOfInstallment,
        custumer = Custumer(id = this.custumerId)
    )
}
