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
    platform  ENUM ('TWITTER','FACEBOOK','LINKEDIN') NOT NULL,
    handle    VARCHAR(255)                           NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (id)
);
