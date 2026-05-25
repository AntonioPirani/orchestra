-- ─────────────────────────────────────────
-- USERS
-- ─────────────────────────────────────────
INSERT INTO users (id, username, password, role) VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'admin', '$2a$12$7Ke5GTSX6jBgaOGQU6V4wOlMCcBiYFwFYJutGDj2X4UPd9SzJyUyO', 'ROLE_ADMIN'),
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'user',  '$2a$12$7Ke5GTSX6jBgaOGQU6V4wOlMCcBiYFwFYJutGDj2X4UPd9SzJyUyO', 'ROLE_USER');

-- ─────────────────────────────────────────
-- CRM
-- ─────────────────────────────────────────
INSERT INTO customers (id, external_id, first_name, last_name, email, phone, country) VALUES
    ('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'CRM-001', 'Maria',  'Rossi',  'maria.rossi@example.it', '+39 02 1234567', 'Italy'),
    ('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'CRM-002', 'Thomas', 'Müller', 'tmuller@beispiel.de',    '+49 89 9876543', 'Germany'),
    ('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'CRM-003', 'Sophie', 'Dubois', null,                     '+33 1 23456789', 'France'),
    ('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'CRM-004', 'James',  'Smith',  'j.smith@corp.co.uk',     null,             'UK'),
    ('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'CRM-005', 'Yuki',   'Tanaka', 'yuki.t@example.jp',      '+81 3 12345678', 'Japan');

INSERT INTO contacts (id, customer_id, type, full_name, email, phone) VALUES
    ('c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'PRIMARY', 'Maria Rossi',   'maria.rossi@example.it', '+39 02 1234567'),
    ('c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'BILLING', 'Thomas Müller', 'billing@beispiel.de',    '+49 89 9876543'),
    ('c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'SUPPORT', 'Anna Müller',   'support@beispiel.de',    '+49 89 1112222'),
    ('c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'PRIMARY', 'James Smith',   'j.smith@corp.co.uk',     null);

-- ─────────────────────────────────────────
-- WAREHOUSE
-- ─────────────────────────────────────────
INSERT INTO warehouses (id, code, name, location) VALUES
    ('d3eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'WH-EU-01', 'European Central Warehouse', 'Frankfurt, Germany'),
    ('d3eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'WH-EU-02', 'Southern Europe Warehouse',  'Milan, Italy');

INSERT INTO inventory_items (id, sku, name, description, quantity_available, quantity_reserved, warehouse_id) VALUES
    ('e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'SKU-1001', 'Industrial Sensor X200', 'High-precision pressure sensor',  120, 15, 'd3eebc99-9c0b-4ef8-bb6d-6bb9bd380a11'),
    ('e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'SKU-1002', 'Control Unit CU-50',     'PLC control unit 50A',             45,  5, 'd3eebc99-9c0b-4ef8-bb6d-6bb9bd380a11'),
    ('e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'SKU-1003', 'Connector Bundle CB-10', 'Set of 10 industrial connectors', 200,  0, 'd3eebc99-9c0b-4ef8-bb6d-6bb9bd380a12'),
    ('e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'SKU-1004', 'Power Supply PS-24V',    '24V industrial power supply',       8,  8, 'd3eebc99-9c0b-4ef8-bb6d-6bb9bd380a12'),
    ('e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'SKU-9999', 'Legacy Part LGX-77',     'Discontinued component',            0,  0, 'd3eebc99-9c0b-4ef8-bb6d-6bb9bd380a11');

-- ─────────────────────────────────────────
-- ERP
-- ─────────────────────────────────────────
INSERT INTO orders (id, order_number, customer_external_id, status, total_amount, currency, notes) VALUES
    ('f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'ORD-2024-001', 'CRM-001', 'DELIVERED',  4500.00, 'EUR', null),
    ('f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'ORD-2024-002', 'CRM-002', 'PENDING',    1200.50, 'EUR', 'Urgent delivery requested'),
    ('f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'ORD-2024-003', 'CRM-002', 'PROCESSING',  890.00, 'EUR', null),
    ('f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'ORD-2024-004', 'CRM-999', 'PENDING',     300.00, 'EUR', 'VIP client'),
    ('f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'ORD-2024-005', 'CRM-004', 'CANCELLED',    75.00, 'GBP', null);

INSERT INTO order_items (id, order_id, sku, description, quantity, unit_price) VALUES
    ('a5eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'SKU-1001', 'Industrial Sensor X200', 30, 150.00),
    ('a5eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'SKU-1002', 'Control Unit CU-50',      3, 300.00),
    ('a5eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'SKU-1002', 'Control Unit CU-50',      2, 300.00),
    ('a5eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'SKU-1004', 'Power Supply PS-24V',     1, 600.50),
    ('a5eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'SKU-9998', 'Unknown Part',            5, 178.00),
    ('a5eebc99-9c0b-4ef8-bb6d-6bb9bd380a16', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'SKU-1003', 'Connector Bundle CB-10', 10,  30.00),
    ('a5eebc99-9c0b-4ef8-bb6d-6bb9bd380a17', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'SKU-1001', 'Industrial Sensor X200',  1,  75.00);