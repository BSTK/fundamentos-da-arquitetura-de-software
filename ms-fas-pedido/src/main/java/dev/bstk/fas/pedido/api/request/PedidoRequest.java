package dev.bstk.fas.pedido.api.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {

    @NotNull
    private UUID clienteUuid;

    @NotEmpty
    private List<PedidoItemRequest> itens;

    @NotNull
    private EnderecoRequest enderecoEntrega;
}