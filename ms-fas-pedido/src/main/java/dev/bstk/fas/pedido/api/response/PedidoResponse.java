package dev.bstk.fas.pedido.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.bstk.fas.pedido.domain.entity.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private UUID clienteUuid;
    private List<PedidoItemResponse> itens;
    private BigDecimal valorTotal;
    private EnderecoResponse enderecoEntrega;
    private PedidoStatus status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataAtualizacao;
}