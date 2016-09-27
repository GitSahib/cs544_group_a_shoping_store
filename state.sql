-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 27, 2016 at 09:08 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE if not exists `state`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`id`, `code`, `name`) VALUES
(1, 'AK', 'Alaska'),
(2, 'AL', 'Alabama'),
(3, 'AR', 'Arkansas'),
(4, 'AZ', 'Arizona'),
(5, 'CA', 'California'),
(6, 'CO', 'Colorado'),
(7, 'CT', 'Connecticut'),
(8, 'DC', 'District of Columbia'),
(9, 'DE', 'Delaware'),
(10, 'FL', 'Florida'),
(11, 'GA', 'Georgia'),
(12, 'HI', 'Hawaii'),
(13, 'IA', 'Iowa'),
(14, 'ID', 'Idaho'),
(15, 'IL', 'Illinois'),
(16, 'IN', 'Indiana'),
(17, 'KS', 'Kansas'),
(18, 'KY', 'Kentucky'),
(19, 'LA', 'Louisiana'),
(20, 'MA', 'Massachusetts'),
(21, 'MD', 'Maryland'),
(22, 'ME', 'Maine'),
(23, 'MI', 'Michigan'),
(24, 'MN', 'Minnesota'),
(25, 'MO', 'Missouri'),
(26, 'MS', 'Mississippi'),
(27, 'MT', 'Montana'),
(28, 'NC', 'North Carolina'),
(29, 'ND', 'North Dakota'),
(30, 'NE', 'Nebraska'),
(31, 'NH', 'New Hampshire'),
(32, 'NJ', 'New Jersey'),
(33, 'NM', 'New Mexico'),
(34, 'NV', 'Nevada'),
(35, 'NY', 'New York'),
(36, 'OH', 'Ohio'),
(37, 'OK', 'Oklahoma'),
(38, 'OR', 'Oregon'),
(39, 'PA', 'Pennsylvania'),
(40, 'RI', 'Rhode Island'),
(41, 'SC', 'South Carolina'),
(42, 'SD', 'South Dakota'),
(43, 'TN', 'Tennessee'),
(44, 'TX', 'Texas'),
(45, 'UT', 'Utah'),
(46, 'VA', 'Virginia'),
(47, 'VT', 'Vermont'),
(48, 'WA', 'Washington'),
(49, 'WI', 'Wisconsin'),
(50, 'WV', 'West Virginia'),
(51, 'WY', 'Wyoming');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`code`)

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `state`
--
ALTER TABLE `state`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
