package com.eli.potatoapi.repository

import com.eli.potatoapi.model.Potato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PotatoRepository : JpaRepository<Potato, Long>
