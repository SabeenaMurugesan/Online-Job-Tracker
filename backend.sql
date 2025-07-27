CREATE DATABASE job_tracker;
USE job_tracker;

CREATE TABLE jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(100),
    role VARCHAR(100),
    status VARCHAR(50),
    applied_on DATE
);
