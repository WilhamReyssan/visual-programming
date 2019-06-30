-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2019 at 09:41 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spp`
--

-- --------------------------------------------------------

--
-- Table structure for table `bulan`
--

CREATE TABLE `bulan` (
  `id_s` int(10) NOT NULL,
  `januari` varchar(5) DEFAULT NULL,
  `februari` varchar(5) DEFAULT NULL,
  `maret` varchar(5) DEFAULT NULL,
  `april` varchar(5) DEFAULT NULL,
  `mei` varchar(5) DEFAULT NULL,
  `juni` varchar(5) DEFAULT NULL,
  `juli` varchar(5) DEFAULT NULL,
  `agustus` varchar(5) DEFAULT NULL,
  `september` varchar(5) DEFAULT NULL,
  `oktober` varchar(5) DEFAULT NULL,
  `november` varchar(5) DEFAULT NULL,
  `desember` varchar(5) DEFAULT NULL,
  `thn_ajr` varchar(12) DEFAULT NULL,
  `nis` int(10) DEFAULT NULL,
  `tunggak` varchar(25) DEFAULT NULL,
  `bln` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bulan`
--

INSERT INTO `bulan` (`id_s`, `januari`, `februari`, `maret`, `april`, `mei`, `juni`, `juli`, `agustus`, `september`, `oktober`, `november`, `desember`, `thn_ajr`, `nis`, `tunggak`, `bln`) VALUES
(1277, 'lunas', 'lunas', 'lunas', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2020/2021', 1, 'Rp.450.000,00', 'april, mei, juni, juli, agustus, september, oktober, november, desember '),
(1278, '-', 'lunas', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2019/2020', 1, 'Rp.550.000,00', 'januari, maret, april, mei, juni, juli, agustus, september, oktober, november, desember '),
(1279, 'lunas', 'lunas', 'lunas', 'lunas', '-', '-', '-', '-', '-', '-', '-', '-', '2020/2021', 6, 'Rp.800.000,00', 'mei, juni, juli, agustus, september, oktober, november, desember '),
(1280, 'lunas', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2019/2020', 6, 'Rp.1.100.000,00', 'februari, maret, april, mei, juni, juli, agustus, september, oktober, november, desember '),
(1281, 'lunas', 'lunas', '-', 'lunas', 'lunas', '-', '-', '-', '-', '-', '-', '-', '2020/2021', 19321, 'Rp.800.000,00', 'maret, juni, juli, agustus, september, oktober, november, desember '),
(1282, 'lunas', 'lunas', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2020/2021', 99, 'Rp.1.000.000,00', 'maret, april, mei, juni, juli, agustus, september, oktober, november, desember '),
(1283, 'lunas', 'lunas', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2020/2021', 88, 'Rp.1.000.000,00', 'maret, april, mei, juni, juli, agustus, september, oktober, november, desember ');

-- --------------------------------------------------------

--
-- Table structure for table `datatransaksi`
--

CREATE TABLE `datatransaksi` (
  `biaya` varchar(15) DEFAULT NULL,
  `thn_ajar` varchar(20) NOT NULL,
  `pt_anak_guru` varchar(15) DEFAULT NULL,
  `pt_KIP` varchar(15) DEFAULT NULL,
  `pt_tahfidz2` varchar(15) DEFAULT NULL,
  `pt_tahfidz3` varchar(15) DEFAULT NULL,
  `pt_tahfidz` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datatransaksi`
--

INSERT INTO `datatransaksi` (`biaya`, `thn_ajar`, `pt_anak_guru`, `pt_KIP`, `pt_tahfidz2`, `pt_tahfidz3`, `pt_tahfidz`) VALUES
('100000', '2020/2021', '50000', '20000', '50000', '30000', '100000');

-- --------------------------------------------------------

--
-- Table structure for table `dropdown`
--

CREATE TABLE `dropdown` (
  `tahun_ajar` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dropdown`
--

INSERT INTO `dropdown` (`tahun_ajar`) VALUES
('2019/2020'),
('2023/2024'),
('2020/2021'),
('2024/2025');

-- --------------------------------------------------------

--
-- Table structure for table `password`
--

CREATE TABLE `password` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nama_admin` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `password`
--

INSERT INTO `password` (`username`, `password`, `nama_admin`) VALUES
('admin', 'admin', 'Wilham');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_bayar` int(10) NOT NULL,
  `tglbayar` date DEFAULT NULL,
  `nis` int(10) DEFAULT NULL,
  `byr` varchar(20) DEFAULT NULL,
  `tahun_ajar` varchar(12) DEFAULT NULL,
  `bulan_Bayar` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_bayar`, `tglbayar`, `nis`, `byr`, `tahun_ajar`, `bulan_Bayar`) VALUES
(57, '2019-06-29', 99, 'Rp.200.000,00', '2020/2021', 'januari, februari, '),
(58, '2019-06-29', 88, 'Rp.200.000,00', '2020/2021', 'januari, februari, ');

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `nis` int(20) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `kelamin` varchar(1) DEFAULT NULL,
  `kelas` varchar(20) DEFAULT NULL,
  `angkatan` varchar(15) DEFAULT NULL,
  `alamat` varchar(30) DEFAULT NULL,
  `hp` varchar(12) DEFAULT NULL,
  `status` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `kelamin`, `kelas`, `angkatan`, `alamat`, `hp`, `status`) VALUES
(88, 'budi', 'L', 'X IPA 1', '45', 'mataram', '087876678876', 'Reguler'),
(99, 'budi doremi', 'L', 'X IPA 1', '15', 'mataram', '081987789666', 'Reguler'),
(123, 'wawa', 'L', 'X IPA', '43', 'mataram', '089', 'KIP'),
(9090, 'boy', 'L', 'X IPS 2', '24', 'mataram', '089887938888', 'Tahfidz 3'),
(19321, 'Wirayadi Praja', 'L', 'X IPA 4', '23', 'Montong', '085675342121', 'Reguler'),
(19322, 'Kusnaidi', 'L', 'X IPA 4', '23', 'Gerung', '085674836498', 'Anak Guru'),
(19323, 'Imelda Jumelia', 'P', 'X IPA 4', '23', 'Ampenan', '081345645687', 'KIP'),
(19324, 'Giban Samawi', 'L', 'X IPA 4', '23', 'Cakranegara', '081786748572', 'Tahfidz 1'),
(19325, 'Rofiqul Achmad', 'L', 'X IPA 4', '23', 'Batu Layar', '085673946124', 'Reguler'),
(19334, 'Hana Maulina', 'P', 'XI IPA 4', '25', 'mataram', '81997845776', 'Reguler'),
(19335, 'Vera Hutami', 'P', 'XI IPA 4', '25', 'mataram', '82557493445', 'Reguler'),
(20123, 'budi', 'L', 'X IPA 1', '25', 'MATARAM', '0819999999', 'Reguler');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bulan`
--
ALTER TABLE `bulan`
  ADD PRIMARY KEY (`id_s`);

--
-- Indexes for table `datatransaksi`
--
ALTER TABLE `datatransaksi`
  ADD PRIMARY KEY (`thn_ajar`);

--
-- Indexes for table `password`
--
ALTER TABLE `password`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_bayar`),
  ADD KEY `nis` (`nis`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bulan`
--
ALTER TABLE `bulan`
  MODIFY `id_s` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1284;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_bayar` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_2` FOREIGN KEY (`nis`) REFERENCES `siswa` (`nis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
