-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220525.c1e393abce
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 26 mai 2022 à 18:34
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `appbank`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `Id_Client` int(50) NOT NULL,
  `Prenom_cl` varchar(50) NOT NULL,
  `Nom_Cl` varchar(50) NOT NULL,
  `Email_Cl` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `Ville_Cl` varchar(50) NOT NULL,
  `tel_Cl` varchar(10) NOT NULL,
  `Adresse_Cl` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`Id_Client`, `Prenom_cl`, `Nom_Cl`, `Email_Cl`, `birthday`, `Ville_Cl`, `tel_Cl`, `Adresse_Cl`) VALUES
(1, 'Jackson', 'Wille', 'jwille0@addtoany.com', '0000-00-00', 'Tochio-honchō', '', ''),
(2, 'Harold', 'Cressor', 'hcressor1@lycos.com', '0000-00-00', 'Liuzuo', '', ''),
(3, 'Shirley', 'Scalia', 'sscalia2@live.com', '0000-00-00', 'San José', '', ''),
(4, 'Isabella', 'Giacomi', 'igiacomi3@marketwatch.com', '0000-00-00', 'Colcabamba', '', ''),
(5, 'Luce', 'Maffy', 'lmaffy4@archive.org', '0000-00-00', 'Partizan', '', ''),
(6, 'Leroy', 'Sanpere', 'lsanpere5@tinyurl.com', '0000-00-00', 'Kubangwaru', '', ''),
(7, 'Monro', 'Morcom', 'mmorcom6@oracle.com', '0000-00-00', 'Krasne', '', ''),
(8, 'Creighton', 'Woodworth', 'cwoodworth7@google.cn', '0000-00-00', 'Longkou', '', ''),
(9, 'Fae', 'Tribell', 'ftribell8@pbs.org', '0000-00-00', 'Wanfa', '', ''),
(10, 'Sayre', 'Loren', 'sloren9@umich.edu', '0000-00-00', 'Vairão', '', ''),
(11, 'Nikolia', 'Clementet', 'nclementeta@cnet.com', '0000-00-00', 'Rincón', '', ''),
(12, 'Yulma', 'Raddin', 'yraddinb@mapquest.com', '0000-00-00', 'La Maná', '', ''),
(13, 'Merrick', 'Ballinger', 'mballingerc@gmpg.org', '0000-00-00', 'Dengzhou', '', ''),
(14, 'Pen', 'Clemmett', 'pclemmettd@usatoday.com', '0000-00-00', 'Fandriana', '', ''),
(15, 'Darren', 'Winchurch', 'dwinchurche@myspace.com', '0000-00-00', 'Douliu', '', ''),
(16, 'Forster', 'Fahrenbach', 'ffahrenbachf@friendfeed.com', '0000-00-00', 'Concepción', '', ''),
(17, 'Silvia', 'Balstone', 'sbalstoneg@paypal.com', '0000-00-00', 'Hekou', '', ''),
(18, 'Claudia', 'Sircomb', 'csircombh@comsenz.com', '0000-00-00', 'Jiangkou', '', ''),
(19, 'Leticia', 'Morley', 'lmorleyi@stanford.edu', '0000-00-00', 'Conde', '', ''),
(20, 'Demetri', 'Bangle', 'dbanglej@ow.ly', '0000-00-00', 'Kapinango', '', ''),
(21, 'Ogden', 'Ovitts', 'oovittsk@hugedomains.com', '0000-00-00', 'Sapucaia', '', ''),
(22, 'Merrel', 'Wellbank', 'mwellbankl@flavors.me', '0000-00-00', 'Mar’’ina Horka', '', ''),
(23, 'Orion', 'Skirvane', 'oskirvanem@home.pl', '0000-00-00', 'Borodinskiy', '', ''),
(24, 'Giacinta', 'Tidy', 'gtidyn@photobucket.com', '0000-00-00', 'Ibrā’', '', ''),
(25, 'Elnore', 'Mulcahy', 'emulcahyo@jalbum.net', '0000-00-00', 'Býšť', '', ''),
(26, 'Lacey', 'Jenk', 'ljenkp@canalblog.com', '0000-00-00', 'Yanling', '', ''),
(27, 'Adair', 'Rogier', 'arogierq@hao123.com', '0000-00-00', 'Tangkeng', '', ''),
(28, 'Hermy', 'Dominy', 'hdominyr@nationalgeographic.com', '0000-00-00', 'Batur Kidul', '', ''),
(29, 'Kalle', 'Bruce', 'kbruces@vkontakte.ru', '0000-00-00', 'Vyksa', '', ''),
(30, 'Aleksandr', 'Timny', 'atimnyt@unicef.org', '0000-00-00', 'Mazańcowice', '', ''),
(31, 'Joane', 'Berndtsson', 'jberndtssonu@seesaa.net', '0000-00-00', 'La Motte-Servolex', '', ''),
(32, 'Sam', 'Hawker', 'shawkerv@sciencedirect.com', '0000-00-00', 'Krandil', '', ''),
(33, 'Quint', 'Howick', 'qhowickw@t-online.de', '0000-00-00', 'Wuxue Shi', '', ''),
(34, 'Sly', 'Playdon', 'splaydonx@slashdot.org', '0000-00-00', 'Rybache', '', ''),
(35, 'Sheela', 'Sumner', 'ssumnery@wufoo.com', '0000-00-00', 'Wonorejo', '', ''),
(36, 'Jedediah', 'Hebron', 'jhebronz@chron.com', '0000-00-00', 'Nàng Mau', '', ''),
(37, 'Che', 'Gahagan', 'cgahagan10@ihg.com', '0000-00-00', 'Yanguan', '', ''),
(38, 'Jayme', 'Gallaher', 'jgallaher11@rakuten.co.jp', '0000-00-00', 'Stockholm', '', ''),
(39, 'Frasier', 'Angus', 'fangus12@cafepress.com', '0000-00-00', 'Koukkuniemi', '', ''),
(40, 'Kelila', 'Lurcock', 'klurcock13@google.com.au', '0000-00-00', 'Paços de Ferreira', '', ''),
(41, 'Vidovic', 'Daunay', 'vdaunay14@i2i.jp', '0000-00-00', 'Strogino', '', ''),
(42, 'Skylar', 'Dowry', 'sdowry15@facebook.com', '0000-00-00', 'Zamora', '', ''),
(43, 'Alisha', 'Doyland', 'adoyland16@deviantart.com', '0000-00-00', 'Sanxi', '', ''),
(44, 'Janene', 'Giacopini', 'jgiacopini17@eventbrite.com', '0000-00-00', 'Miandrarivo', '', ''),
(45, 'Maxwell', 'Weafer', 'mweafer18@google.com', '0000-00-00', 'Dīla', '', ''),
(46, 'Sammie', 'Dallaway', 'sdallaway19@baidu.com', '0000-00-00', 'Nizhniy Bestyakh', '', ''),
(47, 'Daryn', 'Lillistone', 'dlillistone1a@hubpages.com', '0000-00-00', 'Daga', '', ''),
(48, 'Rafi', 'Sember', 'rsember1b@umich.edu', '0000-00-00', 'Taosha', '', ''),
(49, 'Merrel', 'Gildroy', 'mgildroy1c@ocn.ne.jp', '0000-00-00', 'Zolotonosha', '', ''),
(50, 'Oriana', 'Giacopelo', 'ogiacopelo1d@drupal.org', '0000-00-00', 'Rojas', '', ''),
(51, 'Taber', 'Henkens', 'thenkens1e@reference.com', '0000-00-00', 'Biscoitos', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id_Compte` varchar(50) NOT NULL,
  `sole_Cmp` varchar(50) DEFAULT NULL,
  `date_Cmp` date DEFAULT NULL,
  `id_client` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id_Compte`, `sole_Cmp`, `date_Cmp`, `id_client`) VALUES
('10', '100', '2018-04-11', 10),
('11', '-289', '2019-04-02', 12),
('20', '-23', '2022-04-14', 23),
('25', '-23', '2022-04-14', 23),
('8', '1657', '2019-04-04', 11),
('9', '789', '2018-04-04', 3);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `date_Op` date DEFAULT NULL,
  `valeur_Op` varchar(50) DEFAULT NULL,
  `type_Op` varchar(50) DEFAULT NULL,
  `id_Compte` varchar(50) NOT NULL,
  `id_Operation` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`date_Op`, `valeur_Op`, `type_Op`, `id_Compte`, `id_Operation`) VALUES
('2022-04-06', '123', 'crédit', '9', 567),
('2015-04-01', '123', 'crédit', '10', 1234),
('2021-04-13', '123456', 'débit', '8', 4320),
('2018-04-11', '123456', 'débit', '11', 4321);

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `userEmail` varchar(50) NOT NULL,
  `userMdp` varchar(50) NOT NULL,
  `idPerso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`userEmail`, `userMdp`, `idPerso`) VALUES
('zaid@appbank.com', '123456', 7);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Id_Client`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id_Compte`),
  ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`id_Operation`),
  ADD KEY `id_Compte` (`id_Compte`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`idPerso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



