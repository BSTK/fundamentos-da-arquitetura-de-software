package dev.bstk.fas.pagamento.domain.entity;

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
@Table(name = "PAGAMENTO")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PEDIDO_ID")
    private UUID pedidoId;

    @NotNull
    @Column(name = "CLIENTE_ID")
    private UUID clienteId;

    @NotNull
    @PositiveOrZero
    @Column(name = "VALOR")
    private BigDecimal valor;

    @NotEmpty
    @Column(name = "MOEDA")
    private String moeda;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusPagamento status;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "MEIO_PAGAMENTO")
    private MeioPagamento meioPagamento;

    @NotNull
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @NotNull
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;

    @NotEmpty
    @Column(name = "TRANSACAO_ID")
    private String transacaoId;

    public enum StatusPagamento {
        PENDENTE,
        APROVADO,
        RECUSADO,
        EXPIRADO
    }

    public enum MeioPagamento {
        CARTAO,
        PIX,
        BOLETO
    }
}
