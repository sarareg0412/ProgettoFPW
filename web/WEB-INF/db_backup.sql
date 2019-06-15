-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 15, 2019 at 03:59 PM
-- Server version: 5.7.24-log
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fpw19_dbregalisara`
--

-- --------------------------------------------------------

--
-- Table structure for table `articolo`
--

CREATE TABLE `articolo` (
  `pid` bigint(20) UNSIGNED NOT NULL,
  `titolo` varchar(100) DEFAULT NULL,
  `categorie` varchar(250) DEFAULT NULL,
  `immagine` varchar(500) DEFAULT NULL,
  `data_creazione` date DEFAULT NULL,
  `testo` varchar(1000) DEFAULT NULL,
  `stato` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articolo`
--

INSERT INTO `articolo` (`pid`, `titolo`, `categorie`, `immagine`, `data_creazione`, `testo`, `stato`) VALUES
(1, 'SQL injection', 'CSS HTML', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-04-10', 'inserire testo qui', 'APERTO'),
(2, 'Le Sevlet', 'CSS Servlet', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-01-08', 'inserire testo qui', 'APERTO'),
(3, 'Il DataBase', 'JSP', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-03-18', 'inserire testo qui', 'APERTO'),
(4, 'Le Classi Java', 'JSP HTML', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-05-24', 'inserire testo qui', 'RIFIUTATO'),
(5, 'Il tag brt', 'JSP HTML', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-05-01', 'inserire testo qui', 'IN VALUTAZIONE'),
(6, 'Il SevletContainer', 'Servlet', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-05-02', 'inserire testo qui', 'RIFIUTATO'),
(7, 'HTML 6', 'HTML', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-02-18', 'inserire testo qui', 'IN VALUTAZIONE'),
(15, 'Il CSS', 'CSS', 'https://inserirefotoqui.jpg', '2019-06-15', 'Inserire testo qui', 'APERTO'),
(16, 'Il DOM', 'CSS JavaScript', 'https://inserirefotoqui.jpg', '2019-06-15', 'Inserire testo qui', 'APERTO');

-- --------------------------------------------------------

--
-- Table structure for table `utente`
--

CREATE TABLE `utente` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cognome` varchar(100) DEFAULT NULL,
  `foto` varchar(500) DEFAULT NULL,
  `ente` varchar(150) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `pw` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utente`
--

INSERT INTO `utente` (`id`, `nome`, `cognome`, `foto`, `ente`, `email`, `pw`, `status`) VALUES
(1, 'Gianni', 'Bianchi', 'https://www.itsmarcopolo.it/wp-content/uploads/2017/08/sagoma-profilo.jpeg', 'https://www.unica.it/unica/', 'gianni.bianchi@gmail.com', 'gianni', 'Organizzatore'),
(2, 'Sara', 'Regali', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'https://www.unica.it/unica/', 'sara98.regali@gmail.com', 'sara', 'Autore'),
(3, 'Mario', 'Rossi', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'https://www.unica.it/unica/', 'mario.rossi@gmail.com', 'mario', 'Autore'),
(4, 'Anna', 'Maria', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'https://www.unica.it/unica/', 'anna.maria@gmail.com', 'anna', 'Autore'),
(5, 'Rosanna', 'Lennon', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'https://www.unica.it/unica/', 'rosanna.lennon@gmail.com', 'rosanna', 'Autore');

-- --------------------------------------------------------

--
-- Table structure for table `utente_articolo`
--

CREATE TABLE `utente_articolo` (
  `utente_id` bigint(20) UNSIGNED NOT NULL,
  `articolo_id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utente_articolo`
--

INSERT INTO `utente_articolo` (`utente_id`, `articolo_id`) VALUES
(2, 1),
(2, 2),
(3, 2),
(2, 3),
(2, 4),
(3, 4),
(3, 5),
(2, 6),
(3, 7),
(5, 15),
(4, 16),
(5, 16);

-- --------------------------------------------------------

--
-- Table structure for table `valutazione_`
--

CREATE TABLE `valutazione_` (
  `id_valutazione` bigint(20) UNSIGNED NOT NULL,
  `comm_autori` varchar(250) DEFAULT NULL,
  `comm_org` varchar(250) DEFAULT NULL,
  `voto` int(11) DEFAULT NULL,
  `decisione` varchar(30) DEFAULT NULL,
  `id_utente` bigint(20) UNSIGNED DEFAULT NULL,
  `id_articolo` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `valutazione_`
--

INSERT INTO `valutazione_` (`id_valutazione`, `comm_autori`, `comm_org`, `voto`, `decisione`, `id_utente`, `id_articolo`) VALUES
(1, 'fatto bene', 'fatto male', 4, 'Decidi', 2, 1),
(2, 'fatto bene', 'fatto male', 4, 'Decidi', 3, 1),
(3, 'fatto male', 'fatto malissimo', 2, 'Decidi', 2, 2),
(4, 'fatto bene', 'fatto benino', 3, 'Accettato', 2, 5),
(5, 'fatto male', 'fatto malissimo', 0, 'Rifiutato', 2, 6),
(6, 'fatto male', 'fatto malissimo', 2, 'Rifiutato', 2, 7),
(7, NULL, NULL, NULL, 'Attesa Valutazioni', 1, 3),
(8, NULL, NULL, NULL, 'Attesa Valutazioni', 1, 4),
(9, 'fatto male', 'fatto malissimo', 2, 'Rifiutato', 4, 3),
(10, 'fatto male', 'fatto malissimo', 2, 'Rifiutato', 5, 4),
(11, NULL, NULL, NULL, 'Attesa Valutazioni', 1, 15),
(12, NULL, NULL, NULL, 'Attesa Valutazioni', 1, 16);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articolo`
--
ALTER TABLE `articolo`
  ADD PRIMARY KEY (`pid`),
  ADD UNIQUE KEY `pid` (`pid`);

--
-- Indexes for table `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `utente_articolo`
--
ALTER TABLE `utente_articolo`
  ADD PRIMARY KEY (`utente_id`,`articolo_id`),
  ADD KEY `articolo_id` (`articolo_id`);

--
-- Indexes for table `valutazione_`
--
ALTER TABLE `valutazione_`
  ADD PRIMARY KEY (`id_valutazione`),
  ADD UNIQUE KEY `id_valutazione` (`id_valutazione`),
  ADD KEY `id_utente` (`id_utente`),
  ADD KEY `id_articolo` (`id_articolo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articolo`
--
ALTER TABLE `articolo`
  MODIFY `pid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `utente`
--
ALTER TABLE `utente`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `valutazione_`
--
ALTER TABLE `valutazione_`
  MODIFY `id_valutazione` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `utente_articolo`
--
ALTER TABLE `utente_articolo`
  ADD CONSTRAINT `utente_articolo_ibfk_1` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utente_articolo_ibfk_2` FOREIGN KEY (`articolo_id`) REFERENCES `articolo` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utente_articolo_ibfk_3` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utente_articolo_ibfk_4` FOREIGN KEY (`articolo_id`) REFERENCES `articolo` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `valutazione_`
--
ALTER TABLE `valutazione_`
  ADD CONSTRAINT `valutazione__ibfk_1` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `valutazione__ibfk_2` FOREIGN KEY (`id_articolo`) REFERENCES `articolo` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
