-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 23-06-2014 a las 21:01:09
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `foro`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `answers`
--

CREATE TABLE IF NOT EXISTS `answers` (
  `idAnswers` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(200) NOT NULL,
  `idQuestions` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idAnswers`),
  UNIQUE KEY `idRespuestas_UNIQUE` (`idAnswers`),
  KEY `fk_Respuestas_Preguntas_idx` (`idQuestions`),
  KEY `fk_Respuestas_Usuarios1_idx` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `answers`
--

INSERT INTO `answers` (`idAnswers`, `answer`, `idQuestions`, `username`, `date`) VALUES
(1, 'this is my firts answer', 1, 'cristian', '2014-06-18 21:30:51'),
(2, 'i dont know', 5, 'cristian', '2014-06-18 21:32:10'),
(3, 'the simpsons', 6, 'cristian', '2014-06-18 21:32:38'),
(4, 'really?', 6, 'cristian', '2014-06-18 21:32:51'),
(5, 'amm, amm, what?', 7, 'cristian', '2014-06-18 21:33:47'),
(6, 'my university have 1000 students', 10, 'cristian', '2014-06-18 21:35:40'),
(7, 'because yes', 11, 'cristian', '2014-06-18 21:36:07'),
(8, 'YES', 12, 'cristian', '2014-06-18 21:36:29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `idCategories` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategories`),
  UNIQUE KEY `idCategorias_UNIQUE` (`idCategories`),
  UNIQUE KEY `nombre_UNIQUE` (`category`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `categories`
--

INSERT INTO `categories` (`idCategories`, `category`) VALUES
(9, 'Cosmetic'),
(2, 'Endodontics'),
(1, 'General'),
(3, 'Orthodontics'),
(4, 'Patients'),
(5, 'Periodontics'),
(6, 'Restoration'),
(7, 'Students'),
(8, 'Surgery');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `questions`
--

CREATE TABLE IF NOT EXISTS `questions` (
  `idQuestions` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(100) NOT NULL,
  `idCategories` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`idQuestions`),
  UNIQUE KEY `idPreguntas_UNIQUE` (`idQuestions`),
  KEY `fk_Preguntas_Categorias1_idx` (`idCategories`),
  KEY `fk_Preguntas_Usuarios1_idx` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `questions`
--

INSERT INTO `questions` (`idQuestions`, `question`, `idCategories`, `date`, `username`) VALUES
(1, 'why my teeth are so big?', 1, '2014-06-18 20:50:31', 'cristian'),
(2, 'Why are my teeth hurting me!?', 1, '2014-06-18 20:50:31', 'cristian'),
(3, 'This is other question, why?', 1, '2014-06-18 21:30:29', 'cristian'),
(4, 'what is endodontics??', 2, '2014-06-18 21:31:42', 'cristian'),
(5, 'what is orthodontics?', 3, '2014-06-18 21:32:00', 'cristian'),
(6, 'who are the patients??', 4, '2014-06-18 21:32:29', 'cristian'),
(7, 'what is periodontics???', 5, '2014-06-18 21:33:36', 'cristian'),
(8, 'what is restoration???', 6, '2014-06-18 21:34:06', 'cristian'),
(9, 'me po ui lopik kil??', 6, '2014-06-18 21:34:27', 'cristian'),
(10, 'who are the students??', 7, '2014-06-18 21:35:05', 'cristian'),
(11, 'surgery?? why??', 8, '2014-06-18 21:35:56', 'cristian'),
(12, 'cosmetics???', 9, '2014-06-18 21:36:22', 'cristian');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `ussername_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`username`, `password`, `name`, `lastname`, `email`) VALUES
('cristian', '1234', 'cristian', 'Ramirez', 'cris@gmail.com');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `fk_Respuestas_Preguntas` FOREIGN KEY (`idQuestions`) REFERENCES `questions` (`idQuestions`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Respuestas_Usuarios1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `fk_Preguntas_Categorias1` FOREIGN KEY (`idCategories`) REFERENCES `categories` (`idCategories`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Preguntas_Usuarios1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
