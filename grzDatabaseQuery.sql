-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 09 Jun 2014 pada 14.48
-- Versi Server: 5.5.27
-- Versi PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `grz`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TransactionID` int(11) DEFAULT NULL,
  `SubTotal` float NOT NULL,
  `Quantity` int(11) NOT NULL,
  `ProductID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `TransactionID` (`TransactionID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` longtext NOT NULL,
  `Price` float NOT NULL,
  `Image` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data untuk tabel `product`
--

INSERT INTO `product` (`ID`, `Name`, `Description`, `Price`, `Image`) VALUES
(1, 'Coca Cola 1L', 'Coca Cola drink fresh', 10000, 'Image/drink3.jpg'),
(2, 'Blackcurrant Drinks', 'Black drink soda', 8000, 'Image/pizza1.jpg'),
(3, 'Spicy Summer', 'Spicy summer pedas', 28000, 'Image/pizza2.jpg'),
(4, 'Beef Spagheti', 'Spagheti with beef', 34000, 'Image/pizza3.jpg'),
(5, 'Beef Lasagna', 'Lsagna with beef', 35000, 'Image/pizza4.jpg'),
(6, 'Chessy Galore', 'Galore with Cheese', 82000, 'Image/pizza5.jpg'),
(7, 'Tuna Melt', 'Tuna meltings', 90000, 'Image/pizza6.jpg'),
(8, 'Super Supreme', 'Gasdaa with Cheese', 80000, 'Image/pizza2.jpg'),
(9, 'Chicarbonara', 'asdasd with Cheese', 80000, 'Image/pizza1.jpg'),
(10, 'American Favorite', 'Galore with Cheese', 89000, 'Image/pizza5.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  `Total` float NOT NULL,
  `Date` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data untuk tabel `transaction`
--

INSERT INTO `transaction` (`ID`, `UserID`, `Status`, `Total`, `Date`) VALUES
(1, 1, 0, 0, ''),
(2, 2, 0, 0, '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Address` longtext NOT NULL,
  `Status` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`ID`, `Username`, `Password`, `Name`, `Email`, `Phone`, `Address`, `Status`) VALUES
(1, 'admin', 'admin', 'admin', 'admin@grazie.com', '1234567890', 'adminadminadminadminadmin', 'admin'),
(2, 'edista', 'password01', 'edisurata', 'e.surata@gmail.com', '081992180788', 'jln kemanggisan no 33A jakbar', 'member');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
