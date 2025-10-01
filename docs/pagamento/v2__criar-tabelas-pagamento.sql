CREATE TYPE pagamento_status AS ENUM (
    'PENDENTE',
    'APROVADO',
    'RECUSADO',
    'EXPIRADO'
);

CREATE TYPE meio_pagamento AS ENUM (
    'CARTAO',
    'PIX',
    'BOLETO'
);

CREATE TABLE Pagamentos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pedido_id UUID NOT NULL,
    cliente_id UUID NOT NULL,
    valor NUMERIC(10, 2) NOT NULL,
    moeda VARCHAR(3) NOT NULL DEFAULT 'BRL',
    status pagamento_status NOT NULL DEFAULT 'PENDENTE',
    meio_pagamento meio_pagamento NOT NULL,
    transacao_id VARCHAR(255),
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_pedido
        FOREIGN KEY(pedido_id) 
        REFERENCES Pedidos(id)
        ON DELETE RESTRICT
);

CREATE INDEX idx_pagamentos_pedido_id ON Pagamentos(pedido_id);
CREATE INDEX idx_pagamentos_cliente_id ON Pagamentos(cliente_id);
CREATE INDEX idx_pagamentos_status ON Pagamentos(status);
