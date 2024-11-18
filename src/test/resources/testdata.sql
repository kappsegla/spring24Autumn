-- Table for storing persons
CREATE TABLE IF NOT EXISTS person
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    programmer BOOLEAN DEFAULT false
);

-- Table for storing languages
CREATE TABLE IF NOT EXISTS language
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Junction table for many-to-many relationship between person and languages
CREATE TABLE IF NOT EXISTS person_language
(
    person_id   INT,
    language_id INT,
    FOREIGN KEY (person_id) REFERENCES person (id),
    FOREIGN KEY (language_id) REFERENCES language (id),
    PRIMARY KEY (person_id, language_id)
);

-- Table for storing social media profiles (one-to-many relationship with person)
CREATE TABLE IF NOT EXISTS social_media
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    platform  VARCHAR(255) NOT NULL,
    handle    VARCHAR(255) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (id)
);

-- Table for storing api keys
CREATE TABLE IF NOT EXISTS api_key
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    api_key     VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    valid_until DATETIME     NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

-- Truncate the tables
TRUNCATE TABLE person_language;
TRUNCATE TABLE social_media;
TRUNCATE TABLE language;
TRUNCATE TABLE person;
TRUNCATE TABLE api_key;

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
