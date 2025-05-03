package com.eli.potatoapi.controller

import com.eli.potatoapi.model.Potato
import com.eli.potatoapi.repository.PotatoRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RequestMapping("/api/potatoes")
@RestController
class PotatoController(private val potatoRepository: PotatoRepository) {

    @GetMapping
    fun getAllPotatoes(): List<Potato> = potatoRepository.findAll()

    @GetMapping("/{id}")
    fun getPotatoByID(@PathVariable id: Int): Potato {
        return potatoRepository
            .findById(id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND, "Potato not found!") }
    }

}
