### 📦 Entidades (Expedição)

```json
{
  "Expedicao": {
    "id": "UUID",
    "pedidoId": "UUID",
    "clienteId": "UUID",
    "status": "string (PENDENTE | EM_PREPARACAO | EXPEDIDO | CANCELADO)",
    "codigoRastreio": "string",
    "transportadora": "string",
    "dataCriacao": "datetime",
    "dataExpedicao": "datetime"
  },
  "ItemExpedido": {
    "id": "UUID",
    "expedicaoId": "UUID",
    "produtoId": "UUID",
    "quantidade": "int"
  }
}
```

---

### 📢 Contratos de Eventos (Expedição)

**ExpedicaoIniciada**

```json
{
  "evento": "ExpedicaoIniciada",
  "expedicaoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "dataHora": "datetime"
}
```

**PedidoExpedido**

```json
{
  "evento": "PedidoExpedido",
  "expedicaoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "codigoRastreio": "string",
  "transportadora": "string",
  "dataHora": "datetime"
}
```

**ExpedicaoCancelada**

```json
{
  "evento": "ExpedicaoCancelada",
  "expedicaoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "motivo": "string",
  "dataHora": "datetime"
}
```

**ExpedicaoFalhou**

```json
{
  "evento": "ExpedicaoFalhou",
  "expedicaoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "motivo": "string",
  "dataHora": "datetime"
}
```

**EtiquetaGerada**

```json
{
  "evento": "EtiquetaGerada",
  "expedicaoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "codigoRastreio": "string",
  "transportadora": "string",
  "dataHora": "datetime"
}
```
