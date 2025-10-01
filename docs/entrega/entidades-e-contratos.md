### 🚚 Entidades (Entrega)

```json
{
  "Entrega": {
    "id": "UUID",
    "pedidoId": "UUID",
    "clienteId": "UUID",
    "status": "string (PENDENTE | EM_TRANSITO | ENTREGUE | FALHA | DEVOLVIDO)",
    "codigoRastreio": "string",
    "transportadora": "string",
    "dataCriacao": "datetime",
    "dataAtualizacao": "datetime",
    "previsaoEntrega": "datetime",
    "dataEntrega": "datetime"
  },
  "OcorrenciaEntrega": {
    "id": "UUID",
    "entregaId": "UUID",
    "status": "string (EM_TRANSITO | ATRASO | TENTATIVA_FALHA | ENTREGUE | DEVOLVIDO)",
    "descricao": "string",
    "dataHora": "datetime"
  }
}
```

---

### 📢 Contratos de Eventos (Entrega)

**EntregaIniciada**

```json
{
  "evento": "EntregaIniciada",
  "entregaId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "codigoRastreio": "string",
  "transportadora": "string",
  "previsaoEntrega": "datetime",
  "dataHora": "datetime"
}
```

**EntregaAtualizada**

```json
{
  "evento": "EntregaAtualizada",
  "entregaId": "UUID",
  "pedidoId": "UUID",
  "status": "string (EM_TRANSITO | ATRASO | TENTATIVA_FALHA)",
  "descricao": "string",
  "dataHora": "datetime"
}
```

**EntregaConcluida**

```json
{
  "evento": "EntregaConcluida",
  "entregaId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "codigoRastreio": "string",
  "dataHora": "datetime",
  "confirmacaoRecebimento": "boolean"
}
```

**EntregaFalhou**

```json
{
  "evento": "EntregaFalhou",
  "entregaId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "motivo": "string",
  "dataHora": "datetime"
}
```

**EntregaDevolvida**

```json
{
  "evento": "EntregaDevolvida",
  "entregaId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "motivo": "string",
  "dataHora": "datetime"
}
```