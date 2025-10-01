CREATE TABLE Produtos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) UNIQUE NOT NULL,
    preco NUMERIC(10, 2) NOT NULL CHECK (preco >= 0),
    quantidade_disponivel INT NOT NULL DEFAULT 0 CHECK (quantidade_disponivel >= 0),
    ativo BOOLEAN NOT NULL DEFAULT true,
    data_atualizacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TYPE reserva_status AS ENUM (
    'RESERVADO',
    'NEGADO',
    'EXPIRADO',
    'CONSUMIDO',
    'CANCELADO'
);

CREATE TABLE ReservasEstoque (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pedido_id UUID NOT NULL,
    produto_id UUID NOT NULL,
    quantidade INT NOT NULL CHECK (quantidade > 0),
    status reserva_status NOT NULL,
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    data_expiracao TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT fk_produto
        FOREIGN KEY(produto_id)
        REFERENCES Produtos(id)
        ON DELETE RESTRICT
);

CREATE INDEX idx_produtos_isbn ON Produtos(isbn);
CREATE INDEX idx_reservas_estoque_pedido_id ON ReservasEstoque(pedido_id);
CREATE INDEX idx_reservas_estoque_produto_id ON ReservasEstoque(produto_id);
CREATE INDEX idx_reservas_estoque_status ON ReservasEstoque(status);
