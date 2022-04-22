-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.7.3-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- instagram 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `instagram` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `instagram`;

-- 테이블 instagram.user_mst 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_mst` (
  `usercode` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`usercode`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 instagram.user_mst:~10 rows (대략적) 내보내기
DELETE FROM `user_mst`;
/*!40000 ALTER TABLE `user_mst` DISABLE KEYS */;
INSERT INTO `user_mst` (`usercode`, `phone`, `email`, `name`, `username`, `password`, `create_date`, `update_date`) VALUES
	(1, '111', 'dd@dd.com', '강민', 'aaa', '1234', '2022-04-21 12:38:28', '2022-04-21 12:38:28'),
	(2, '010-2222-3333', NULL, '강', 'bbb', '1234', '2022-04-22 10:20:05', '2022-04-22 10:20:05'),
	(3, NULL, 'aaa@bbb.com', '강', 'ccc', '1234', '2022-04-22 10:22:01', '2022-04-22 10:22:01'),
	(4, 'ddd', NULL, 'ddd', 'asas', 'ddd', '2022-04-22 10:28:16', '2022-04-22 10:28:16'),
	(5, 'aaa', NULL, 'sss', 'aaasa', 'sss', '2022-04-22 10:33:50', '2022-04-22 10:33:50'),
	(6, 'sdsd', NULL, 'dsds', 'dssd', 'sdsd', '2022-04-22 10:44:51', '2022-04-22 10:44:51'),
	(7, 'sdf', NULL, 'sdf', 'sdfsdfsdf', '$2a$10$nKLCIdJUfteU3krXwSJPo.CTUB7b78O1Spqg6UFM2Oo0sLZzTawGi', '2022-04-22 11:20:03', '2022-04-22 11:20:03'),
	(8, 'dsf', NULL, 'sdf', 'asas1', '$2a$10$Lr0JA/wP96hrQEgOynRsyeNB.JLUS/S6RoeGukbDM2HxnYSeZEun6', '2022-04-22 11:20:31', '2022-04-22 11:20:31'),
	(9, 'sd', NULL, 'dsf', 'weq', '$2a$10$1OAgaMNBZNJrYTdJEszuO.k81tfataDDL8RfL1MBM8Ke3u2QXDIpa', '2022-04-22 11:20:50', '2022-04-22 11:20:50'),
	(10, 'ds', NULL, 'fds', 'ggg', '$2a$10$p4WprAcjE22is96mwpWoGOQuBZfavkcnE517Cozx0Uea/.So7VwIO', '2022-04-22 12:56:54', '2022-04-22 12:56:54');
/*!40000 ALTER TABLE `user_mst` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
