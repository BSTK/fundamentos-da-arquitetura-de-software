CREATE TYPE expedicao_status AS ENUM (
    'PENDENTE',
    'EM_PREPARACAO',
    'EXPEDIDO',
    'CANCELADO'
);

CREATE TABLE Expedicoes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pedido_id UUID NOT NULL UNIQUE,
    cliente_id UUID NOT NULL,
    status expedicao_status NOT NULL DEFAULT 'PENDENTE',
    codigo_rastreio VARCHAR(100),
    transportadora VARCHAR(100),
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    data_expedicao TIMESTAMP WITH TIME ZONE
);

CREATE TABLE ItensExpedidos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    expedicao_id UUID NOT NULL,
    produto_id UUID NOT NULL,
    quantidade INT NOT NULL CHECK (quantidade > 0),
    CONSTRAINT fk_expedicao
        FOREIGN KEY(expedicao_id)
        REFERENCES Expedicoes(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_expedicoes_pedido_id ON Expedicoes(pedido_id);
CREATE INDEX idx_expedicoes_cliente_id ON Expedicoes(cliente_id);
CREATE INDEX idx_expedicoes_status ON Expedicoes(status);
CREATE INDEX idx_itens_expedidos_expedicao_id ON ItensExpedidos(expedicao_id);
CREATE INDEX idx_itens_expedidos_produto_id ON ItensExpedidos(produto_id);
