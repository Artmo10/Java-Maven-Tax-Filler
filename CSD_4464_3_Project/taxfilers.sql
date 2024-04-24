-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2023 at 09:10 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `filersrecord`
--

-- --------------------------------------------------------

--
-- Table structure for table `taxfilers`
--

CREATE TABLE `taxfilers` (
  `filerID` int(5) NOT NULL,
  `name` varchar(75) NOT NULL,
  `contact` varchar(75) NOT NULL,
  `annualIncome` float NOT NULL,
  `expenses` float NOT NULL,
  `taxYear` int(5) NOT NULL,
  `dateFiled` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taxfilers`
--

INSERT INTO `taxfilers` (`filerID`, `name`, `contact`, `annualIncome`, `expenses`, `taxYear`, `dateFiled`) VALUES
(1004, 'Roger Gold', '214-749-7890', 56743, 15780, 2021, '2022-03-15'),
(1005, 'Edward Newgate', '432-097-6114', 98674, 45890, 2022, '2023-04-03'),
(1008, 'Jane Doer', '246-784-0949', 69549, 30010, 2022, '2023-03-05'),
(1010, 'John Baldwin', '237-098-3445', 89543, 21456, 2022, '2023-01-02'),
(1011, 'Harrison Newman', '437-260-9856', 92786, 42006, 2022, '2023-03-31');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `taxfilers`
--
ALTER TABLE `taxfilers`
  ADD PRIMARY KEY (`filerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
