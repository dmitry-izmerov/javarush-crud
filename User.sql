-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Авг 07 2015 г., 18:32
-- Версия сервера: 5.5.44-0ubuntu0.14.04.1
-- Версия PHP: 5.5.9-1ubuntu4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `test`
--

-- --------------------------------------------------------

--
-- Структура таблицы `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  `createdDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- Дамп данных таблицы `User`
--

INSERT INTO `User` (`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES
(3, 'user1', 34, 0, '2015-08-07 10:05:12'),
(4, 'user2', 26, 0, '2015-08-07 10:05:12'),
(5, 'user3', 30, 0, '2015-08-06 21:00:00'),
(7, 'user4', 30, 0, '2015-08-07 15:12:47'),
(8, 'user5', 30, 0, '2015-08-07 15:15:49'),
(9, 'user6', 22, 0, '2015-08-07 15:21:06'),
(10, 'user7', 23, 0, '2015-08-07 15:21:16'),
(11, 'user8', 24, 0, '2015-08-07 15:21:26'),
(12, 'user9', 24, 0, '2015-08-07 15:21:41'),
(13, 'user10', 25, 0, '2015-08-07 15:22:06'),
(14, 'user11', 26, 1, '2015-08-07 15:25:15'),
(15, 'user12', 26, 1, '2015-08-07 15:25:32'),
(16, 'user13', 27, 1, '2015-08-07 15:25:46'),
(17, 'user14', 28, 1, '2015-08-07 15:25:58'),
(18, 'user15', 29, 1, '2015-08-07 15:26:17'),
(19, 'user16', 28, 1, '2015-08-07 15:26:33'),
(20, 'user17', 30, 1, '2015-08-07 15:26:49'),
(21, 'user18', 28, 1, '2015-08-07 15:27:01'),
(22, 'user19', 30, 1, '2015-08-07 15:27:14'),
(23, 'user20', 28, 1, '2015-08-07 15:27:26');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
