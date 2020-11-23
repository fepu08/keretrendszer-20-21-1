TRUNCATE TABLE dolgozok.dolgozo;
DROP TABLE dolgozok.dolgozo;
DROP TABLE dolgozok.nyelv_ismeret;

CREATE TABLE `dolgozok`.`dolgozo` (
  `id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE dolgozok.dolgozo MODIFY COLUMN id VARCHAR(255);
  
SELECT * FROM dolgozok.dolgozo;
SELECT * FROM dolgozok.nyelv_ismeret;

SELECT * FROM cars.cars;
