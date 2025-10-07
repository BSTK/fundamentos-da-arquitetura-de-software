package dev.bstk.fas.pedido.domain.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.bstk.fas.pedido.domain.entity.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoCriadoEvent {

  private Long id;
  private UUID clienteUuid;
  private BigDecimal valorTotal;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private LocalDateTime dataCriacao;
  private PedidoStatus status;
  private EnderecoPedidoCriadoEvent enderecoEntrega;
  private List<ItemPedidoCriadoEvent> itens;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ItemPedidoCriadoEvent {

    private UUID livroUuid;
    private int quantidade;
    private String titulo;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class EnderecoPedidoCriadoEvent {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
  }
}
