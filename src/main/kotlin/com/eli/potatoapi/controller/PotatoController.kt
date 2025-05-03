package com.eli.potatoapi.controller

import com.eli.potatoapi.model.Potato
import com.eli.potatoapi.repository.PotatoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/potatoes")
@RestController
class PotatoController(private val potatoRepository: PotatoRepository) {

    @GetMapping
    fun getAllPotatoes(): List<Potato> = potatoRepository.findAll()
}