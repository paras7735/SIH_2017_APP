-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2017 at 08:47 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sihapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `nodes`
--

CREATE TABLE `nodes` (
  `id` int(11) NOT NULL,
  `level` int(255) NOT NULL,
  `level_index` int(255) NOT NULL,
  `quality` float NOT NULL,
  `quantity` int(11) NOT NULL,
  `parent` int(11) NOT NULL,
  `is_home` tinyint(1) NOT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nodes`
--

INSERT INTO `nodes` (`id`, `level`, `level_index`, `quality`, `quantity`, `parent`, `is_home`, `userId`, `updated_at`) VALUES
(0, 0, 0, 7.5, 3200, -1, 0, '0', '2017-04-01 06:33:34'),
(1, 1, 0, 7.5, 1200, 0, 0, '0', '2017-04-01 06:24:19'),
(2, 1, 1, 7.5, 2000, 0, 0, '0', '2017-04-01 06:24:19'),
(3, 2, 0, 7.5, 400, 1, 0, '0', '2017-04-01 06:24:19'),
(4, 2, 1, 5, 600, 1, 0, '0', '2017-04-01 06:36:21'),
(5, 2, 2, 7.5, 400, 2, 0, '0', '2017-04-01 06:24:19'),
(6, 2, 3, 7.5, 800, 2, 0, '0', '2017-04-01 06:24:19'),
(7, 2, 4, 7.5, 800, 2, 0, '0', '2017-04-01 06:34:47'),
(8, 3, 0, 7.5, 400, 3, 0, '0', '2017-04-01 06:24:19'),
(9, 3, 1, 7.5, 200, 4, 1, '0', '2017-04-01 06:24:19'),
(10, 3, 2, 7.5, 200, 4, 1, '0', '2017-04-01 06:24:19'),
(11, 3, 3, 7.5, 200, 4, 1, '0', '2017-04-01 06:24:19'),
(12, 3, 4, 7.5, 200, 5, 1, '0', '2017-04-01 06:24:19'),
(13, 3, 5, 7.5, 200, 5, 1, '0', '2017-04-01 06:24:19'),
(14, 3, 6, 7.5, 800, 6, 0, '0', '2017-04-01 06:24:19'),
(15, 3, 7, 7.5, 600, 7, 0, '0', '2017-04-01 06:24:19'),
(16, 3, 8, 7.5, 200, 7, 1, '0', '2017-04-01 06:24:19'),
(17, 4, 0, 7.5, 200, 8, 1, '0', '2017-04-01 06:24:19'),
(18, 4, 1, 7.5, 200, 8, 1, '0', '2017-04-01 06:24:19'),
(19, 4, 2, 7.5, 200, 14, 1, '0', '2017-04-01 06:24:19'),
(20, 4, 3, 7.5, 200, 14, 0, '0', '2017-04-01 06:24:19'),
(21, 4, 4, 7.5, 200, 14, 1, '0', '2017-04-01 06:24:19'),
(22, 4, 5, 7.5, 200, 14, 1, '0', '2017-04-01 06:24:19'),
(23, 4, 6, 7.5, 400, 15, 0, '0', '2017-04-01 06:24:19'),
(24, 4, 7, 7.5, 200, 15, 1, '0', '2017-04-01 06:24:19'),
(25, 4, 8, 7.5, 200, 1, 1, '0', '2017-04-01 06:24:19'),
(26,5,0,7.5,200,20,1, '0', '2017-03-28 15:50:28'),
(27,5,1,7.5,200,23,1, '0', '2017-03-28 15:50:30'),
(28,5,2,7.5,200,23,1, '0', '2017-03-28 16:07:44');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `no.` int(11) NOT NULL,
  `level` int(255) NOT NULL,
  `level_index` int(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `position` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`no.`, `level`, `level_index`, `Username`, `Password`, `position`) VALUES
(1, 0, 0, 'admin', 'pass', 2),
(3, 1, 0, 'paras', 'pass', 0),
(4, 0, 0, 'supplier', 'supp', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nodes`
--
ALTER TABLE `nodes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`no.`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nodes`
--
ALTER TABLE `nodes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `no.` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
