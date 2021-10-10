package com.dio.live.repository;

import com.dio.live.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioRapository extends JpaRepository<Calendario, Long> {
}
