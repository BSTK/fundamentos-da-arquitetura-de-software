package dev.bstk.fas.pedido.domain;

import dev.bstk.fas.pedido.domain.entity.Pedido;
import dev.bstk.fas.pedido.domain.entity.PedidoStatus;
import dev.bstk.fas.pedido.infra.messagebroker.MessageBrokerEvento;
import dev.bstk.fas.pedido.infra.messagebroker.MessageBrokerProduce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static java.math.BigDecimal.valueOf;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoService {

  private final PedidoMapper pedidoMapper;
  private final PedidoRepository pedidoRepository;
  private final MessageBrokerProduce messageBrokerProduce;

  public List<Pedido> listarPedidos() {
    return pedidoRepository.listarPedidos();
  }

  public Pedido criarNovoPedido(final Pedido pedido) {
    log.info("Inicio - [método]=criarNovoPedido, pedido={}", pedido);

    if (Objects.isNull(pedido.getClienteUuid())) {
      throw new PedidoException("Pedido deve estar associado a um cliente.");
    }

    if (CollectionUtils.isEmpty(pedido.getItens())) {
      throw new PedidoException("Pedido deve conter pelo menos um item.");
    }

    final BigDecimal valorTotalCalculado = calcularValorTotal(pedido);
    if (BigDecimal.ZERO.compareTo(valorTotalCalculado) > 0) {
      throw new PedidoException("Valor total do pedido inválido.");
    }

    pedido.setValorTotal(valorTotalCalculado);
    pedido.setStatus(PedidoStatus.PENDENTE_PAGAMENTO);

    final var pedidoSalvo = pedidoRepository.save(pedido);
    final var pedidoCriadoPayload = pedidoMapper.toEvent(pedidoSalvo);
    final var pedidoCriadoEvento = MessageBrokerEvento.builder().payload(pedidoCriadoPayload).build();

    messageBrokerProduce.publicarEvento(pedidoCriadoEvento);

    log.info("Fim - [método]=criarNovoPedido, pedidoSalvo={}", pedidoSalvo);

    return pedidoSalvo;
  }

  private BigDecimal calcularValorTotal(final Pedido pedido) {
    return pedido.getItens()
            .stream()
            .map(item -> item.getPrecoUnitario().multiply(valueOf(item.getQuantidade())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
