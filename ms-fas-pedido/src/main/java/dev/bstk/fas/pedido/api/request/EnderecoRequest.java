package dev.bstk.fas.pedido.api.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    @NotEmpty
    private String logradouro;

    @NotEmpty
    private String numero;

    private String complemento;

    @NotEmpty
    private String bairro;

    @NotEmpty
    private String cidade;

    @NotEmpty
    private String estado;

    @NotEmpty
    private String cep;
}
