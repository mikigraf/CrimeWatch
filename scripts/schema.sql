CREATE TABLE `crimes` (
  `type` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `details` text NOT NULL
);