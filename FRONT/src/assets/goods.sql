-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-08-2023 a las 19:21:47
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
-- Estructura de tabla para la tabla `goods`
--

CREATE TABLE `goods` (
  `id` int(11) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `goods`
--

INSERT INTO `goods` (`id`, `color`, `message`, `size`, `type`) VALUES
(1, 'Blanco', 'El mejor TIO', 'XL', 'Camiseta'),
(2, 'Negro', 'Ola k ase?', NULL, 'Taza'),
(3, 'Blanco', 'Ahora NO.', NULL, 'Taza'),
(4, 'Negro', 'Piquen Codigo!', 'M', 'Sudadera'),
(5, 'Negro', 'Buena muchacha...', 'M', 'Camiseta'),
(7, 'Blanco', 'Borrar, no comentar', NULL, 'Botella'),
(8, 'Blanco', 'Sera por ramas...', NULL, 'Botella'),
(9, 'Blanco', 'Vete de mi rama!', 'L', 'Sudadera'),
(10, 'Blanco', 'Ahora ya nada.', 'L', 'Sudadera');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `goods`
--
ALTER TABLE `goods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
