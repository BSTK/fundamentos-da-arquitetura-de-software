package dev.bstk.fas.expedicao.domain.entity;

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
@Table(name = "EXPEDICAO")
public class Expedicao implements Serializable {

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
    private StatusExpedicao status;

    @NotEmpty
    @Column(name = "CODIGO_RASTREIO")
    private String codigoRastreio;

    @NotEmpty
    @Column(name = "TRANSPORTADORA")
    private String transportadora;

    @NotNull
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_EXPEDICAO")
    private LocalDateTime dataExpedicao;

    public enum StatusExpedicao {
        PENDENTE,
        EM_PREPARACAO,
        EXPEDIDO,
        CANCELADO
    }
}
