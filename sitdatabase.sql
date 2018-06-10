-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-06-2018 a las 15:18:29
-- Versión del servidor: 10.1.32-MariaDB
-- Versión de PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sitdatabase`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coordinador`
--

CREATE TABLE `coordinador` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoPaterno` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoMaterno` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `coordinador`
--

INSERT INTO `coordinador` (`idUsuario`, `nombre`, `apellidoPaterno`, `apellidoMaterno`) VALUES
(1, 'Edson Neftali', 'Melgarejo', 'Morales');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE `periodo` (
  `idPeriodo` int(11) NOT NULL,
  `periodo` varchar(17) COLLATE utf8_spanish_ci NOT NULL,
  `matriculaTutorado` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `idTutor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `periodo`
--

INSERT INTO `periodo` (`idPeriodo`, `periodo`, `matriculaTutorado`, `idTutor`) VALUES
(1, '02/2018 - 06/2018', 'S15011626', 3),
(2, '02/2018 - 06/2018', 'S12251425', 3),
(3, '02/2018 - 06/2018', 'S13145698', 3),
(4, '02/2018 - 06/2018', 'S15265478', 3),
(5, '02/2018 - 06/2018', 'S15020456', 3),
(6, '02/2018 - 06/2018', 'S15012615', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo_tutoria`
--

CREATE TABLE `periodo_tutoria` (
  `idPeriodo` int(11) NOT NULL,
  `idTutoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `periodo_tutoria`
--

INSERT INTO `periodo_tutoria` (`idPeriodo`, `idTutoria`) VALUES
(1, 1),
(2, 2),
(1, 3),
(1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `problema`
--

CREATE TABLE `problema` (
  `idProblema` int(11) NOT NULL,
  `tipoProblema` int(11) NOT NULL,
  `depto_servicio` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `experienciaEducativa` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `profesor` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcionProblema` text COLLATE utf8_spanish_ci NOT NULL,
  `numAlumnos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `problema`
--

INSERT INTO `problema` (`idProblema`, `tipoProblema`, `depto_servicio`, `experienciaEducativa`, `profesor`, `descripcionProblema`, `numAlumnos`) VALUES
(1, 0, NULL, 'Redes', 'Pancho Pancracio', 'El profesor de la EE no envio calificación a tiempo', 0),
(2, 0, NULL, 'Paradigmas', 'Javier Limon', 'El profesor de la EE no va a clases', 0),
(3, 1, 'Secretaría Academica', NULL, NULL, 'La secretaria no quiso atender al alumno', 0),
(4, 1, 'Cafeteria', NULL, NULL, 'La cafeteria nunca esta abierta', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutor`
--

CREATE TABLE `tutor` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoPaterno` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoMaterno` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoProfesor` int(11) NOT NULL,
  `disponibilidad` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tutor`
--

INSERT INTO `tutor` (`idUsuario`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `tipoProfesor`, `disponibilidad`) VALUES
(3, 'Edson Neftali', 'Melgarejo', 'Morales', 1, 1),
(2, 'Jose Rodrigo', 'Ordoñes', 'Pacheco', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutorado`
--

CREATE TABLE `tutorado` (
  `matricula` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoPaterno` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoMaterno` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `carrera` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `semestre` int(11) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tutorado`
--

INSERT INTO `tutorado` (`matricula`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `carrera`, `semestre`, `estado`) VALUES
('S12251425', 'Alicia', 'Torres', 'Rojas', 'Ingeniería de Software', 4, 1),
('S13145698', 'Alin Itzel', 'Trejo', 'Cañas', 'Ingeniería de Software', 2, 1),
('S15011626', 'Edson', 'Melgarejo', 'Morales', 'Ingeniería de Software', 6, 1),
('S15012615', 'Juan', 'Perez', 'Sanchez', 'Ingeniería de Software', 2, 1),
('S15020456', 'Mahat', 'Melgarejo', 'Morales', 'Ingeniería de Software', 1, 1),
('S15265478', 'Luz del Carmen', 'Jimenez', 'Perez', 'Ingeniería de Software', 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutoria`
--

CREATE TABLE `tutoria` (
  `idTutoria` int(11) NOT NULL,
  `fechaTutoria` date NOT NULL,
  `numeroSesion` int(11) NOT NULL,
  `comentario` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tutoria`
--

INSERT INTO `tutoria` (`idTutoria`, `fechaTutoria`, `numeroSesion`, `comentario`) VALUES
(1, '2018-06-08', 1, 'sin comentarios'),
(2, '2018-06-08', 1, 'comentario 1'),
(3, '2018-06-08', 1, 'no hay comentarios'),
(4, '2018-06-08', 1, 'sesion 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutoria_problema`
--

CREATE TABLE `tutoria_problema` (
  `idTutoria` int(11) NOT NULL,
  `idProblema` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `tipoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreUsuario`, `password`, `tipoUsuario`) VALUES
(1, 'EdsonM', '123456', 1),
(2, 'RodrigoO', '12345', 2),
(3, 'NeftaliM', '123456', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`idPeriodo`);

--
-- Indices de la tabla `problema`
--
ALTER TABLE `problema`
  ADD PRIMARY KEY (`idProblema`);

--
-- Indices de la tabla `tutorado`
--
ALTER TABLE `tutorado`
  ADD PRIMARY KEY (`matricula`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `periodo`
--
ALTER TABLE `periodo`
  MODIFY `idPeriodo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `problema`
--
ALTER TABLE `problema`
  MODIFY `idProblema` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
