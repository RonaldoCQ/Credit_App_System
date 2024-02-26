package dev_Ronaldo.requestcreditsystem.service.impl

import dev_Ronaldo.requestcreditsystem.entity.Credit
import dev_Ronaldo.requestcreditsystem.repository.CreditRepository
import dev_Ronaldo.requestcreditsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val custumerService: CustumerService
)
    : ICreditService  {
    override fun save(credit: Credit): Credit {
        credit.apply{
            custumer = custumerService.findById(credit.custumer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustumer(custumerId: Long): List<Credit> = this.creditRepository.findAllByCustumerId(custumerId)


    override fun findByCreditCode(custumerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException ("Credit code $creditCode not found"))
        return if (credit.custumer?.id == custumerId) credit else throw IllegalArgumentException("Contact admin")
    }
}