CREATE TABLE users
(
    id            INT GENERATED ALWAYS AS IDENTITY,
    email         VARCHAR   NOT NULL UNIQUE,
    password      TEXT  NOT NULL,
    role          VARCHAR   NOT NULL,
    first_name    VARCHAR,
    last_name     VARCHAR,
    date_of_birth TIMESTAMP,
    created_date  TIMESTAMP NOT NULL
);

insert into users (email, password, role, created_date)
values ('admin@smartgarden.com', '$2a$12$RRrdwA4gYY/qQU/DEAnPZOcDiJhvliqUbwcOVjSgo7Kd/bEMWQBXW', 'ROLE_ADMIN', CURRENT_TIMESTAMP());
