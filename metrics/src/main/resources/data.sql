DROP TABLE IF EXISTS metrics;

CREATE TABLE metrics (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  value DOUBLE NOT NULL
);