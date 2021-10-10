package com.dio.live.repository;

import com.dio.live.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long> {
}
