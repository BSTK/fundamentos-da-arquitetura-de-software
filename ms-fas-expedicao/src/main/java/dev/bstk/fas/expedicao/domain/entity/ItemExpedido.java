package dev.bstk.fas.expedicao.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ITEM_EXPEDIDO")
public class ItemExpedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "EXPEDICAO_ID")
    private UUID expedicaoId;

    @NotNull
    @Column(name = "PRODUTO_ID")
    private UUID produtoId;

    @Positive
    @Column(name = "QUANTIDADE")
    private int quantidade;
}
