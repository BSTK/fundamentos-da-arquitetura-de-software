package dev.bstk.fas.inventario.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "TITULO")
    private String titulo;

    @NotEmpty
    @Column(name = "AUTOR")
    private String autor;

    @NotEmpty
    @Column(name = "ISBN")
    private String isbn;

    @NotNull
    @PositiveOrZero
    @Column(name = "PRECO")
    private BigDecimal preco;

    @PositiveOrZero
    @Column(name = "QUANTIDADE_DISPONIVEL")
    private int quantidadeDisponivel;

    @Column(name = "ATIVO")
    private boolean ativo;

    @NotNull
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;
}
