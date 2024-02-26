package dev_Ronaldo.requestcreditsystem.controller

import dev_Ronaldo.requestcreditsystem.dto.CreditDto
import dev_Ronaldo.requestcreditsystem.dto.CreditView
import dev_Ronaldo.requestcreditsystem.dto.CreditViewList
import dev_Ronaldo.requestcreditsystem.entity.Credit
import dev_Ronaldo.requestcreditsystem.service.impl.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource (
    private val creditService: CreditService
)
{
    @PostMapping
    fun saveCredit (@RequestBody @Valid creditDto: CreditDto): ResponseEntity <String> {
        val credit : Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Custumer ${credit.custumer?.firstName} saved!")
    }

    @GetMapping
    fun findAllByCustumerId (@RequestParam(value = "custumerId") custumerId: Long
    ): ResponseEntity <List<CreditViewList>>{
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCustumer(custumerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode (@RequestParam(value = "custumerId") custumerId: Long,
                          @PathVariable creditCode: UUID
    ): ResponseEntity <CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(custumerId,creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}