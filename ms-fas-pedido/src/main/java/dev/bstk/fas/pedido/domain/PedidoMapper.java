package dev.bstk.fas.pedido.domain;

import dev.bstk.fas.pedido.api.request.PedidoItemRequest;
import dev.bstk.fas.pedido.api.request.PedidoRequest;
import dev.bstk.fas.pedido.api.response.PedidoResponse;
import dev.bstk.fas.pedido.domain.entity.Pedido;
import dev.bstk.fas.pedido.domain.entity.PedidoItem;
import dev.bstk.fas.pedido.domain.event.PedidoCriadoEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "status", ignore = true)
  @Mapping(target = "valorTotal", ignore = true)
  @Mapping(target = "dataCriacao", ignore = true)
  @Mapping(target = "dataAtualizacao", ignore = true)
  Pedido toEntity(PedidoRequest request);

  @Mapping(target = "id", ignore = true)
  PedidoItem toEntity(PedidoItemRequest itemRequest);

  PedidoResponse toResponse(Pedido pedido);

  List<PedidoResponse> toResponse(List<Pedido> pedidos);

  PedidoCriadoEvent toEvent(Pedido pedido);
}
