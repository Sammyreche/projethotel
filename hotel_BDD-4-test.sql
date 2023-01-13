-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : ven. 13 jan. 2023 à 09:44
-- Version du serveur :  5.7.34
-- Version de PHP : 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hotel_BDD`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `email` varchar(50) NOT NULL,
  `birthdate` date NOT NULL,
  `name` varchar(35) DEFAULT NULL,
  `firstname` varchar(35) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`email`, `birthdate`, `name`, `firstname`, `tel`, `id_client`) VALUES
('client@ client', '2023-01-12', 'lam', 'omar', '1111111', 1),
('client2@client2', '2023-01-12', 'toto', 'tata', '222222', 2);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `type_compte` enum('admin','personnel','client') NOT NULL,
  `id` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`type_compte`, `id`, `login`, `password`) VALUES
('client', 1, 'client', 'client'),
('client', 2, 'client2@client2', 'client2@client2');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `admin_id_admin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `hotel_personnels`
--

CREATE TABLE `hotel_personnels` (
  `hotel_id` int(11) NOT NULL,
  `personnels_id_personnel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `hotel_reservations`
--

CREATE TABLE `hotel_reservations` (
  `hotel_id` int(11) NOT NULL,
  `reservations_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `passenger`
--

CREATE TABLE `passenger` (
  `id` int(11) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `name` varchar(35) DEFAULT NULL,
  `firstname` varchar(35) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `prestation_id` int(11) DEFAULT NULL,
  `resa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `passenger`
--

INSERT INTO `passenger` (`id`, `birthdate`, `name`, `firstname`, `room_id`, `prestation_id`, `resa`) VALUES
(1, '2023-01-11', 'chads', 'chfffa', 1, 1, 1),
(6, '2023-01-11', 'chads', 'chfffa', 5, 6, 5),
(7, '2023-01-11', 'chads', 'chfffa', 5, 7, 5),
(8, '2023-01-11', 'chads', 'chfffa', 6, 8, 6),
(9, '2023-01-11', 'chads', 'chfffa', 6, 9, 6),
(12, '2023-01-11', 'chads', 'chfffa', 8, 12, 8),
(13, '2023-01-11', 'chads', 'chfffa', 8, 13, 8),
(16, '2023-01-11', 'chads', 'chfffa', 10, 16, 10),
(17, '2023-01-11', 'chads', 'chfffa', 10, 17, 10),
(18, '2023-01-11', 'chads', 'chfffa', 11, 18, 11),
(19, '2023-01-11', 'chads', 'chfffa', 11, 19, 11),
(20, '2023-01-11', 'chads', 'chfffa', 12, 20, 12),
(21, '2023-01-11', 'chads', 'chfffa', 12, 21, 12),
(22, '2023-01-11', 'chads', 'chfffa', 13, 22, 13),
(23, '2023-01-11', 'chads', 'chfffa', 13, 23, 13),
(24, '2023-01-11', 'chads', 'chfffa', 14, 24, 14),
(25, '2023-01-11', 'chads', 'chfffa', 14, 25, 14),
(26, '2023-01-11', 'chads', 'chfffa', 15, 26, 15),
(27, '2023-01-11', 'chads', 'chfffa', 15, 27, 15),
(32, '2023-01-11', 'chads', 'chfffa', 18, 32, 18),
(33, '2023-01-11', 'chads', 'chfffa', 18, 33, 18),
(34, '2023-01-11', 'chads', 'chfffa', 19, 34, 19),
(35, '2023-01-11', 'chads', 'chfffa', 19, 35, 19),
(36, '2023-01-11', 'chads', 'chfffa', 20, 36, 20),
(37, '2023-01-11', 'chads', 'chfffa', 20, 37, 20),
(38, '2023-01-11', 'chads', 'chfffa', 21, 38, 21),
(39, '2023-01-11', 'chads', 'chfffa', 21, 39, 21),
(40, '2023-01-11', 'chads', 'chfffa', 22, 40, 22),
(41, '2023-01-11', 'chads', 'chfffa', 22, 41, 22),
(42, '2023-01-11', 'chads', 'chfffa', 23, 42, 23),
(43, '2023-01-11', 'chads', 'chfffa', 23, 43, 23),
(44, '2023-01-11', 'chads', 'chfffa', 24, 44, 24),
(45, '2023-01-11', 'chads', 'chfffa', 24, 45, 24),
(46, '2023-01-11', 'chads', 'chfffa', 25, 46, 25),
(47, '2023-01-11', 'chads', 'chfffa', 25, 47, 25);

-- --------------------------------------------------------

--
-- Structure de la table `prestation`
--

CREATE TABLE `prestation` (
  `id` int(11) NOT NULL,
  `date_prestation` date DEFAULT NULL,
  `nombre` int(11) NOT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `type_prestation` enum('restaurant','spa','salledesport') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `prestation`
--

INSERT INTO `prestation` (`id`, `date_prestation`, `nombre`, `price`, `type_prestation`) VALUES
(1, '2023-01-11', 3, NULL, 'spa'),
(6, '2023-01-11', 3, NULL, 'spa'),
(7, '2023-01-11', 3, NULL, 'spa'),
(8, '2023-01-11', 3, NULL, 'spa'),
(9, '2023-01-11', 3, NULL, 'spa'),
(12, '2023-01-11', 3, NULL, 'spa'),
(13, '2023-01-11', 3, NULL, 'spa'),
(16, '2023-01-11', 3, NULL, 'spa'),
(17, '2023-01-11', 3, NULL, 'spa'),
(18, '2023-01-11', 3, NULL, 'spa'),
(19, '2023-01-11', 3, NULL, 'spa'),
(20, '2023-01-11', 3, NULL, 'spa'),
(21, '2023-01-11', 3, NULL, 'spa'),
(22, '2023-01-11', 3, NULL, 'spa'),
(23, '2023-01-11', 3, NULL, 'spa'),
(24, '2023-01-11', 3, NULL, 'spa'),
(25, '2023-01-11', 3, NULL, 'spa'),
(26, '2023-01-11', 3, NULL, 'spa'),
(27, '2023-01-11', 3, NULL, 'spa'),
(32, '2023-01-11', 3, NULL, 'spa'),
(33, '2023-01-11', 3, NULL, 'spa'),
(34, '2023-01-11', 3, NULL, 'spa'),
(35, '2023-01-11', 3, NULL, 'spa'),
(36, '2023-01-11', 3, NULL, 'spa'),
(37, '2023-01-11', 3, NULL, 'spa'),
(38, '2023-01-11', 3, NULL, 'spa'),
(39, '2023-01-11', 3, NULL, 'spa'),
(40, '2023-01-11', 3, NULL, 'spa'),
(41, '2023-01-11', 3, NULL, 'spa'),
(42, '2023-01-11', 3, NULL, 'spa'),
(43, '2023-01-11', 3, NULL, 'spa'),
(44, '2023-01-11', 3, NULL, 'spa'),
(45, '2023-01-11', 3, NULL, 'spa'),
(46, '2023-01-11', 3, NULL, 'spa'),
(47, '2023-01-11', 3, NULL, 'spa');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `main_client` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `date_debut`, `date_fin`, `main_client`) VALUES
(1, '2022-01-13', '2022-11-12', 1),
(5, '2022-01-11', '2022-11-12', 1),
(6, '2022-01-11', '2022-11-12', 1),
(8, '2022-01-11', '2022-11-12', 1),
(10, '2022-01-11', '2022-11-12', 1),
(11, '2022-01-11', '2022-11-12', 1),
(12, '2022-01-11', '2022-11-12', 1),
(13, '2022-01-11', '2022-11-12', 1),
(14, '2022-01-11', '2022-11-12', 1),
(15, '2022-01-11', '2022-11-12', 1),
(18, '2022-01-11', '2022-11-12', 2),
(19, '2022-01-11', '2022-11-12', 2),
(20, '2022-01-11', '2022-11-12', 2),
(21, '2022-01-11', '2022-11-12', 2),
(22, '2022-01-11', '2022-11-12', 2),
(23, '2022-01-11', '2022-11-12', 2),
(24, '2022-01-11', '2022-11-12', 1),
(25, '2022-01-11', '2022-11-12', 2);

-- --------------------------------------------------------

--
-- Structure de la table `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `type_chambre` enum('chambresimple','suite','suitepresidentielle') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `room`
--

INSERT INTO `room` (`id`, `type_chambre`) VALUES
(1, 'chambresimple'),
(2, 'chambresimple'),
(3, 'chambresimple'),
(4, 'chambresimple'),
(5, 'chambresimple'),
(6, 'chambresimple'),
(7, 'chambresimple'),
(8, 'chambresimple'),
(9, 'chambresimple'),
(10, 'chambresimple'),
(11, 'chambresimple'),
(12, 'chambresimple'),
(13, 'chambresimple'),
(14, 'chambresimple'),
(15, 'chambresimple'),
(16, 'chambresimple'),
(17, 'chambresimple'),
(18, 'chambresimple'),
(19, 'chambresimple'),
(20, 'chambresimple'),
(21, 'chambresimple'),
(22, 'chambresimple'),
(23, 'chambresimple'),
(24, 'chambresimple'),
(25, 'chambresimple');

-- --------------------------------------------------------

--
-- Structure de la table `staff`
--

CREATE TABLE `staff` (
  `name` varchar(35) DEFAULT NULL,
  `firstname` varchar(35) DEFAULT NULL,
  `id_personnel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrg3gc3idmkvc5besv59oe4dtv` (`admin_id_admin`);

--
-- Index pour la table `hotel_personnels`
--
ALTER TABLE `hotel_personnels`
  ADD UNIQUE KEY `UK_40d4db8ohtcttny7i35vdcfvk` (`personnels_id_personnel`),
  ADD KEY `FKtgh353feq70id1cq812wyexqv` (`hotel_id`);

--
-- Index pour la table `hotel_reservations`
--
ALTER TABLE `hotel_reservations`
  ADD UNIQUE KEY `UK_rqdnh06rfjyh9n5e2d7n91aq7` (`reservations_id`),
  ADD KEY `FKq8vnitv2yom5vhgg0bupb7in6` (`hotel_id`);

--
-- Index pour la table `passenger`
--
ALTER TABLE `passenger`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtcdoc7cq1iqmdcmvom9qqr9r` (`room_id`),
  ADD KEY `FKkxw2hs7klesklsugjkxy377cg` (`prestation_id`),
  ADD KEY `FKiw38eep6x8lebcynd94drkn46` (`resa`);

--
-- Index pour la table `prestation`
--
ALTER TABLE `prestation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6gf9n5s9pa8ubta975rdxiola` (`main_client`);

--
-- Index pour la table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id_personnel`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `passenger`
--
ALTER TABLE `passenger`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT pour la table `prestation`
--
ALTER TABLE `prestation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FKdmqqlnuynf5pee6ssfkcu0rou` FOREIGN KEY (`id_admin`) REFERENCES `compte` (`id`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK6ou8mmuhrvsl81ni2krf6s1d1` FOREIGN KEY (`id_client`) REFERENCES `compte` (`id`);

--
-- Contraintes pour la table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `FKrg3gc3idmkvc5besv59oe4dtv` FOREIGN KEY (`admin_id_admin`) REFERENCES `admin` (`id_admin`);

--
-- Contraintes pour la table `hotel_personnels`
--
ALTER TABLE `hotel_personnels`
  ADD CONSTRAINT `FKf2jiqpyyk2u0q9kruj13qgx1p` FOREIGN KEY (`personnels_id_personnel`) REFERENCES `staff` (`id_personnel`),
  ADD CONSTRAINT `FKtgh353feq70id1cq812wyexqv` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`);

--
-- Contraintes pour la table `hotel_reservations`
--
ALTER TABLE `hotel_reservations`
  ADD CONSTRAINT `FKq8vnitv2yom5vhgg0bupb7in6` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `FKsnrcd8gqkdqm57oowwtjly7ua` FOREIGN KEY (`reservations_id`) REFERENCES `reservation` (`id`);

--
-- Contraintes pour la table `passenger`
--
ALTER TABLE `passenger`
  ADD CONSTRAINT `FKiw38eep6x8lebcynd94drkn46` FOREIGN KEY (`resa`) REFERENCES `reservation` (`id`),
  ADD CONSTRAINT `FKkxw2hs7klesklsugjkxy377cg` FOREIGN KEY (`prestation_id`) REFERENCES `prestation` (`id`),
  ADD CONSTRAINT `FKtcdoc7cq1iqmdcmvom9qqr9r` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK6gf9n5s9pa8ubta975rdxiola` FOREIGN KEY (`main_client`) REFERENCES `client` (`id_client`);

--
-- Contraintes pour la table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `FKkd7fmhv9j36cs9unvh2qwdyex` FOREIGN KEY (`id_personnel`) REFERENCES `compte` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
