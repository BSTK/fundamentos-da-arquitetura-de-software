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
@Table(name = "OCORRENCIA_ENTREGA")
public class OcorrenciaEntrega implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ENTREGA_ID")
    private UUID entregaId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusOcorrencia status;

    @NotEmpty
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull
    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    public enum StatusOcorrencia {
        EM_TRANSITO,
        ATRASO,
        TENTATIVA_FALHA,
        ENTREGUE,
        DEVOLVIDO
    }
}
