package dev.bstk.fas.notificacao.domain.entity;

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
@Table(name = "NOTIFICACAO")
public class Notificacao implements Serializable {

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
    @Column(name = "TIPO")
    private TipoNotificacao tipo;

    @NotEmpty
    @Column(name = "ASSUNTO")
    private String assunto;

    @NotEmpty
    @Column(name = "MENSAGEM")
    private String mensagem;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusNotificacao status;

    @NotNull
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ENVIO")
    private LocalDateTime dataEnvio;

    public enum TipoNotificacao {
        EMAIL,
        SMS,
        PUSH
    }

    public enum StatusNotificacao {
        PENDENTE,
        ENVIADA,
        FALHA
    }
}
