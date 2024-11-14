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

-- Index for faster lookups by api_key
#CREATE INDEX idx_api_key ON api_key(api_key);

-- Index for faster lookups by name
#CREATE INDEX idx_name ON api_key(name);
