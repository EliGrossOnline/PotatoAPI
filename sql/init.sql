CREATE TABLE IF NOT EXISTS potato (
                                      id SERIAL PRIMARY KEY,
                                      variety VARCHAR(100) NOT NULL,
    color VARCHAR(50),
    origin_country VARCHAR(100),
    weight_grams INTEGER,
    organic BOOLEAN DEFAULT false,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
                             );

-- Create an index on variety for faster lookups
CREATE INDEX idx_potato_variety ON potato(variety);

-- Add a trigger to automatically update the updated_at timestamp
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_potato_updated_at
    BEFORE UPDATE ON potato
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();


insert into potato (variety, color, origin_country, weight_grams, organic)
values
('Yukon Gold', 'Yellow', 'Canada', 200, true),
('Russet Burbank', 'Brown', 'USA', 250, false),
('Red Bliss', 'Red', 'USA', 150, true),
('Fingerling', 'Yellow', 'Peru', 100, false),
('Purple Majesty', 'Purple', 'USA', 180, true),
('Kennebec', 'White', 'USA', 220, false),
('New Potatoes', 'White', 'USA', 120, true),
('Idaho Potato', 'Brown', 'USA', 300, false);
