-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2017 at 10:13 AM
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
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nodes`
--

INSERT INTO `nodes` (`id`, `level`, `level_index`, `quality`, `quantity`, `parent`, `is_home`, `updated_at`) VALUES
(0, 0, 0, 0, 0, 0, 0, '2017-03-20 18:04:44'),
(1, 1, 0, 0, 0, 0, 0, '0000-00-00 00:00:00'),
(2, 1, 1, 0, 0, 0, 0, '0000-00-00 00:00:00'),
(3, 2, 0, 0, 0, 1, 0, '2017-03-20 18:05:12'),
(4, 2, 1, 0, 0, 1, 0, '2017-03-20 18:05:16'),
(5, 2, 2, 0, 0, 2, 0, '2017-03-20 18:05:21'),
(6, 2, 3, 0, 0, 2, 0, '2017-03-20 18:05:31'),
(7, 2, 4, 0, 0, 2, 0, '2017-03-20 18:05:34'),
(8, 3, 0, 0, 0, 3, 0, '2017-03-20 18:05:53'),
(9, 3, 1, 0, 0, 4, 0, '2017-03-20 18:05:59'),
(10, 3, 2, 0, 0, 4, 0, '2017-03-20 18:06:02'),
(11, 3, 3, 0, 0, 4, 0, '2017-03-20 18:06:22'),
(12, 3, 4, 0, 0, 5, 0, '2017-03-20 18:06:26'),
(13, 3, 5, 0, 0, 5, 0, '2017-03-20 18:06:28'),
(14, 3, 6, 0, 0, 6, 0, '2017-03-20 18:06:31'),
(15, 3, 7, 0, 0, 7, 0, '2017-03-20 18:06:35'),
(16, 3, 8, 0, 0, 7, 0, '2017-03-20 18:06:38'),
(17, 4, 0, 0, 0, 8, 0, '2017-03-20 18:21:08'),
(18, 4, 1, 0, 0, 8, 0, '2017-03-20 18:21:11'),
(19, 4, 2, 0, 0, 14, 0, '2017-03-20 18:21:32'),
(20, 4, 3, 0, 0, 14, 0, '2017-03-20 18:21:37'),
(21, 4, 4, 0, 0, 14, 0, '2017-03-20 18:21:39'),
(22, 4, 5, 0, 0, 14, 0, '2017-03-20 18:21:42'),
(23, 4, 6, 0, 0, 15, 0, '2017-03-20 18:21:54'),
(24, 4, 7, 0, 0, 15, 0, '2017-03-20 18:21:56'),
(25, 4, 8, 0, 0, 1, 0, '2017-03-20 18:22:21'),
(26, 5, 0, 0, 0, 20, 0, '2017-03-20 18:22:57'),
(27, 5, 1, 3453, 4353, 23, 0, '2017-03-20 18:42:53'),
(28, 5, 2, 0, 0, 23, 0, '2017-03-20 18:22:59');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `no.` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
