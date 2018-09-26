-- recreate DB
DROP DATABASE warsztat3krks04;
CREATE DATABASE warsztat3krks04;
USE warsztat3krks04;

-- tables
CREATE TABLE student (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE solution (
  id INT AUTO_INCREMENT PRIMARY KEY,
  submission_date DATETIME NOT NULL,
  answer TEXT,
  student_id INT,
  FOREIGN KEY(student_id) REFERENCES student(id)
      ON DELETE CASCADE
);