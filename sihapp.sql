-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2017 at 06:44 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sihapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `nodes`
--

CREATE TABLE IF NOT EXISTS `nodes` (
`id` int(11) NOT NULL,
  `level` int(255) NOT NULL,
  `level_index` int(255) NOT NULL,
  `quality` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `parent` int(11) NOT NULL,
  `is_home` tinyint(1) NOT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nodes`
--

INSERT INTO `nodes` (`id`, `level`, `level_index`, `quality`, `quantity`, `parent`, `is_home`, `userId`, `updated_at`) VALUES
(0, 0, 0, 0, 0, -1, 0, '0', '2017-03-28 15:51:01'),
(1, 1, 0, 0, 0, 0, 0, '0', '2017-03-28 15:49:25'),
(2, 1, 1, 0, 0, 0, 0, '0', '2017-03-28 15:49:32'),
(3, 2, 0, 0, 0, 1, 0, '0', '2017-03-28 15:49:34'),
(4, 2, 1, 0, 0, 1, 0, '0', '2017-03-28 15:49:38'),
(5, 2, 2, 0, 0, 2, 0, '0', '2017-03-28 15:49:40'),
(6, 2, 3, 0, 0, 2, 0, '0', '2017-03-28 15:49:43'),
(7, 2, 4, 0, 0, 2, 0, '0', '2017-03-28 15:49:46'),
(8, 3, 0, 0, 0, 3, 0, '0', '2017-03-28 15:49:48'),
(9, 3, 1, 0, 0, 4, 1, '0', '2017-03-28 15:49:51'),
(10, 3, 2, 0, 0, 4, 1, '0', '2017-03-28 15:49:53'),
(11, 3, 3, 0, 0, 4, 1, '0', '2017-03-28 15:49:55'),
(12, 3, 4, 0, 0, 5, 1, '0', '2017-03-28 15:49:57'),
(13, 3, 5, 0, 0, 5, 1, '0', '2017-03-28 15:49:59'),
(14, 3, 6, 0, 0, 6, 0, '0', '2017-03-28 15:50:02'),
(15, 3, 7, 0, 0, 7, 0, '0', '2017-03-28 15:50:05'),
(16, 3, 8, 0, 0, 7, 1, '0', '2017-03-28 15:50:07'),
(17, 4, 0, 0, 0, 8, 1, '0', '2017-03-28 15:50:09'),
(18, 4, 1, 0, 0, 8, 1, '0', '2017-03-28 15:50:11'),
(19, 4, 2, 0, 0, 14, 1, '0', '2017-03-28 15:50:13'),
(20, 4, 3, 0, 0, 14, 0, '0', '2017-03-28 15:50:15'),
(21, 4, 4, 0, 0, 14, 1, '0', '2017-03-28 15:50:19'),
(22, 4, 5, 0, 0, 14, 1, '0', '2017-03-28 15:50:20'),
(23, 4, 6, 10018, 7806, 15, 0, '0', '2017-03-28 16:30:47'),
(24, 4, 7, 0, 0, 15, 1, '0', '2017-03-28 15:50:25'),
(25, 4, 8, 0, 0, 1, 1, '0', '2017-03-28 15:50:26'),
(26, 5, 0, 0, 0, 20, 1, '0', '2017-03-28 15:50:28'),
(27, 5, 1, 3453, 4353, 23, 1, '0', '2017-03-28 15:50:30'),
(28, 5, 2, 6565, 3656, 23, 1, 'avzc6nnNj6NghdEZrL55hmPO6rC3', '2017-03-28 16:07:44');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`no.` int(11) NOT NULL,
  `level` int(255) NOT NULL,
  `level_index` int(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `position` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `no.` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
