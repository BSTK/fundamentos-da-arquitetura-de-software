package dev.bstk.fas.pedido.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private UUID livroUuid;
    private String titulo;
    private int quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
}
