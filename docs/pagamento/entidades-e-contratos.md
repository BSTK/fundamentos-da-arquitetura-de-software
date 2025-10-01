### 💳 Entidades (Pagamento)

```json
{
  "Pagamento": {
    "id": "UUID",
    "pedidoId": "UUID",
    "clienteId": "UUID",
    "valor": "decimal",
    "moeda": "string",
    "status": "string (PENDENTE | APROVADO | RECUSADO | EXPIRADO)",
    "meioPagamento": "string (CARTAO | PIX | BOLETO)",
    "dataCriacao": "datetime",
    "dataAtualizacao": "datetime",
    "transacaoId": "string"
  }
}
```

---

### 📢 Contratos de Eventos (Pagamento)

**PagamentoIniciado**

```json
{
  "evento": "PagamentoIniciado",
  "pagamentoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "valor": "decimal",
  "meioPagamento": "string",
  "dataHora": "datetime"
}
```

**PagamentoAprovado**

```json
{
  "evento": "PagamentoAprovado",
  "pagamentoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "valor": "decimal",
  "meioPagamento": "string",
  "transacaoId": "string",
  "dataHora": "datetime"
}
```

**PagamentoRecusado**

```json
{
  "evento": "PagamentoRecusado",
  "pagamentoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "valor": "decimal",
  "meioPagamento": "string",
  "motivo": "string",
  "dataHora": "datetime"
}
```

**PagamentoExpirado**

```json
{
  "evento": "PagamentoExpirado",
  "pagamentoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "valor": "decimal",
  "meioPagamento": "string",
  "dataHora": "datetime"
}
```

**PagamentoEstornado**

```json
{
  "evento": "PagamentoEstornado",
  "pagamentoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "valor": "decimal",
  "motivo": "string",
  "dataHora": "datetime"
}
```
