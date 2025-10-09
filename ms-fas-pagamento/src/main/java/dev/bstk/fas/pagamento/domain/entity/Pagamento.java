package dev.bstk.fas.pagamento.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAGAMENTO")
public class Pagamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PEDIDO_ID")
    private UUID pedidoId;

    @NotNull
    @Column(name = "CLIENTE_ID")
    private UUID clienteId;

    @Column(name = "TRANSACAO_ID")
    private UUID transacaoId;

    @NotNull
    @PositiveOrZero
    @Column(name = "VALOR")
    private BigDecimal valor;

    @NotEmpty
    @Column(name = "MOEDA")
    private String moeda;

    @NotNull
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private PagamentoStatus status;

    @NotNull
    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private PagamentoTipo tipo;

    @NotNull
    @Column(name = "DATA_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao;

    @NotNull
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    private void prePersist() {
        setDataCriacao(LocalDateTime.now());
        setDataAtualizacao(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate() {
        setDataAtualizacao(LocalDateTime.now());
    }
}