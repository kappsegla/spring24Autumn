-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

-- Truncate the tables
TRUNCATE TABLE person_language;
TRUNCATE TABLE social_media;
TRUNCATE TABLE language;
TRUNCATE TABLE person;

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Insert sample data into person table
INSERT INTO person (first_name, last_name, programmer)
VALUES ('Alice', 'Smith', true),
       ('Bob', 'Johnson', false),
       ('Charlie', 'Brown', true);

-- Insert sample data into language table
INSERT INTO language (name)
VALUES ('English'),
       ('German'),
       ('Java'),
       ('C#'),
       ('JavaScript');

-- Insert sample data into person_languages table
INSERT INTO person_language (person_id, language_id)
VALUES (1, 1), -- Alice speaks English
       (1, 3), -- Alice knows Java
       (2, 2), -- Bob speaks German
       (3, 4), -- Charlie knows C#
       (3, 5);
-- Charlie knows JavaScript

-- Insert sample data into social_media table
INSERT INTO social_media (person_id, platform, handle)
VALUES (1, 'TWITTER', '@alice_smith'),
       (2, 'LINKEDIN', 'bob.johnson'),
       (3, 'FACEBOOK', 'charlie.brown');

-- Insert sample data into api_key table
INSERT INTO api_key (api_key, name, valid_until)
VALUES ('wEWM967DqqC9cBMGpxvr99GM', 'Service A', '2024-12-31 23:59:59'),
       ('xYz12345AbCdEfGhIjKlMnOp', 'Service B', '2025-06-30 23:59:59'),
       ('aBcDeFgHiJkLmNoPqRsTuVwX', 'Service A', '2024-12-31 23:59:59'),
       ('LmNoPqRsTuVwXyZaBcDeFgHi', 'Service C', '2025-01-15 23:59:59'),
       ('QrStUvWxYzAbCdEfGhIjKlMn', 'Service B', '2025-06-30 23:59:59');
