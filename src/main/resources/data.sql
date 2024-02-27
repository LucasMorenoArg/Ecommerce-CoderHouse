-- Insertar datos en la tabla clientes
Sql SCHEMA ecommerce;
INSERT INTO clientes (nombre, apellido) VALUES
('Juan', 'Pérez'),
('María', 'González'),
('Pedro', 'Martínez');
-- Insertar datos en la tabla productos
INSERT INTO productos (descripcion, precio, stock) VALUES
('Teclado Gamer', 2500.99, 100),
('Mousse Optico', 3500.50, 80),
('Mousse inhalambrico', 4900.99, 50);
-- Insertar datos en la tabla comprobantes
INSERT INTO comprobantes (cliente_id, producto_id, cantidad, fecha_Comprobante, precio_Total) VALUES
(1, 1, 2,'2024-02-25', 5100.98),
(2, 2, 1,'2024-02-25', 3500.50),
(3, 3, 1,'2024-02-25', 4900.99);