### 📦 Entidades (Pedido)

```json
{
  "Pedido": {
    "id": "UUID",
    "clienteId": "UUID",
    "itens": [
      {
        "livroId": "UUID",
        "titulo": "string",
        "quantidade": "int",
        "precoUnitario": "decimal",
        "subtotal": "decimal"
      }
    ],
    "valorTotal": "decimal",
    "enderecoEntrega": {
      "logradouro": "string",
      "numero": "string",
      "complemento": "string",
      "bairro": "string",
      "cidade": "string",
      "estado": "string",
      "cep": "string"
    },
    "status": "string (PENDENTE_PAGAMENTO | PAGO | CANCELADO | EXPEDIDO | ENTREGUE)",
    "dataCriacao": "datetime",
    "dataAtualizacao": "datetime"
  }
}
```

---

### 📢 Contratos de Eventos (Pedido)

**PedidoCriado**

```json
{
  "evento": "PedidoCriado",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "valorTotal": "decimal",
  "status": "PENDENTE_PAGAMENTO",
  "dataHora": "datetime",
  "itens": [
    {
      "livroId": "UUID",
      "quantidade": "int"
    }
  ]
}
```

**PedidoCancelado**

```json
{
  "evento": "PedidoCancelado",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "motivo": "string",
  "dataHora": "datetime"
}
```

**PedidoPago**

```json
{
  "evento": "PedidoPago",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "valorPago": "decimal",
  "dataHora": "datetime",
  "meioPagamento": "string"
}
```

**PedidoExpedido**

```json
{
  "evento": "PedidoExpedido",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "codigoRastreio": "string",
  "dataHora": "datetime"
}
```

**PedidoEntregue**

```json
{
  "evento": "PedidoEntregue",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "dataHora": "datetime",
  "confirmacaoRecebimento": "boolean"
}
```
