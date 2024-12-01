-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: ao_database
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calam`
--

DROP TABLE IF EXISTS `calam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calam` (
  `maca` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tenca` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `thoigianbd` time NOT NULL,
  `thoigiankt` time NOT NULL,
  PRIMARY KEY (`maca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calam`
--

LOCK TABLES `calam` WRITE;
/*!40000 ALTER TABLE `calam` DISABLE KEYS */;
/*!40000 ALTER TABLE `calam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucnang`
--

DROP TABLE IF EXISTS `chucnang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucnang` (
  `machucnang` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tenchucnang` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`machucnang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucnang`
--

LOCK TABLES `chucnang` WRITE;
/*!40000 ALTER TABLE `chucnang` DISABLE KEYS */;
INSERT INTO `chucnang` VALUES ('CN001','Quản lý tài khoản'),('CN002','Quản lý sản phẩm'),('CN003','Quản lý phân quyền'),('CN004','Quản lý ưu đãi'),('CN005','Quản lý nhân viên'),('CN006','Quản lý ca làm'),('CN007','Quản lý phiếu nhập'),('CN008','Quản lý hóa đơn'),('CN009','Quản lý thống kê'),('CN010','Quản lý nhà cung cấp'),('CN011','Quản lý khách hàng');
/*!40000 ALTER TABLE `chucnang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucnang_quyen`
--

DROP TABLE IF EXISTS `chucnang_quyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucnang_quyen` (
  `machucnang` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `maquyen` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  KEY `machucnang` (`machucnang`,`maquyen`),
  KEY `maquyen` (`maquyen`),
  CONSTRAINT `chucnang_quyen_ibfk_1` FOREIGN KEY (`maquyen`) REFERENCES `quyen` (`maquyen`),
  CONSTRAINT `chucnang_quyen_ibfk_2` FOREIGN KEY (`machucnang`) REFERENCES `chucnang` (`machucnang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucnang_quyen`
--

LOCK TABLES `chucnang_quyen` WRITE;
/*!40000 ALTER TABLE `chucnang_quyen` DISABLE KEYS */;
INSERT INTO `chucnang_quyen` VALUES ('CN001','Q001'),('CN001','Q002'),('CN002','Q001'),('CN002','Q002'),('CN002','Q003'),('CN003','Q001'),('CN004','Q001'),('CN004','Q002'),('CN004','Q003'),('CN005','Q001'),('CN005','Q002'),('CN006','Q001'),('CN006','Q002'),('CN007','Q001'),('CN007','Q002'),('CN007','Q003'),('CN008','Q001'),('CN008','Q002'),('CN008','Q003'),('CN009','Q001'),('CN009','Q002'),('CN009','Q003'),('CN010','Q001'),('CN010','Q002'),('CN010','Q003'),('CN011','Q001'),('CN011','Q002'),('CN011','Q003');
/*!40000 ALTER TABLE `chucnang_quyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucvu` (
  `macv` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `tencv` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `luongtheogio` int NOT NULL,
  PRIMARY KEY (`macv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES ('ADMIN','Quản lý toàn hệ thống',100000),('EMPLOYEE','Nhân viên',5000);
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cthoadon`
--

DROP TABLE IF EXISTS `cthoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cthoadon` (
  `mahd` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `masp` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `soluong` int NOT NULL,
  `dongia` int NOT NULL,
  `tongtien` int NOT NULL,
  KEY `mahd` (`mahd`,`masp`),
  KEY `masp` (`masp`),
  CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`mahd`) REFERENCES `hoadon` (`mahd`),
  CONSTRAINT `cthoadon_ibfk_2` FOREIGN KEY (`masp`) REFERENCES `quanao` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cthoadon`
--

LOCK TABLES `cthoadon` WRITE;
/*!40000 ALTER TABLE `cthoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `cthoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctphieunhap`
--

DROP TABLE IF EXISTS `ctphieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ctphieunhap` (
  `mapn` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `masp` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `soluong` int NOT NULL,
  `gianhap` int NOT NULL,
  KEY `masp` (`masp`),
  KEY `mapn` (`mapn`),
  CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`masp`) REFERENCES `quanao` (`masp`),
  CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`mapn`) REFERENCES `phieunhap` (`mapn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctphieunhap`
--

LOCK TABLES `ctphieunhap` WRITE;
/*!40000 ALTER TABLE `ctphieunhap` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctphieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giolam`
--

DROP TABLE IF EXISTS `giolam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giolam` (
  `manv` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `maca` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `ngaylam` datetime NOT NULL,
  `giovaolam` time NOT NULL,
  `giotanlam` time NOT NULL,
  KEY `manv` (`manv`),
  KEY `maca` (`maca`),
  CONSTRAINT `giolam_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  CONSTRAINT `giolam_ibfk_2` FOREIGN KEY (`maca`) REFERENCES `calam` (`maca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giolam`
--

LOCK TABLES `giolam` WRITE;
/*!40000 ALTER TABLE `giolam` DISABLE KEYS */;
/*!40000 ALTER TABLE `giolam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `mahd` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `ngaytao` datetime NOT NULL,
  `thanhtien` int NOT NULL,
  `trangthai` int NOT NULL,
  `maud` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `manv` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `makh` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`mahd`),
  KEY `maud` (`maud`,`manv`,`makh`),
  KEY `manv` (`manv`),
  KEY `makh` (`makh`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`),
  CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`maud`) REFERENCES `uudai` (`maud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `makh` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `hodem` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `ten` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `gioitinh` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `sodienthoai` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `trangthai` int NOT NULL,
  PRIMARY KEY (`makh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuyenmai` (
  `makm` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tenkm` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `noidung` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `ngaybatdau` date NOT NULL,
  `ngayketthuc` date NOT NULL,
  `phantram` int NOT NULL,
  `trangthai` int NOT NULL,
  PRIMARY KEY (`makm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
INSERT INTO `khuyenmai` VALUES ('KM001','Không khuyến mãi','','2000-01-01','2999-01-01',10,1),('KM002','Giảm giá 10%','Giảm giá 10% Quốc tế Đàn ông','2024-11-05','2024-11-15',0,1),('KM003','Giảm giá 20%','Giảm giá 20% Ngày Tết','2024-11-10','2024-11-20',20,1),('KM004','Giảm giá 15% ','Giảm giá 15% Quốc tế Phụ nữ','2024-11-12','2024-11-25',15,1),('KM005','Giảm giá 30%','Giảm giá 30% Black Friday','2024-11-15','2024-11-30',30,1);
/*!40000 ALTER TABLE `khuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaiquanao`
--

DROP TABLE IF EXISTS `loaiquanao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaiquanao` (
  `maloaiquanao` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tenloaiquanao` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`maloaiquanao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaiquanao`
--

LOCK TABLES `loaiquanao` WRITE;
/*!40000 ALTER TABLE `loaiquanao` DISABLE KEYS */;
INSERT INTO `loaiquanao` VALUES ('LQ001','Áo'),('LQ002','Quần'),('LQ003','Váy'),('LQ004','Áo khoác'),('LQ005','Quần short');
/*!40000 ALTER TABLE `loaiquanao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luong`
--

DROP TABLE IF EXISTS `luong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luong` (
  `manv` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tonggiolam` int NOT NULL,
  `tienluong` int NOT NULL,
  `thangtraluong` datetime NOT NULL,
  `trangthai` int NOT NULL,
  KEY `manv` (`manv`),
  CONSTRAINT `luong_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luong`
--

LOCK TABLES `luong` WRITE;
/*!40000 ALTER TABLE `luong` DISABLE KEYS */;
/*!40000 ALTER TABLE `luong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `mancc` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tenncc` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `diachi` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `sodienthoai` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`mancc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `manv` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `honv` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `tennv` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `gioitinh` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `ngaysinh` datetime NOT NULL,
  `cmnd` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `sodienthoai` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `ngayvaolam` datetime NOT NULL,
  `trangthai` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `chucvu` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`manv`),
  KEY `chucvu` (`chucvu`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`chucvu`) REFERENCES `chucvu` (`macv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('NV000','Bùi Hữu','Luân','Nam','2003-10-14 00:00:00','083203011574','0878678691','huuluan11203@gmail.com','2024-11-24 22:43:18','ACTIVE','ADMIN'),('NV001','Luân','Hữu','Nam','2003-10-14 00:00:00','083203011575','0878678692','huuluan11203@gmail.com','2024-11-30 00:39:18','ACTIVE','EMPLOYEE');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `mapn` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `ngaytao` datetime NOT NULL,
  `thanhtien` int NOT NULL,
  `trangthai` int NOT NULL,
  `manv` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `mancc` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`mapn`),
  KEY `manv` (`manv`,`mancc`),
  KEY `mancc` (`mancc`),
  CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quanao`
--

DROP TABLE IF EXISTS `quanao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quanao` (
  `masp` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tensp` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `anh` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `giaban` int NOT NULL,
  `soluongtonkho` int NOT NULL,
  `trangthai` int NOT NULL,
  `makm` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `matheloai` varchar(5) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`masp`),
  KEY `maloaiquanao` (`makm`),
  KEY `fk_matheloai_quanao` (`matheloai`),
  CONSTRAINT `fk_matheloai_quanao` FOREIGN KEY (`matheloai`) REFERENCES `theloai` (`matheloai`),
  CONSTRAINT `quanao_ibfk_2` FOREIGN KEY (`makm`) REFERENCES `khuyenmai` (`makm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quanao`
--

LOCK TABLES `quanao` WRITE;
/*!40000 ALTER TABLE `quanao` DISABLE KEYS */;
INSERT INTO `quanao` VALUES ('SP001','Áo thun nam cơ bản','test.png',150000,100,1,'KM001','TL001'),('SP002','Áo sơ mi nữ trắng','image2.jpg',180000,80,1,'KM002','TL002'),('SP003','Quần jean nam xanh','image3.jpg',250000,150,0,'KM003','TL003'),('SP004','Quần tây nữ đen','image4.jpg',220000,120,1,'KM004','TL004'),('SP005','Váy dạ hội sang trọng','image5.jpg',350000,50,0,'KM005','TL005'),('SP006','Áo khoác len nam','image6.jpg',280000,60,0,'KM001','TL006'),('SP007','Áo khoác lông nữ','image7.jpg',450000,40,1,'KM002','TL007'),('SP008','Quần short thể thao','image8.jpg',130000,200,1,'KM003','TL008'),('SP009','Quần short kaki','image9.jpg',170000,90,1,'KM004','TL009'),('SP010','Đầm công sở nữ','image10.jpg',220000,110,1,'KM005','TL010'),('SP011','Áo thun nam sọc','image11.jpg',160000,95,1,'KM001','TL001'),('SP012','Áo sơ mi nữ kẻ','image12.jpg',200000,85,1,'KM002','TL002'),('SP013','Quần jean nam rách','image13.jpg',270000,160,1,'KM003','TL003'),('SP014','Quần tây nữ sọc','image14.jpg',230000,130,1,'KM004','TL004'),('SP015','Váy dạ hội đen','image15.jpg',380000,55,1,'KM005','TL005'),('SP016','Áo khoác len nữ','image16.jpg',300000,65,1,'KM001','TL006'),('SP017','Áo khoác lông nam','image17.jpg',480000,45,1,'KM002','TL007'),('SP018','Quần short thể thao nam','image18.jpg',140000,210,1,'KM003','TL008'),('SP019','Quần short kaki nữ','image19.jpg',180000,100,1,'KM004','TL009'),('SP020','Đầm công sở công chúa','image20.jpg',240000,120,1,'KM005','TL010'),('SP021','Áo thun nam cổ tròn','image21.jpg',155000,110,1,'KM001','TL001'),('SP022','Áo sơ mi nữ đen','image22.jpg',190000,90,0,'KM002','TL002'),('SP023','Quần jean nam rách nhẹ','image23.jpg',260000,140,1,'KM003','TL003'),('SP024','Quần tây nữ xám','image24.jpg',215000,135,1,'KM004','TL004'),('SP025','Váy dạ hội đỏ','image25.jpg',340000,50,1,'KM005','TL005'),('SP026','Áo khoác len dáng dài','image26.jpg',290000,70,1,'KM001','TL006'),('SP027','Áo khoác lông nữ ấm','image27.jpg',460000,40,1,'KM002','TL007'),('SP028','Quần short thể thao nữ','image28.jpg',135000,205,1,'KM003','TL008'),('SP029','Quần short kaki nam','image29.jpg',165000,95,1,'KM004','TL009'),('SP030','hiiiiiiiiiiiii','add.png',0,0,1,'KM001','TL001'),('SP031','hi','',0,0,1,'KM001','TL001'),('SP032','hiiiii','',0,0,1,'KM001','TL001');
/*!40000 ALTER TABLE `quanao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quyen`
--

DROP TABLE IF EXISTS `quyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quyen` (
  `maquyen` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tenquyen` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`maquyen`),
  UNIQUE KEY `tenquyen_UNIQUE` (`tenquyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quyen`
--

LOCK TABLES `quyen` WRITE;
/*!40000 ALTER TABLE `quyen` DISABLE KEYS */;
INSERT INTO `quyen` VALUES ('Q001','Admin'),('Q003','Employee'),('Q002','Manager');
/*!40000 ALTER TABLE `quyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `manv` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tendangnhap` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `matkhau` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `maquyen` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`manv`),
  KEY `manv` (`manv`),
  KEY `fk_taikhoan_quyen` (`maquyen`),
  CONSTRAINT `fk_taikhoan_quyen` FOREIGN KEY (`maquyen`) REFERENCES `quyen` (`maquyen`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('NV000','NV000','$2a$10$jbm9grFGxoUEUsmoyjYqjePr2KS8CK3Q7AiVS49HYHhrTopPG4vWO','Q001'),('NV001','NV001','$2a$10$O22Saj15hMdOGLFd.hHlBeI2bd4bUC4CfHgDhT/0Wv.R9mXo2Wpnm','Q003');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theloai`
--

DROP TABLE IF EXISTS `theloai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theloai` (
  `matheloai` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tentheloai` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `maloaiquanao` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`matheloai`),
  KEY `maloaiquanao` (`maloaiquanao`),
  CONSTRAINT `fk_maloaiquanao` FOREIGN KEY (`maloaiquanao`) REFERENCES `loaiquanao` (`maloaiquanao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theloai`
--

LOCK TABLES `theloai` WRITE;
/*!40000 ALTER TABLE `theloai` DISABLE KEYS */;
INSERT INTO `theloai` VALUES ('TL001','Áo thun nam','LQ001'),('TL002','Áo sơ mi nữ','LQ001'),('TL003','Quần jean nam','LQ002'),('TL004','Quần tây nữ','LQ002'),('TL005','Váy dạ hội','LQ003'),('TL006','Áo khoác len','LQ004'),('TL007','Áo khoác lông','LQ004'),('TL008','Quần short thể thao','LQ005'),('TL009','Quần short kaki','LQ005'),('TL010','Đầm công sở','LQ003');
/*!40000 ALTER TABLE `theloai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uudai`
--

DROP TABLE IF EXISTS `uudai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uudai` (
  `maud` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `tenud` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `dieukien` int NOT NULL,
  `phantram` int NOT NULL,
  `trangthai` int NOT NULL,
  PRIMARY KEY (`maud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uudai`
--

LOCK TABLES `uudai` WRITE;
/*!40000 ALTER TABLE `uudai` DISABLE KEYS */;
/*!40000 ALTER TABLE `uudai` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-02  1:03:39
