package dev_Ronaldo.requestcreditsystem.exception

data class BusinessException(override val message: String?): RuntimeException(message)
