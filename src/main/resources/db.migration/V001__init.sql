CREATE TABLE users
(
    id            INT GENERATED ALWAYS AS IDENTITY,
    email         VARCHAR NOT NULL UNIQUE,
    password      TEXT NOT NULL,
    role          VARCHAR NOT NULL,
    first_name    VARCHAR,
    last_name     VARCHAR,
    date_of_birth TIMESTAMP,
    created_date  TIMESTAMP NOT NULL
);

INSERT INTO users (email, password, username, role, created_date, first_name, last_name, date_of_birth)
VALUES ('admin@smartgarden.com', '$2a$12$RRrdwA4gYY/qQU/DEAnPZOcDiJhvliqUbwcOVjSgo7Kd/bEMWQBXW', 'admin', 'ROLE_ADMIN', CURRENT_TIMESTAMP(), 'admin',
        'smartgarden', CURRENT_TIMESTAMP());
