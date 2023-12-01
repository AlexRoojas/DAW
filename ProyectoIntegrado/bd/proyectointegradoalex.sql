-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2022 a las 19:36:38
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectointegradoalex`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cesta`
--

CREATE TABLE `cesta` (
  `dniusuario` varchar(10) NOT NULL,
  `codproducto` int(5) NOT NULL,
  `unidades_cesta` int(11) NOT NULL,
  `totalpreciocesta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cesta`
--

INSERT INTO `cesta` (`dniusuario`, `codproducto`, `unidades_cesta`, `totalpreciocesta`) VALUES
('2', 1, 1, 144),
('2', 3, 1, 260),
('2', 4, 1, 148);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `cod_cita` int(11) NOT NULL,
  `matric_coche` varchar(10) NOT NULL,
  `marca_coche` varchar(30) NOT NULL,
  `modelo_coche` varchar(30) NOT NULL,
  `tipo_cita` varchar(15) NOT NULL,
  `descrp_cita` varchar(200) NOT NULL,
  `fecha_cita` varchar(15) NOT NULL,
  `estado_cita` varchar(20) NOT NULL,
  `dni_cli` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`cod_cita`, `matric_coche`, `marca_coche`, `modelo_coche`, `tipo_cita`, `descrp_cita`, `fecha_cita`, `estado_cita`, `dni_cli`) VALUES
