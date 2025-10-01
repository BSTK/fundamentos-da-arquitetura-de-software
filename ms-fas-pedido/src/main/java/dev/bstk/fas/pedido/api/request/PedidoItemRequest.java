package dev.bstk.fas.pedido.api.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemRequest {

    @NotNull
    private UUID livroUuid;

    @NotEmpty
    private String titulo;

    @Positive
    private int quantidade;

    @NotNull
    @Positive
    private BigDecimal precoUnitario;

    @NotNull
    private BigDecimal subtotal;
}
