package dev.bstk.fas.pedido.domain.entity;

import dev.bstk.fas.pedido.domain.entity.converter.EnderecoJsonbConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "CLIENTE_UUID")
  private UUID clienteUuid;

  @JoinColumn(name = "PEDIDO_ID")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PedidoItem> itens = new ArrayList<>();

  @NotNull
  @Column(name = "VALOR_TOTAL")
  private BigDecimal valorTotal;

  @NotNull
  @Convert(converter = EnderecoJsonbConverter.class)
  @ColumnTransformer(write = "?::jsonb")
  @Column(name = "ENDERECO_ENTREGA")
  private Endereco enderecoEntrega;

  @NotNull
  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  private PedidoStatus status;

  @NotNull
  @Column(name = "DATA_CRIACAO")
  private LocalDateTime dataCriacao;

  @NotNull
  @Column(name = "DATA_ATUALIZACAO")
  private LocalDateTime dataAtualizacao;

  @PrePersist
  private void preInsert() {
    setDataCriacao(LocalDateTime.now());
    setDataAtualizacao(LocalDateTime.now());
  }

  @PreUpdate
  private void preUpdate() {
    setDataAtualizacao(LocalDateTime.now());
  }
}
