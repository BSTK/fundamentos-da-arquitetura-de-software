CREATE TYPE entrega_status AS ENUM (
    'PENDENTE',
    'EM_TRANSITO',
    'ENTREGUE',
    'FALHA',
    'DEVOLVIDO'
);

CREATE TYPE ocorrencia_entrega_status AS ENUM (
    'EM_TRANSITO',
    'ATRASO',
    'TENTATIVA_FALHA',
    'ENTREGUE',
    'DEVOLVIDO'
);

CREATE TABLE Entregas (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pedido_id UUID NOT NULL UNIQUE,
    cliente_id UUID NOT NULL,
    status entrega_status NOT NULL DEFAULT 'PENDENTE',
    codigo_rastreio VARCHAR(100),
    transportadora VARCHAR(100),
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    previsao_entrega TIMESTAMP WITH TIME ZONE,
    data_entrega TIMESTAMP WITH TIME ZONE
);

CREATE TABLE OcorrenciasEntrega (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    entrega_id UUID NOT NULL,
    status ocorrencia_entrega_status NOT NULL,
    descricao TEXT,
    data_hora TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_entrega
        FOREIGN KEY(entrega_id)
        REFERENCES Entregas(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_entregas_pedido_id ON Entregas(pedido_id);
CREATE INDEX idx_entregas_cliente_id ON Entregas(cliente_id);
CREATE INDEX idx_entregas_status ON Entregas(status);
CREATE INDEX idx_ocorrencias_entrega_entrega_id ON OcorrenciasEntrega(entrega_id);
