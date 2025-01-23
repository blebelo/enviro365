INSERT INTO Waste_Categories (NAME, RECYCLABLE) VALUES
    ('Plastic Bottles', TRUE),
    ('Cardboard', TRUE),
    ('Glass', TRUE),
    ('Food Waste', FALSE),
    ('Non-Recyclable Plastic', FALSE),
    ('Electronics', FALSE);


INSERT INTO Disposal_Tips (CATEGORY, DESCRIPTION) VALUES
    ('Food Waste', 'Compost organic food waste to reduce landfill usage.'),
    ('Non-Recyclable Plastic', 'Dispose of in the general waste bin.'),
    ('Electronics', 'Take electronics to a certified e-waste recycling center.');


INSERT INTO Recycle_Tips (CATEGORY, DESCRIPTION) VALUES
    ('Plastic Bottles', 'Rinse bottles before placing them in the recycling bin.'),
    ('Cardboard', 'Flatten boxes to save space in the recycling bin.'),
    ('Glass', 'Separate by color and avoid mixing broken glass with recyclables.');