-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-08-2023 a las 19:17:42
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_todo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login_model`
--

CREATE TABLE `login_model` (
  `user_email` varchar(255) NOT NULL,
  `user_favorites` text DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `login_model`
--

INSERT INTO `login_model` (`user_email`, `user_favorites`, `user_name`, `user_password`, `user_type`) VALUES
('alberto@capgemini.com', '[{\"prodMessage\":\"Ahora ya nada.\",\"prodType\":\"Sudadera\",\"prodSize\":\"L\",\"prodColor\":\"Blanco\",\"terms\":true}]', 'Alber', '1!qQwe', NULL),
('dani@capgemini.com', '', 'Dani', '1!qQwe', NULL),
('javi@capgemini.com', '[{\"prodMessage\":\"El mejor TIO\",\"prodType\":\"Camiseta\",\"prodSize\":\"XL\",\"prodColor\":\"Blanco\",\"terms\":true},{\"prodMessage\":\"Ola k ase?\",\"prodType\":\"Taza\",\"prodSize\":null,\"prodColor\":\"Negro\",\"terms\":true},{\"prodMessage\":\"Ahora NO.\",\"prodType\":\"Taza\",\"prodSize\":null,\"prodColor\":\"Blanco\",\"terms\":true},{\"prodMessage\":\"Piquen Codigo!\",\"prodType\":\"Sudadera\",\"prodSize\":\"M\",\"prodColor\":\"Negro\",\"terms\":true}]', 'Javi', '1!qQwe', NULL),
('libertad@capgemini.com', '[{\"prodMessage\":\"Borrar, no comentar\",\"prodType\":\"Botella\",\"prodSize\":null,\"prodColor\":\"Blanco\",\"terms\":true}]', 'Liber', '1!qQwe', NULL),
('lucia@capgemini.com', '[{\"prodMessage\":\"Buena muchacha...\",\"prodType\":\"Camiseta\",\"prodSize\":\"M\",\"prodColor\":\"Negro\",\"terms\":true}]', 'Lulu', '1!qQwe', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `login_model`
--
ALTER TABLE `login_model`
  ADD PRIMARY KEY (`user_email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