(4, '5543HFN', 'Ford', 'Focus', 'neumaticos', 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quibusdam architecto libero, laboriosam ipsum sunt a vel quisquam tempore similique dignissimos asperiores cum consectetur, odit ut laudantium', '12/06/2022', 'Aceptado', '2'),
(11, '5522HFN', 'Ford', 'Focus', 'neumaticos', 'AY', '20/06/2022', 'Recibido', '1'),
(12, '5522HFN', 'Ford', 'Focus', 'neumaticos', 'AY', '21/06/2022', 'Recibido', '1'),
(13, '5522HFN', 'Ford', 'Focus', 'neumaticos', 'AY', '21/06/2022', 'Recibido', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `cod_fact` int(3) NOT NULL,
  `dni_cli` varchar(10) NOT NULL,
  `unidadestotal` int(11) NOT NULL,
  `preciototal` int(11) NOT NULL,
  `fechafinal` varchar(15) NOT NULL,
  `cod_mec` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`cod_fact`, `dni_cli`, `unidadestotal`, `preciototal`, `fechafinal`, `cod_mec`) VALUES
(68, '1', 1, 144, '10/06/2022', NULL),
(69, '2', 4, 576, '12/06/2022', NULL),
(70, '1', 4, 284, '16/06/2022', NULL),
(71, '1', 2, 288, '16/06/2022', NULL),
(72, '1', 2, 166, '17/06/2022', NULL),
(73, '1', 3, 444, '20/06/2022', NULL),
(74, '1', 3, 444, '20/06/2022', NULL),
(75, '1', 4, 592, '20/06/2022', NULL),
(76, '1', 5, 740, '20/06/2022', NULL),
(77, '1', 8, 1184, '20/06/2022', NULL),
(78, '1', 5, 740, '20/06/2022', NULL),
(79, '1', 3, 444, '20/06/2022', NULL),
(80, '1', 2, 282, '20/06/2022', NULL),
(81, '1', 2, 107, '20/06/2022', NULL),
(82, '1', 5, 476, '21/06/2022', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partes`
--

CREATE TABLE `partes` (
  `cod_parte` int(10) NOT NULL,
  `codmec_parte` varchar(10) NOT NULL,
  `matric_parte` varchar(20) NOT NULL,
  `costes_total` int(10) NOT NULL,
  `estado_parte` varchar(20) NOT NULL,
  `fecha_parte` varchar(20) NOT NULL,
  `productos_parte` varchar(50) NOT NULL,
  `codcita_parte` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partes`
--

INSERT INTO `partes` (`cod_parte`, `codmec_parte`, `matric_parte`, `costes_total`, `estado_parte`, `fecha_parte`, `productos_parte`, `codcita_parte`) VALUES
(1, '2', '5544GGG', 2000, 'En Espera', '13/06/2022', '1,3,4', 5),
(2, '2', '5543HFN', 292, 'En Espera', '13/06/2022', '1,4', 4),
(4, '2', '5522HFN', 552, 'en espera', '21/06/2022', '1,3,4', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `cod_prod` int(5) NOT NULL,
  `nom_prod` varchar(100) NOT NULL,
  `categoria_prod` varchar(30) NOT NULL,
  `img_prod` varchar(20) NOT NULL,
  `descrip_prod` varchar(600) NOT NULL,
  `unidades_prod` int(10) NOT NULL,
  `precio_prod` double NOT NULL,
  `puntuacion_prod` int(3) NOT NULL,
  `fecha_prod` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`cod_prod`, `nom_prod`, `categoria_prod`, `img_prod`, `descrip_prod`, `unidades_prod`, `precio_prod`, `puntuacion_prod`, `fecha_prod`) VALUES
(1, 'Batería VARTA Start Stop E39 70Ah-760A', 'Baterias', 'bat1.png', '- Diseñada para vehículos con función Start-Stop.\r\n- Mayor capacidad de arranque gracias a la tecnología PowerFrame®.\r\n-Tecnología AGM (separador plomo ácido con separador de fibra de vidrio absorbe\r\n- Servicios asociados: montaje a domicilio en 2 horas y montaje en centro en 1 hora.nte) para una recarga más rápida de la batería.\r\n- 3 años de garantía si has comprado la batería a partir de marzo 2021.\r\n- Medidas: 278 mm largo x 175 mm ancho x 190 mm alto.', 22, 144, 4, '2022-05-06'),
(2, 'Cola de escape NYC Plata', 'Escapes', 'escape.png', 'Dimensiones: entrada 67x83mm, salida 69x85mm, largo 155mm.\r\nDale un toque deportivo a tu escape. Fácil instalación.', 18, 22, 2, '2022-06-16'),
(3, 'Neumático BRIDGESTONE POTENZA S001 215/45 R20 95 W * XL', 'Neumaticos', 'ruedidd.png', '- Puro rendimiento deportivo con un excelente agarre\r\n- Estabilidad a alta velocidad\r\n- Contacto óptimo con la carretera.', 9, 260, 4, '2022-04-07'),
(4, 'Mecanismo de embrague Sachs 3082 943 041', 'Embragues', 'embr1.jpg', 'Pieza de calidad equivalente a la de origen. Garantía 2 años (ver condiciones en tienda).', 0, 148, 5, '2022-03-16'),
(5, 'Muelle de suspensión MONROE SP0036', 'Suspension', 'monroe.png', '- Aplican fuerza radial para un mejor control.\r\n- Recambio original o de calidad equivalente.', 3, 3, 3, '2022-06-16'),
(6, 'Bieleta de suspensión MOOG PE-LS-5046', 'Suspension', 'supesnmoog.png', 'Las bieletas de suspensión o varillas estabilizadoras son la conexión entre la carrocería principal y el chasis. Esta pieza mantiene la rueda estable y reduce las vibraciones y los movimientos incontrolados.\r\nLas bieletas de suspensión MOOG están fabricadas con materiales de compuestos reforzados para poder garantizar una mayor durabilidad en cualquier condición de circulación. Estas bieletas de suspensión MOOG están forjadas y gracias a sus materiales tienen un nivel de flexibilidad adecuado.', 10, 30, 4, '2022-06-15'),
(7, 'Amortiguador MONROE eje delantero G8109', 'Suspension', 'susmonroe.png', 'La función de los amortiguadores es mantener la adhesión del coche a la calzada, reduciendo las oscilaciones del vehículo. Forman parte del triángulo de seguridad del vehículo : frenado, neumáticos, amortiguadores. Los amortiguadores MONROE Original están especialmente diseñados para los vehículos que suelen hacer muchos kilómetros.', 4, 70, 3, '2022-04-10'),
(8, 'Bieleta de suspensión MOOG PE-LS-1573', 'Suspension', 'moog2.png', 'Las bieletas de suspensión o varillas estabilizadoras son la conexión entre la carrocería principal y el chasis. Esta pieza mantiene la rueda estable y reduce las vibraciones y los movimientos incontrolados.\r\nLas bieletas de suspensión MOOG están fabricadas con materiales de compuestos reforzados para poder garantizar una mayor durabilidad en cualquier condición de circulación. Estas bieletas de suspensión MOOG están forjadas y gracias a sus materiales tienen un nivel de flexibilidad adecuado.', 4, 27, 4, '2022-05-07'),
(9, 'Rótula de suspensión Moog RE-BJ-0811', 'Suspension', 'mooog.png', 'La rótula de suspensión forma parte del mecanismo de suspensión del vehículo. Esta pieza permite que las ruedas y la suspensión se muevan juntas de manera eficaz.\r\nLas rótulas de suspensión MOOG están fabricadas a partir de un único bloque de aleación de acero de grano fino. Gracias a este método de fabricación se consigue una fuerza superior. Estas rótulas cuentan con rodamientos tipo “gusher” de metal sinterizado para ofrecer una mejor resistencia al desgaste.', 10, 15, 5, '2022-05-13'),
(10, 'Neumático Turismo COOPER DISCOVERER A/T3 205/80 R16 104 T XL', 'Neumaticos', 'cooper.png', 'Uso:\r\nEl neumático COOPER Discoverer A/T3 Sport es un neumático de verano, diseñado para vehículos 4x4.\r\nCaracterísticas:\r\nEl neumático COOPER Discoverer A/T3 Sport utiliza tecnología con agujero de aire. Es decir, los moldes utilizados durante la fabricación incorporan tecnología de aireación especial en la zona de la banda de', 4, 74, 2, '2022-05-10'),
(11, 'Neumático CONTINENTAL PREMIUMCONTACT 6 195/65 R15 91 V', 'Neumaticos', 'contin.png', 'El neumático CONTINENTAL PREMIUMCONTACT 6 logra ofrecer un máximo confort gracias a la optimización de la huella. La mezcla de polímeros optimizada para el desgaste proporciona una notable mejora de más del 15% en el rendimiento kilométrico. Los nuevos polímeros han mejorado la superficie de contacto y la durabilidad de la banda de rodadura en condiciones de conducción diarias para todos los segmentos de vehículos. Además, la robustez del diseño mejora la comodidad y el kilometraje y reduce el ruido interior.\r\nEste neumático aporta una conducción deportiva en todo tipo de vehículos gracias a u', 10, 73, 5, '2022-05-15'),
(12, 'Neumático CONTINENTAL PREMIUMCONTACT 6 195/65R15 91V', 'Neumaticos', 'contin2.png', 'Máximo nivel con tecnología alemana. Eficaz en frenada en suelo mojado mejorando el kilometraje gracias al compuesto de caucho. Comodidad de conducción gracias a la optimización del confort. Permite una conducción deportiva gracias a una manejabilidad optimizada. Neumático de Verano para Turismos Continental Premiumcontact 6 con medidas 195/65 R15 índice de carga 91 y código de velocidad V - Recuerda que en neumáticos de verano, la legislación permite montar neumáticos con índice de carga o código de velocidad superior al homologado en la ficha técnica del vehiculo, siempre y cuando los neumát', 4, 80, 4, '2022-06-14'),
(13, 'PIRELLI POWERGY 225/45R17 94 Y', 'Neumaticos', 'pirelli.png', 'Los neumáticos POWERGY de PIRELLI están diseñados específicamente para coche.\r\n\r\nDe acuerdo con los parámetros establecidos en la nueva normativa europea para el etiquetado de neumáticos, tiene un índice de consumo de B, un coeficiente de agarre en suelo mojado de A y un nivel de ruido de 68dB. Están recomendados para verano.\r\n\r\nTiene unas medidas de 225/45 R17 para adaptarse con facilidad a su coche.', 7, 85, 5, '2022-05-01'),
(14, 'Batería VARTA Silver Dynamic E44 77Ah-780A', 'Baterias', 'varta2.png', 'La batería sirve para arrancar el vehículo y para dar alimentación a los diferentes elementos eléctricos (luces...) y electrónicos (autoradio, altavoces...). La batería Silver Dynamic dispone de un rendimiento incomparable y de una resistencia sin igual. Es una batería lista para su uso, sin mantenimiento, de alto rendimiento.', 20, 120, 4, '2022-05-09'),
(15, 'Batería 74AH 660A POSITIVO DERECHA | 278X175X175 AMPODIUM BATTERIES', 'Baterias', 'varta3.png', 'Es igualmente importante tener en cuenta si nuestro vehículo utiliza baterías convencionales (plomo-ácido) u otras batería con gestión electrónica, como las necesarias para los sistemas start stop.\r\nPodemos montar una batería start stop en un vehículo que no la llevaba de origen si queremos una potencia extra de arranque o mayor durabilidad. Sin embargo, no podemos una batería tradicional en un vehículo que de origen utiliza y requiere una batería start stop.', 13, 94, 4, '2022-05-11'),
(16, 'Batería VARTA Start Stop F21 80Ah-800A', 'Baterias', 'varta4.png', 'Las baterías VARTA Silver Dynamic AGM están especialmente diseñadas para vehículos con función Start-Stop con frenada regenerativa , y para motores potentes y coches con equipamiento de alta gama.\r\nSi tu coche es S&S debes poner una batería que se ajuste. Es obligatorio respetar las indicaciones del fabricante para el cambio de batería, asegurando que tenga la misma tecnología que en origen (EFB o AGM). No hacerlo podría generar problemas serios tanto en el coche como en tu propia seguridad.', 8, 180, 3, '2022-05-09'),
(17, 'Batería YUASA - 100 Ah', 'Baterias', 'varta5.png', 'Las baterías VARTA Silver Dynamic AGM están especialmente diseñadas para vehículos con función Start-Stop con frenada regenerativa , y para motores potentes y coches con equipamiento de alta gama.\r\nSi tu coche es S&S debes poner una batería que se ajuste. Es obligatorio respetar las indicaciones del fabricante para el cambio de batería, asegurando que tenga la misma tecnología que en origen (EFB o AGM). No hacerlo podría generar problemas serios tanto en el coche como en tu propia seguridad.', 4, 102, 4, '2022-05-18'),
(18, 'Cola de escape Inoxidable Cromada Universal', 'Escapes', 'escap2.png', 'Dale un toque deportivo a tu escape. Fácil instalación.', 20, 17, 5, '2022-05-01'),
(19, 'Cola de escape Inoxidable Cromada Doble Universal', 'Escapes', 'escap3.png', 'Dimensiones: entrada 63mm, salida 90x32mm (x2), largo 272mm.', 10, 27, 4, '2022-05-19'),
(20, 'Cola de escape SIMONI RACING TRX/20B', 'Escapes', 'escap4.png', 'Embellecedor de escape para dar a tu vehículo un toque más deportivo. De muy fácil instalación.', 30, 40, 5, '2022-05-02'),
(21, 'Doble salida de escape en acero inoxidable SRACING TRX18', 'Escapes', 'escap5.png', 'Cola de escape de acero inoxidable en color cromo con salida redondeada inclinada.\r\nEl diámetro de salida es de 80 mm y el diámetro de entrada es de 60 mm.\r\nLa longitud total es de 23,5 cm.\r\nFijación Easy Fit, sin soldadura. Fácil de montar.\r\nLa fijación se realiza con 2 tornillos BTR suministrados en una cola de escape original con un diámetro de 37 mm a 60 mm.\r\nEsta cola de escape es adaptable en la mayoría de los vehículos.', 20, 70, 4, '2022-05-20'),
(22, 'Kit de embrague VALEO 828342 (KIT3P)', 'Embragues', 'embr2.png', 'Un kit de tres componentes para turismos es una excelente elección si deseas sustituir todos los componentes de tu embrague a la vez. Este kit de embrague duradero de Valeo incluye una placa de presión de embrague, un disco de embrague y un cojinete de liberación o CSC. Es la elección correcta para la mayoría de vehículos. Este embrague está fabricado con calidad OE y garantiza una larga vida útil. Podemos reducir los ruidos y vibraciones del embrague, lo que proporcionará al conductor una comodidad de conducción superior gracias a unos cambios de marcha más suaves.', 5, 135, 3, '2022-05-07'),
(23, 'Kit de embrague VALEO 835068', 'Embragues', 'embr3.png', 'La función del embrague est conectar el motor con la caja de cambios, sin rascar ni dar tirones. Permite cortar la conexión entre estos para cambiar de marcha. Protege contra la sobrecarga y amortigua las vibraciones del motor.', 9, 597, 3, '2022-05-22'),
(24, 'Mecanismo de embrague SACHS 2290 601 020', 'Embragues', 'embr4.png', 'La función del embrague est conectar el motor con la caja de cambios, sin rascar ni dar tirones. Permite cortar la conexión entre estos para cambiar de marcha. Protege contra la sobrecarga y amortigua las vibraciones del motor.', 3, 552, 5, '2022-05-27'),
(25, 'Kit de embrague Sachs 3000 825 901', 'Embragues', 'embr5.png', 'La función del embrague est conectar el motor con la caja de cambios, sin rascar ni dar tirones. Permite cortar la conexión entre estos para cambiar de marcha. Protege contra la sobrecarga y amortigua las vibraciones del motor.', 10, 116, 4, '2022-05-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntuaciones`
--

CREATE TABLE `puntuaciones` (
  `codigoprod` int(11) NOT NULL,
  `dniusuario` varchar(20) NOT NULL,
  `puntuacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `puntuaciones`
--

INSERT INTO `puntuaciones` (`codigoprod`, `dniusuario`, `puntuacion`) VALUES
(1, '1', 0),
(2, '1', 0),
(13, '1', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_factura`
--

CREATE TABLE `registro_factura` (
  `cod_reg` int(11) NOT NULL,
  `cod_factura` int(11) NOT NULL,
  `cod_producto` int(11) NOT NULL,
  `dni_usu` varchar(20) NOT NULL,
  `total_unidades` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registro_factura`
--

INSERT INTO `registro_factura` (`cod_reg`, `cod_factura`, `cod_producto`, `dni_usu`, `total_unidades`) VALUES
(82, 68, 1, '1', 1),
(83, 69, 1, '2', 4),
(84, 70, 2, '1', 3),
(85, 70, 3, '1', 1),
(86, 71, 1, '1', 2),
(87, 72, 1, '1', 1),
(88, 72, 2, '1', 1),
(89, 73, 4, '1', 3),
(90, 74, 4, '1', 3),
(91, 75, 4, '1', 4),
(92, 76, 4, '1', 5),
(93, 77, 4, '1', 8),
(94, 78, 4, '1', 5),
(95, 79, 4, '1', 3),
(96, 80, 2, '1', 1),
(97, 80, 3, '1', 1),
(98, 81, 2, '1', 1),
(99, 81, 13, '1', 1),
(100, 82, 1, '1', 3),
(101, 82, 2, '1', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscrip`
--

CREATE TABLE `suscrip` (
  `email_susc` varchar(51) NOT NULL,
  `fecha_susc` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `suscrip`
--

INSERT INTO `suscrip` (`email_susc`, `fecha_susc`) VALUES
('ketegano2013@gmail.com', '21/06/2022'),
('rojasrosadoa@iesmartinrivero.org', '21/06/2022');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `dniusu` varchar(10) NOT NULL,
  `nombreusu` varchar(20) NOT NULL,
  `apellusu` varchar(30) NOT NULL,
  `emailusu` varchar(30) NOT NULL,
  `contrausu` varchar(20) NOT NULL,
  `localidadusu` varchar(20) NOT NULL,
  `tipousu` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`dniusu`, `nombreusu`, `apellusu`, `emailusu`, `contrausu`, `localidadusu`, `tipousu`) VALUES
('1', 'Alex', 'Rojas', 'arojas@gmail.com', 'kete', 'Ronda', 'C'),
('123123d', 'El', 'jefe', 'jefe@gmail.com', 'kete', 'Malaga', 'A'),
('123123X', 'Alberto', 'Einstain', 'nomeselcorreo@gmail.com', 'kete', 'Ronda', 'C'),
('2', 'Paco', 'Roca', 'elmejormecanico@gmail.com', 'kete', 'Ronda', 'M');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistacestacompleta`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vistacestacompleta` (
`uuid()` varchar(36)
,`dniusuario` varchar(10)
,`codproducto` int(5)
,`nom_prod` varchar(100)
,`img_prod` varchar(20)
,`precio_prod` double
,`unidades_cesta` int(11)
,`totalpreciocesta` double
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistafacturacompleta`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vistafacturacompleta` (
`uuid()` varchar(36)
,`cod_producto` int(11)
,`cod_factura` int(11)
,`nom_prod` varchar(100)
,`precio_prod` double
,`img_prod` varchar(20)
,`total_unidades` int(11)
,`dni_usu` varchar(20)
,`fechafinal` varchar(15)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistapuntuaciones`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vistapuntuaciones` (
`uuid()` varchar(36)
,`codigoprod` int(11)
,`dniusuario` varchar(20)
,`puntuacion` int(11)
,`nom_prod` varchar(100)
,`img_prod` varchar(20)
,`puntuacion_prod` int(3)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_factura`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_factura` (
`uuid()` varchar(36)
,`cod_fact` int(3)
,`nombreusu` varchar(20)
,`matric_coche` varchar(10)
,`marca_coche` varchar(30)
,`modelo_coche` varchar(30)
,`tipo_cita` varchar(15)
,`descrp_cita` varchar(200)
,`estado_cita` varchar(20)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vistacestacompleta`
--
DROP TABLE IF EXISTS `vistacestacompleta`;

CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`localhost` SQL SECURITY DEFINER VIEW `vistacestacompleta`  AS  select uuid() AS `uuid()`,`cesta`.`dniusuario` AS `dniusuario`,`cesta`.`codproducto` AS `codproducto`,`productos`.`nom_prod` AS `nom_prod`,`productos`.`img_prod` AS `img_prod`,`productos`.`precio_prod` AS `precio_prod`,`cesta`.`unidades_cesta` AS `unidades_cesta`,`cesta`.`totalpreciocesta` AS `totalpreciocesta` from (`cesta` join `productos`) where `cesta`.`codproducto` = `productos`.`cod_prod` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistafacturacompleta`
--
DROP TABLE IF EXISTS `vistafacturacompleta`;

CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`localhost` SQL SECURITY DEFINER VIEW `vistafacturacompleta`  AS  select distinct uuid() AS `uuid()`,`registro_factura`.`cod_producto` AS `cod_producto`,`registro_factura`.`cod_factura` AS `cod_factura`,`productos`.`nom_prod` AS `nom_prod`,`productos`.`precio_prod` AS `precio_prod`,`productos`.`img_prod` AS `img_prod`,`registro_factura`.`total_unidades` AS `total_unidades`,`registro_factura`.`dni_usu` AS `dni_usu`,`facturas`.`fechafinal` AS `fechafinal` from ((`registro_factura` join `productos`) join `facturas`) where `registro_factura`.`cod_producto` = `productos`.`cod_prod` and `registro_factura`.`cod_factura` = `facturas`.`cod_fact` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistapuntuaciones`
--
DROP TABLE IF EXISTS `vistapuntuaciones`;

CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`localhost` SQL SECURITY DEFINER VIEW `vistapuntuaciones`  AS  select distinct uuid() AS `uuid()`,`puntuaciones`.`codigoprod` AS `codigoprod`,`puntuaciones`.`dniusuario` AS `dniusuario`,`puntuaciones`.`puntuacion` AS `puntuacion`,`productos`.`nom_prod` AS `nom_prod`,`productos`.`img_prod` AS `img_prod`,`productos`.`puntuacion_prod` AS `puntuacion_prod` from (`puntuaciones` join `productos`) where `puntuaciones`.`codigoprod` = `productos`.`cod_prod` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_factura`
--
DROP TABLE IF EXISTS `vista_factura`;

CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`localhost` SQL SECURITY DEFINER VIEW `vista_factura`  AS  select uuid() AS `uuid()`,`facturas`.`cod_fact` AS `cod_fact`,`usuario`.`nombreusu` AS `nombreusu`,`citas`.`matric_coche` AS `matric_coche`,`citas`.`marca_coche` AS `marca_coche`,`citas`.`modelo_coche` AS `modelo_coche`,`citas`.`tipo_cita` AS `tipo_cita`,`citas`.`descrp_cita` AS `descrp_cita`,`citas`.`estado_cita` AS `estado_cita` from ((`facturas` join `citas`) join `usuario`) where `facturas`.`dni_cli` = `citas`.`dni_cli` & `citas`.`dni_cli` = `usuario`.`dniusu` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cesta`
--
ALTER TABLE `cesta`
  ADD PRIMARY KEY (`dniusuario`,`codproducto`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`cod_cita`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`cod_fact`);

--
-- Indices de la tabla `partes`
--
ALTER TABLE `partes`
  ADD PRIMARY KEY (`cod_parte`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`cod_prod`);

--
-- Indices de la tabla `puntuaciones`
--
ALTER TABLE `puntuaciones`
  ADD PRIMARY KEY (`codigoprod`,`dniusuario`);

--
-- Indices de la tabla `registro_factura`
--
ALTER TABLE `registro_factura`
  ADD PRIMARY KEY (`cod_reg`);

--
-- Indices de la tabla `suscrip`
--
ALTER TABLE `suscrip`
  ADD PRIMARY KEY (`email_susc`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`dniusu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `cod_cita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `cod_fact` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT de la tabla `partes`
--
ALTER TABLE `partes`
  MODIFY `cod_parte` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `registro_factura`
--
ALTER TABLE `registro_factura`
  MODIFY `cod_reg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
