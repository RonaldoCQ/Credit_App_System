package dev_Ronaldo.requestcreditsystem.entity

import dev_Ronaldo.requestcreditsystem.enumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
@Entity // Marca a Classe como tabela no DB
@Table(name = "Credit") // Muda o nome da tabela


data class Credit (
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var custumer: Custumer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null //@id indica essa iteração como PK
)

