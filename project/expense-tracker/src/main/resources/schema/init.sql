
-- ============================================
--              SCHEMA DEFINITIONS
-- ============================================

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'USER') NOT NULL DEFAULT 'USER',
    budget_limit DECIMAL(10,2)
);

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE expenses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    amount DECIMAL(10,2) NOT NULL,
    description TEXT,
    date DATE NOT NULL,
    user_id INT NOT NULL,
    category_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- ============================================
--              INITIAL DATA
-- ============================================

-- -------------------- Users --------------------
INSERT INTO users (username, password, role, budget_limit) VALUES
('admin', 'admin123', 'ADMIN', NULL),
('dylan', 'dylan123', 'USER', 4000.00),
('naume', 'naume123', 'USER', 3500.00),
('raldin', 'raldin123', 'USER', 4500.00);

-- -------------------- Categories --------------------
-- Dylan's categories
INSERT INTO categories (name, description, user_id) VALUES
('Food', 'Meals and drinks', 2),
('Transport', 'Bus, train, Uber', 2);

-- Naume's categories
INSERT INTO categories (name, description, user_id) VALUES
('Shopping', 'Clothes and accessories', 3),
('Bills', 'Electricity and water bills', 3);

-- Raldin's categories
INSERT INTO categories (name, description, user_id) VALUES
('Entertainment', 'Movies, Netflix, games', 4),
('Health', 'Pharmacy, checkups', 4);

-- -------------------- Expenses --------------------
-- Dylan's expenses
INSERT INTO expenses (amount, description, date, user_id, category_id) VALUES
(12.50, 'Burger and soda', '2025-04-01', 2, 1),
(35.00, 'Uber ride to work', '2025-04-03', 2, 2);

-- Naume's expenses
INSERT INTO expenses (amount, description, date, user_id, category_id) VALUES
(120.00, 'Bought a new jacket', '2025-04-02', 3, 3),
(65.00, 'Water bill', '2025-04-04', 3, 4);

-- Raldin's expenses
INSERT INTO expenses (amount, description, date, user_id, category_id) VALUES
(15.00, 'Movie night', '2025-04-01', 4, 5),
(90.00, 'Prescription medicine', '2025-04-05', 4, 6);
