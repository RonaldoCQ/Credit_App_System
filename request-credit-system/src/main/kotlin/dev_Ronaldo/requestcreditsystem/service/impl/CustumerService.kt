package dev_Ronaldo.requestcreditsystem.service.impl

import dev_Ronaldo.requestcreditsystem.entity.Custumer
import dev_Ronaldo.requestcreditsystem.repository.CustumerRepository
import dev_Ronaldo.requestcreditsystem.service.ICustumerService
import org.springframework.stereotype.Service

@Service
class CustumerService ( private val custumerRepository: CustumerRepository ): ICustumerService {
    override fun save(custumer: Custumer): Custumer =
        this.custumerRepository.save(custumer)

    override fun findById(id: Long): Custumer =
        this.custumerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id not found")
        }

    override fun delete(id: Long) = this.custumerRepository.deleteById(id)
}