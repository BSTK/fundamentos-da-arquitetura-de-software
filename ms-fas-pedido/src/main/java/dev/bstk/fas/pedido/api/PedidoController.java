package dev.bstk.fas.pedido.api;

import dev.bstk.fas.pedido.api.request.PedidoRequest;
import dev.bstk.fas.pedido.api.response.PedidoResponse;
import dev.bstk.fas.pedido.domain.PedidoMapper;
import dev.bstk.fas.pedido.domain.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pedidos")
public class PedidoController {

  private final PedidoMapper pedidoMapper;
  private final PedidoService pedidoService;

  @PostMapping
  public ResponseEntity<PedidoResponse> criarNovoPedido(@Valid @RequestBody final PedidoRequest request) {
    log.info("Inicio - [método]=criarNovoPedido, request={}", request);

    final var pedido = pedidoMapper.toEntity(request);
    final var pedidoSalvo = pedidoService.criarNovoPedido(pedido);
    final var pedidoResponse = pedidoMapper.toResponse(pedidoSalvo);

    log.info("Fim - [método]=criarNovoPedido, status=finalizando, pedidoResponse={}", pedidoResponse);
    return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponse);
  }

  @GetMapping
  public ResponseEntity<List<PedidoResponse>> listarPedidos() {
    log.info("Inicio - [método]=listarPedidos");

    final var pedidos = pedidoService.listarPedidos();
    final var pedidosResponse = pedidoMapper.toResponse(pedidos);

    log.info("Fim - [método]=listarPedidos, totalPedidos={}", pedidosResponse.size());
    return ResponseEntity.ok(pedidosResponse);
  }
}
