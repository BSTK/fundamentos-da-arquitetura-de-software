package dev.bstk.fas.pedido.domain.entity.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.bstk.fas.pedido.common.ObjectMapperFactory;
import dev.bstk.fas.pedido.domain.entity.Endereco;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class EnderecoJsonbConverter implements AttributeConverter<Endereco, String> {

  private final ObjectMapper objectMapper = ObjectMapperFactory.OBJECT_MAPPER;

  @Override
  public String convertToDatabaseColumn(final Endereco endereco) {
    try {
      return objectMapper.writeValueAsString(endereco);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error ao converter Endereco para JSON", e);
    }
  }

  @Override
  public Endereco convertToEntityAttribute(final String jsonb) {
    try {
      return objectMapper.readValue(jsonb, Endereco.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error converter JSON para Endereco", e);
    }
  }
}
