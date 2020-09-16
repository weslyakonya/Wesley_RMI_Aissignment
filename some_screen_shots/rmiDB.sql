-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Sep 16, 2020 at 02:15 PM
-- Server version: 5.6.38
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `rmiDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `veges`
--

CREATE TABLE `veges` (
  `id` int(11) NOT NULL,
  `veg_name` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `veges`
--

INSERT INTO `veges` (`id`, `veg_name`, `price`) VALUES
(18, 'Mboga Kubwa', '89'),
(20, 'Bananas', '160'),
(22, 'maembe', '890');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `veges`
--
ALTER TABLE `veges`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `veges`
--
ALTER TABLE `veges`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
