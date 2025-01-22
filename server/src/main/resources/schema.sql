CREATE DATABASE IF NOT EXISTS vote CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE vote;

CREATE TABLE users
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30)
);

CREATE TABLE options
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    label VARCHAR(30)
);

CREATE TABLE votes
(
    user_id INT,
    option_id INT,
    PRIMARY KEY (user_id, option_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (option_id) REFERENCES options(id) ON DELETE CASCADE
);
