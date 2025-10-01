package dev.bstk.fas.pedido.domain.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Column(name = "LOGRADOURO")
    private String logradouro;

    @NotEmpty
    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @NotEmpty
    @Column(name = "BAIRRO")
    private String bairro;

    @NotEmpty
    @Column(name = "CIDADE")
    private String cidade;

    @NotEmpty
    @Column(name = "ESTADO")
    private String estado;

    @NotEmpty
    @Column(name = "CEP")
    private String cep;
}
