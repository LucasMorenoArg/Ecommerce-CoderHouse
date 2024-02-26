-- Insertar datos en la tabla clientes
INSERT INTO clientes (nombre, apellido) VALUES
('Juan', 'Pérez'),
('María', 'González'),
('Pedro', 'Martínez');
-- Insertar datos en la tabla productos
INSERT INTO productos (descripcion, precio, stock) VALUES
('Camisa de algodón', 25.99, 100),
('Pantalón vaquero', 35.50, 80),
('Zapatos de cuero', 49.99, 50);
-- Insertar datos en la tabla comprobantes
INSERT INTO comprobantes (cliente_id, producto_id, cantidad, fecha_Comprobante, precio_Total) VALUES
(1, 1, 2,"2024-02-25", 51.98),
(2, 2, 1,"2024-02-25", 35.50),
(3, 3, 1,"2024-02-25", 49.99);