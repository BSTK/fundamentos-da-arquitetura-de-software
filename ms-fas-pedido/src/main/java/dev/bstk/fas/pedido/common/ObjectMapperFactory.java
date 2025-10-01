package dev.bstk.fas.pedido.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class ObjectMapperFactory {

  public static ObjectMapper OBJECT_MAPPER = new ObjectMapper()
      .registerModule(new Jdk8Module())
      .registerModule(new JavaTimeModule());

  private ObjectMapperFactory() {}

}
