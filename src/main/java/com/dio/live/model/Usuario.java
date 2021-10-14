package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private  JornadaTrabalho jornadaTrabalho;

    private String nome;
    private BigDecimal tolerancia;
    private Time inicioJornada;
    private Time finalJornada;
}
