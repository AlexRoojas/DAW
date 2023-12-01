-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2018 a las 18:55:18
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.1.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `flores`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `dniusuario` varchar(9) NOT NULL,
  `codigoFlor` int(11) NOT NULL,
  `unidades` int(11) NOT NULL,
  `totalprecio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carrito`
--

INSERT INTO `carrito` (`dniusuario`, `codigoFlor`, `unidades`, `totalprecio`) VALUES
('111', 3, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flores`
--

CREATE TABLE `flores` (
  `codigoFlor` int(11) NOT NULL,
  `nombreComun` varchar(30) NOT NULL,
  `nombreCientifico` varchar(30) NOT NULL,
  `codigoLuz` int(11) NOT NULL,
  `precio` int(5) NOT NULL,
  `unidadesVendidas` int(3) NOT NULL,
  `imagen` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `flores`
--

INSERT INTO `flores` (`codigoFlor`, `nombreComun`, `nombreCientifico`, `codigoLuz`, `precio`, `unidadesVendidas`, `imagen`) VALUES
(3, 'Columbine', 'Aquilegia canadensis', 3, 2, 123, 'Columbine.jpg'),
(4, 'Marsh Marigold', 'Caltha palustris', 1, 4, 34, 'Marsh Marigold.jpg'),
(7, 'Cowslip', 'Caltha palustris', 3, 5, 56, 'Cowslip.jpg'),
(8, 'Dutchman\'s-Breeches', 'Dicentra cucullaria', 4, 3, 111, 'Dutchman\'s-Breeches.jpg'),
(9, 'Ginger, Wild', 'Asarum canadense', 4, 3, 42, 'Ginger, Wild.jpg'),
(10, 'Hepatica', 'Hepatica americana', 3, 2, 67, 'Hepatica.jpg'),
(13, 'Liverleaf', 'Hepatica americana', 3, 4, 14, 'Liverleaf.jpg'),
(14, 'Jack-In-The-Pulpit', 'Arisaema triphyllum', 3, 6, 33, 'Jack-In-The-Pulpit.jpg'),
(17, 'Mayapple', 'Podophyllum peltatum', 3, 3, 43, 'Mayapple.jpg'),
(18, 'Phlox, Woodland', 'Phlox divaricata', 5, 3, 23, 'Phlox, Woodland.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flores1`
--

CREATE TABLE `flores1` (
  `codigoFlor` int(11) NOT NULL,
  `nombreComun` varchar(30) NOT NULL,
  `nombreCientifico` varchar(30) NOT NULL,
  `codigoLuz` int(11) NOT NULL,
  `precio` int(5) NOT NULL,
  `unidadesVendidas` int(3) NOT NULL,
  `imagen` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `flores1`
--

INSERT INTO `flores1` (`codigoFlor`, `nombreComun`, `nombreCientifico`, `codigoLuz`, `precio`, `unidadesVendidas`, `imagen`) VALUES
(1, 'Bloodroot', 'Sanguinaria canadensis', 3, 4, 234, 'Bloodroot.jpg'),
(3, 'Columbine', 'Aquilegia canadensis', 3, 2, 123, 'Columbine.jpg'),
(4, 'Marsh Marigold', 'Caltha palustris', 1, 4, 34, 'Marsh Marigold.jpg'),
(7, 'Cowslip', 'Caltha palustris', 3, 5, 56, 'Cowslip.jpg'),
(8, 'Dutchman\'s-Breeches', 'Dicentra cucullaria', 4, 3, 111, 'Dutchman\'s-Breeches.jpg'),
(9, 'Ginger, Wild', 'Asarum canadense', 4, 3, 42, 'Ginger, Wild.jpg'),
(10, 'Hepatica', 'Hepatica americana', 3, 2, 67, 'Hepatica.jpg'),
(13, 'Liverleaf', 'Hepatica americana', 3, 4, 14, 'Liverleaf.jpg'),
(14, 'Jack-In-The-Pulpit', 'Arisaema triphyllum', 3, 6, 33, 'Jack-In-The-Pulpit.jpg'),
(17, 'Mayapple', 'Podophyllum peltatum', 3, 3, 43, 'Mayapple.jpg'),
(18, 'Phlox, Woodland', 'Phlox divaricata', 5, 3, 23, 'Phlox, Woodland.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `luz`
--

CREATE TABLE `luz` (
  `codigoLuz` int(11) NOT NULL,
  `tipoLuz` varchar(20) NOT NULL,
  `agua` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `luz`
--

INSERT INTO `luz` (`codigoLuz`, `tipoLuz`, `agua`) VALUES
(1, 'Mostly Sunny', 'abundante'),
(2, 'Mostly Sunny', 'media'),
(3, 'Mostly Shady', 'media'),
(4, 'Mostly Shady', 'escasa'),
(5, 'Sun or Shade', 'media'),
(6, 'Shade', 'escasa'),
(7, 'Sunny', 'abundante'),
(8, 'Sunny', 'media');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dniusuario` varchar(9) NOT NULL,
  `passusuario` varchar(10) NOT NULL,
  `nombreusuario` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`dniusuario`,`codigoFlor`);

--
-- Indices de la tabla `flores`
--
ALTER TABLE `flores`
  ADD PRIMARY KEY (`codigoFlor`);

--
-- Indices de la tabla `flores1`
--
ALTER TABLE `flores1`
  ADD PRIMARY KEY (`codigoFlor`);

--
-- Indices de la tabla `luz`
--
ALTER TABLE `luz`
  ADD PRIMARY KEY (`codigoLuz`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dniusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `flores`
--
ALTER TABLE `flores`
  MODIFY `codigoFlor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `flores1`
--
ALTER TABLE `flores1`
  MODIFY `codigoFlor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `luz`
--
ALTER TABLE `luz`
  MODIFY `codigoLuz` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
