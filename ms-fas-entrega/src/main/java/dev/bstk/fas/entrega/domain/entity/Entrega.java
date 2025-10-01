package dev.bstk.fas.entrega.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ENTREGA")
public class Entrega implements Serializable {

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
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusEntrega status;

    @NotEmpty
    @Column(name = "CODIGO_RASTREIO")
    private String codigoRastreio;

    @NotEmpty
    @Column(name = "TRANSPORTADORA")
    private String transportadora;

    @NotNull
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @NotNull
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;

    @Column(name = "PREVISAO_ENTREGA")
    private LocalDateTime previsaoEntrega;

    @Column(name = "DATA_ENTREGA")
    private LocalDateTime dataEntrega;

    public enum StatusEntrega {
        PENDENTE,
        EM_TRANSITO,
        ENTREGUE,
        FALHA,
        DEVOLVIDO
    }
}
