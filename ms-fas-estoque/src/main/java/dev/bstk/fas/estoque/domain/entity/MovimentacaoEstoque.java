package dev.bstk.fas.estoque.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOVIMENTACAO_ESTOQUE")
public class MovimentacaoEstoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PRODUTO_ID")
    private UUID produtoId;

    @Column(name = "PEDIDO_ID")
    private UUID pedidoId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private TipoMovimentacao tipo;

    @Positive
    @Column(name = "QUANTIDADE")
    private int quantidade;

    @NotEmpty
    @Column(name = "MOTIVO")
    private String motivo;

    @NotNull
    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    public enum TipoMovimentacao {
        ENTRADA,
        SAIDA,
        AJUSTE
    }
}
