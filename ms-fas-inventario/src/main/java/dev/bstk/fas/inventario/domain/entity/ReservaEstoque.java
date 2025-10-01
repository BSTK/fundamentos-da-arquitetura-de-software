package dev.bstk.fas.inventario.domain.entity;

import jakarta.persistence.*;
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
@Table(name = "RESERVA_ESTOQUE")
public class ReservaEstoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PEDIDO_ID")
    private UUID pedidoId;

    @NotNull
    @Column(name = "PRODUTO_ID")
    private UUID produtoId;

    @Positive
    @Column(name = "QUANTIDADE")
    private int quantidade;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusReserva status;

    @NotNull
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @NotNull
    @Column(name = "DATA_EXPIRACAO")
    private LocalDateTime dataExpiracao;

    public enum StatusReserva {
        RESERVADO,
        NEGADO,
        EXPIRADO,
        CONSUMIDO,
        CANCELADO
    }
}
