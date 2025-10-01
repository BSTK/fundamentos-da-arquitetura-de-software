package dev.bstk.fas.pedido.domain;

import dev.bstk.fas.pedido.api.request.PedidoRequest;
import dev.bstk.fas.pedido.api.response.PedidoResponse;
import dev.bstk.fas.pedido.domain.entity.Pedido;
import dev.bstk.fas.pedido.domain.event.PedidoCriadoEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

  Pedido toEntity(PedidoRequest request);

  PedidoResponse toResponse(Pedido pedido);

  PedidoCriadoEvent toEvent(Pedido pedido);
}
