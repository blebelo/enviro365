CREATE TABLE IF NOT EXISTS WASTE_TABLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(20) NOT NULL,
    waste_category VARCHAR(20) NOT NULL,
    disposal_tips VARCHAR(500) NOT NULL,
    recycling_tips VARCHAR(500) NOT NULL
    );