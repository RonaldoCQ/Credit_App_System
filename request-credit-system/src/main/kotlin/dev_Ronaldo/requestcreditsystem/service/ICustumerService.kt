package dev_Ronaldo.requestcreditsystem.service

import dev_Ronaldo.requestcreditsystem.entity.Custumer

interface ICustumerService {
    fun save(custumer: Custumer): Custumer
    fun findById(id: Long): Custumer
    fun delete(id: Long)
}