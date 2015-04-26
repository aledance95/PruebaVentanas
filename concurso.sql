-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-04-2015 a las 01:43:53
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `concurso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
`ID` int(5) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `PrecioVenta` float NOT NULL,
  `Stock` int(11) NOT NULL,
  `Categoria` enum('Productos','Accesorios','Consumibles','Servicios') NOT NULL,
  `Habilitado` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID`, `Nombre`, `PrecioVenta`, `Stock`, `Categoria`, `Habilitado`) VALUES
(1, 'Laptop HP ', 6500, 20, 'Productos', 1),
(2, 'Laptop Dell', 5600, 20, 'Productos', 1),
(3, 'Impresora HP ', 2600, 15, 'Productos', 1),
(4, 'Bocinas 2x3', 230, 10, 'Productos', 1),
(5, 'Mouse Inalambrico', 150, 9, 'Accesorios', 1),
(6, 'Memoria USB 16G', 125, 6, 'Accesorios', 1),
(7, 'USB 32G', 130, 10, 'Accesorios', 1),
(8, 'Disco Duro Inalambrico', 500, 20, 'Accesorios', 1),
(9, '100 hojas blancas', 30, 20, 'Consumibles', 1),
(10, 'Cartucho de Tinta Negro', 190, 25, 'Accesorios', 1),
(11, 'Tinta de Color', 260, 10, 'Consumibles', 1),
(12, 'Reparacion de Laptop', 700, 0, 'Servicios', 1),
(13, 'Reparacion de Impresoras', 800, 0, 'Servicios', 1),
(14, 'Limpieza de laptop', 350, 0, 'Servicios', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE IF NOT EXISTS `vendedor` (
`id` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `ApellidoPaterno` varchar(20) NOT NULL,
  `ApellidoMaterno` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`id`, `usuario`, `password`, `Nombre`, `ApellidoPaterno`, `ApellidoMaterno`) VALUES
(1, 'pedro', 'pedro123', 'Pedro', 'Perafan', 'Carrasco'),
(2, 'ale', 'ale123', 'Alejandra', 'Melendez', 'Reyes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
`ID` int(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Vendedor` int(5) NOT NULL,
  `Subtotal` float NOT NULL,
  `Descuento` int(11) NOT NULL,
  `FormaPago` enum('Contado','Cincuenta','Treinta','Otro') NOT NULL,
  `Total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
 ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
