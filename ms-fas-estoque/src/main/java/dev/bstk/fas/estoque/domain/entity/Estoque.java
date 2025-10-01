package dev.bstk.fas.estoque.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ESTOQUE")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PRODUTO_ID")
    private UUID produtoId;

    @PositiveOrZero
    @Column(name = "QUANTIDADE_ATUAL")
    private int quantidadeAtual;

    @NotEmpty
    @Column(name = "LOCALIZACAO")
    private String localizacao;

    @NotNull
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;
}
