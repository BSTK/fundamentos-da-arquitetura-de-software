package dev.bstk.fas.pagamento.infra.messagebroker;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MessageBrokerEvento {

  @Builder.Default
  private final UUID eventId = UUID.randomUUID();

  @Builder.Default
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private final LocalDateTime timestamp = LocalDateTime.now();

  @NotNull
  @NotEmpty
  private final Object payload;
}
