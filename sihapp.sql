-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2017 at 02:20 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

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
  `quality` int(11) NOT NULL,
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
(1, 0, 0, 0, 0, -1, 0, '0', '2017-03-29 12:16:50'),
(2, 1, 0, 500, 500, 0, 0, '0', '2017-03-29 12:20:15'),
(3, 1, 1, 500, 500, 0, 0, '0', '0000-00-00 00:00:00'),
(4, 2, 0, 250, 250, 1, 0, '0', '0000-00-00 00:00:00'),
(5, 2, 1, 250, 250, 1, 0, '0', '0000-00-00 00:00:00'),
(6, 2, 2, 168, 168, 2, 0, '0', '0000-00-00 00:00:00'),
(7, 2, 3, 166, 166, 2, 0, '0', '0000-00-00 00:00:00'),
(8, 2, 4, 166, 166, 2, 0, '0', '0000-00-00 00:00:00'),
(9, 3, 0, 250, 250, 3, 0, '0', '0000-00-00 00:00:00'),
(10, 3, 1, 84, 84, 4, 1, '0', '0000-00-00 00:00:00'),
(11, 3, 2, 83, 83, 4, 1, '0', '0000-00-00 00:00:00'),
(12, 3, 3, 83, 83, 4, 1, '0', '0000-00-00 00:00:00'),
(13, 3, 4, 84, 84, 5, 1, '0', '0000-00-00 00:00:00'),
(14, 3, 5, 84, 84, 5, 1, '0', '0000-00-00 00:00:00'),
(15, 3, 6, 166, 166, 6, 0, '0', '0000-00-00 00:00:00'),
(16, 3, 7, 83, 83, 7, 0, '0', '0000-00-00 00:00:00'),
(17, 3, 8, 83, 83, 7, 1, '0', '0000-00-00 00:00:00'),
(18, 4, 0, 125, 125, 8, 1, '0', '0000-00-00 00:00:00'),
(19, 4, 1, 125, 125, 8, 1, '0', '0000-00-00 00:00:00'),
(20, 4, 2, 42, 42, 14, 1, '0', '0000-00-00 00:00:00'),
(21, 4, 3, 41, 41, 14, 0, '0', '0000-00-00 00:00:00'),
(22, 4, 4, 42, 42, 14, 1, '0', '0000-00-00 00:00:00'),
(23, 4, 5, 41, 41, 14, 1, '0', '0000-00-00 00:00:00'),
(24, 4, 6, 41, 41, 15, 0, '0', '0000-00-00 00:00:00'),
(25, 4, 7, 42, 42, 15, 1, '0', '0000-00-00 00:00:00'),
(26, 4, 8, 83, 83, 16, 1, '0', '0000-00-00 00:00:00'),
(27, 5, 0, 41, 41, 20, 1, '0', '0000-00-00 00:00:00'),
(28, 5, 1, 20, 20, 23, 1, '0', '0000-00-00 00:00:00'),
(29, 5, 2, 21, 21, 23, 1, 'avzc6nnNj6NghdEZrL55hmPO6rC3', '0000-00-00 00:00:00');

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
