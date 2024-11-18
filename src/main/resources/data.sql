-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

-- Truncate the tables
TRUNCATE TABLE person_language;
TRUNCATE TABLE social_media;
TRUNCATE TABLE language;
TRUNCATE TABLE person;
TRUNCATE TABLE api_key;
TRUNCATE TABLE playground;

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

INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(52.5200 13.4050)', 4326)); -- Berlin, Germany
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(48.8566 2.3522)', 4326)); -- Paris, France
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(51.5074 -0.1276)', 4326)); -- London, UK
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(41.9028 12.4964)', 4326)); -- Rome, Italy
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(35.6895 139.6917)', 4326)); -- Tokyo, Japan
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(40.7128 -74.0060)', 4326)); -- New York, USA
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(-33.8688 151.2093)', 4326)); -- Sydney, Australia
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(59.3293 18.0686)', 4326)); -- Stockholm, Sweden
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(47.4979 19.0402)', 4326)); -- Budapest, Hungary
INSERT INTO playground (coordinate) VALUES (ST_GeomFromText('POINT(55.7558 37.6173)', 4326)); -- Moscow, Russia
