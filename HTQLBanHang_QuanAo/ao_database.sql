-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 20, 2024 lúc 10:08 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ao_database`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `calam`
--

CREATE TABLE `calam` (
  `maca` varchar(5) NOT NULL,
  `tenca` varchar(10) NOT NULL,
  `thoigianbd` time NOT NULL,
  `thoigiankt` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucnang`
--

CREATE TABLE `chucnang` (
  `machucnang` varchar(5) NOT NULL,
  `tenchucnang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucnang_quyen`
--

CREATE TABLE `chucnang_quyen` (
  `machucnang` varchar(5) NOT NULL,
  `maquyen` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucvu`
--

CREATE TABLE `chucvu` (
  `macv` varchar(5) NOT NULL,
  `tencv` varchar(20) NOT NULL,
  `luongtheogio` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthoadon`
--

CREATE TABLE `cthoadon` (
  `mahd` varchar(5) NOT NULL,
  `masp` varchar(5) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` int(11) NOT NULL,
  `tongtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `mapn` varchar(5) NOT NULL,
  `masp` varchar(5) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gianhap` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giolam`
--

CREATE TABLE `giolam` (
  `manv` varchar(5) NOT NULL,
  `maca` varchar(5) NOT NULL,
  `ngaylam` datetime NOT NULL,
  `giovaolam` time NOT NULL,
  `giotanlam` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` varchar(5) NOT NULL,
  `ngaytao` datetime NOT NULL,
  `thanhtien` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL,
  `maud` varchar(5) NOT NULL,
  `manv` varchar(5) NOT NULL,
  `makh` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` varchar(5) NOT NULL,
  `hodem` varchar(20) NOT NULL,
  `ten` varchar(20) NOT NULL,
  `gioitinh` varchar(5) NOT NULL,
  `sodienthoai` varchar(10) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `makm` varchar(5) NOT NULL,
  `tenkm` varchar(100) NOT NULL,
  `noidung` varchar(100) NOT NULL,
  `ngaybatdau` date NOT NULL,
  `ngayketthuc` date NOT NULL,
  `phantram` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`makm`, `tenkm`, `noidung`, `ngaybatdau`, `ngayketthuc`, `phantram`, `trangthai`) VALUES
('KM001', 'Không khuyến mãi', '', '2000-01-01', '2999-01-01', 10, 1),
('KM002', 'Giảm giá 10%', 'Giảm giá 10% Quốc tế Đàn ông', '2024-11-05', '2024-11-15', 0, 1),
('KM003', 'Giảm giá 20%', 'Giảm giá 20% Ngày Tết', '2024-11-10', '2024-11-20', 20, 1),
('KM004', 'Giảm giá 15% ', 'Giảm giá 15% Quốc tế Phụ nữ', '2024-11-12', '2024-11-25', 15, 1),
('KM005', 'Giảm giá 30%', 'Giảm giá 30% Black Friday', '2024-11-15', '2024-11-30', 30, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaiquanao`
--

CREATE TABLE `loaiquanao` (
  `maloaiquanao` varchar(5) NOT NULL,
  `tenloaiquanao` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `loaiquanao`
--

INSERT INTO `loaiquanao` (`maloaiquanao`, `tenloaiquanao`) VALUES
('LQ001', 'Áo'),
('LQ002', 'Quần'),
('LQ003', 'Váy'),
('LQ004', 'Áo khoác'),
('LQ005', 'Quần short');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `luong`
--

CREATE TABLE `luong` (
  `manv` varchar(5) NOT NULL,
  `tonggiolam` int(11) NOT NULL,
  `tienluong` int(11) NOT NULL,
  `thangtraluong` datetime NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `mancc` varchar(5) NOT NULL,
  `tenncc` varchar(20) NOT NULL,
  `diachi` varchar(30) NOT NULL,
  `sodienthoai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` varchar(5) NOT NULL,
  `honv` varchar(20) NOT NULL,
  `tennv` varchar(20) NOT NULL,
  `gioitinh` varchar(5) NOT NULL,
  `ngaysinh` datetime NOT NULL,
  `cmnd` varchar(15) NOT NULL,
  `sodienthoai` varchar(15) NOT NULL,
  `ngayvaolam` datetime NOT NULL,
  `trangthai` int(11) NOT NULL,
  `chucvu` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `mapn` varchar(5) NOT NULL,
  `ngaytao` datetime NOT NULL,
  `thanhtien` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL,
  `manv` varchar(5) NOT NULL,
  `mancc` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quanao`
--

CREATE TABLE `quanao` (
  `masp` varchar(5) NOT NULL,
  `tensp` varchar(50) NOT NULL,
  `anh` varchar(100) NOT NULL,
  `giaban` int(11) NOT NULL,
  `soluongtonkho` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL,
  `makm` varchar(5) NOT NULL,
  `matheloai` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `quanao`
--

INSERT INTO `quanao` (`masp`, `tensp`, `anh`, `giaban`, `soluongtonkho`, `trangthai`, `makm`, `matheloai`) VALUES
('SP001', 'Áo thun nam cơ bản', 'test.png', 150000, 100, 1, 'KM001', 'TL001'),
('SP002', 'Áo sơ mi nữ trắng', 'image2.jpg', 180000, 80, 1, 'KM002', 'TL002'),
('SP003', 'Quần jean nam xanh', 'image3.jpg', 250000, 150, 1, 'KM003', 'TL003'),
('SP004', 'Quần tây nữ đen', 'image4.jpg', 220000, 120, 1, 'KM004', 'TL004'),
('SP005', 'Váy dạ hội sang trọng', 'image5.jpg', 350000, 50, 1, 'KM005', 'TL005'),
('SP006', 'Áo khoác len nam', 'image6.jpg', 280000, 60, 1, 'KM001', 'TL006'),
('SP007', 'Áo khoác lông nữ', 'image7.jpg', 450000, 40, 1, 'KM002', 'TL007'),
('SP008', 'Quần short thể thao', 'image8.jpg', 130000, 200, 1, 'KM003', 'TL008'),
('SP009', 'Quần short kaki', 'image9.jpg', 170000, 90, 1, 'KM004', 'TL009'),
('SP010', 'Đầm công sở nữ', 'image10.jpg', 220000, 110, 1, 'KM005', 'TL010'),
('SP011', 'Áo thun nam sọc', 'image11.jpg', 160000, 95, 1, 'KM001', 'TL001'),
('SP012', 'Áo sơ mi nữ kẻ', 'image12.jpg', 200000, 85, 1, 'KM002', 'TL002'),
('SP013', 'Quần jean nam rách', 'image13.jpg', 270000, 160, 1, 'KM003', 'TL003'),
('SP014', 'Quần tây nữ sọc', 'image14.jpg', 230000, 130, 1, 'KM004', 'TL004'),
('SP015', 'Váy dạ hội đen', 'image15.jpg', 380000, 55, 1, 'KM005', 'TL005'),
('SP016', 'Áo khoác len nữ', 'image16.jpg', 300000, 65, 1, 'KM001', 'TL006'),
('SP017', 'Áo khoác lông nam', 'image17.jpg', 480000, 45, 1, 'KM002', 'TL007'),
('SP018', 'Quần short thể thao nam', 'image18.jpg', 140000, 210, 1, 'KM003', 'TL008'),
('SP019', 'Quần short kaki nữ', 'image19.jpg', 180000, 100, 1, 'KM004', 'TL009'),
('SP020', 'Đầm công sở công chúa', 'image20.jpg', 240000, 120, 1, 'KM005', 'TL010'),
('SP021', 'Áo thun nam cổ tròn', 'image21.jpg', 155000, 110, 1, 'KM001', 'TL001'),
('SP022', 'Áo sơ mi nữ đen', 'image22.jpg', 190000, 90, 1, 'KM002', 'TL002'),
('SP023', 'Quần jean nam rách nhẹ', 'image23.jpg', 260000, 140, 1, 'KM003', 'TL003'),
('SP024', 'Quần tây nữ xám', 'image24.jpg', 215000, 135, 1, 'KM004', 'TL004'),
('SP025', 'Váy dạ hội đỏ', 'image25.jpg', 340000, 50, 1, 'KM005', 'TL005'),
('SP026', 'Áo khoác len dáng dài', 'image26.jpg', 290000, 70, 1, 'KM001', 'TL006'),
('SP027', 'Áo khoác lông nữ ấm', 'image27.jpg', 460000, 40, 1, 'KM002', 'TL007'),
('SP028', 'Quần short thể thao nữ', 'image28.jpg', 135000, 205, 1, 'KM003', 'TL008'),
('SP029', 'Quần short kaki nam', 'image29.jpg', 165000, 95, 1, 'KM004', 'TL009'),
('SP030', 'hiiiiiiiiiiiii', 'add.png', 0, 0, 1, 'KM001', 'TL001'),
('SP031', 'hi', '', 0, 0, 1, 'KM001', 'TL001'),
('SP032', 'hiiiii', '', 0, 0, 1, 'KM001', 'TL001');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quyen`
--

CREATE TABLE `quyen` (
  `maquyen` varchar(5) NOT NULL,
  `tenquyen` varchar(20) NOT NULL,
  `manv` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `manv` varchar(5) NOT NULL,
  `tendangnhap` varchar(20) NOT NULL,
  `matkhau` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `matheloai` varchar(5) NOT NULL,
  `tentheloai` varchar(40) NOT NULL,
  `maloaiquanao` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`matheloai`, `tentheloai`, `maloaiquanao`) VALUES
('TL001', 'Áo thun nam', 'LQ001'),
('TL002', 'Áo sơ mi nữ', 'LQ001'),
('TL003', 'Quần jean nam', 'LQ002'),
('TL004', 'Quần tây nữ', 'LQ002'),
('TL005', 'Váy dạ hội', 'LQ003'),
('TL006', 'Áo khoác len', 'LQ004'),
('TL007', 'Áo khoác lông', 'LQ004'),
('TL008', 'Quần short thể thao', 'LQ005'),
('TL009', 'Quần short kaki', 'LQ005'),
('TL010', 'Đầm công sở', 'LQ003');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `uudai`
--

CREATE TABLE `uudai` (
  `maud` varchar(5) NOT NULL,
  `tenud` varchar(30) NOT NULL,
  `dieukien` int(11) NOT NULL,
  `phantram` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `calam`
--
ALTER TABLE `calam`
  ADD PRIMARY KEY (`maca`);

--
-- Chỉ mục cho bảng `chucnang`
--
ALTER TABLE `chucnang`
  ADD PRIMARY KEY (`machucnang`);

--
-- Chỉ mục cho bảng `chucnang_quyen`
--
ALTER TABLE `chucnang_quyen`
  ADD KEY `machucnang` (`machucnang`,`maquyen`),
  ADD KEY `maquyen` (`maquyen`);

--
-- Chỉ mục cho bảng `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`macv`);

--
-- Chỉ mục cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD KEY `mahd` (`mahd`,`masp`),
  ADD KEY `masp` (`masp`);

--
-- Chỉ mục cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD KEY `masp` (`masp`),
  ADD KEY `mapn` (`mapn`);

--
-- Chỉ mục cho bảng `giolam`
--
ALTER TABLE `giolam`
  ADD KEY `manv` (`manv`),
  ADD KEY `maca` (`maca`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`),
  ADD KEY `maud` (`maud`,`manv`,`makh`),
  ADD KEY `manv` (`manv`),
  ADD KEY `makh` (`makh`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`makm`);

--
-- Chỉ mục cho bảng `loaiquanao`
--
ALTER TABLE `loaiquanao`
  ADD PRIMARY KEY (`maloaiquanao`);

--
-- Chỉ mục cho bảng `luong`
--
ALTER TABLE `luong`
  ADD KEY `manv` (`manv`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`mancc`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`),
  ADD KEY `chucvu` (`chucvu`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`mapn`),
  ADD KEY `manv` (`manv`,`mancc`),
  ADD KEY `mancc` (`mancc`);

--
-- Chỉ mục cho bảng `quanao`
--
ALTER TABLE `quanao`
  ADD PRIMARY KEY (`masp`),
  ADD KEY `maloaiquanao` (`makm`),
  ADD KEY `fk_matheloai_quanao` (`matheloai`);

--
-- Chỉ mục cho bảng `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`maquyen`),
  ADD KEY `manv` (`manv`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD KEY `manv` (`manv`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`matheloai`),
  ADD KEY `maloaiquanao` (`maloaiquanao`);

--
-- Chỉ mục cho bảng `uudai`
--
ALTER TABLE `uudai`
  ADD PRIMARY KEY (`maud`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chucnang_quyen`
--
ALTER TABLE `chucnang_quyen`
  ADD CONSTRAINT `chucnang_quyen_ibfk_1` FOREIGN KEY (`maquyen`) REFERENCES `quyen` (`maquyen`),
  ADD CONSTRAINT `chucnang_quyen_ibfk_2` FOREIGN KEY (`machucnang`) REFERENCES `chucnang` (`machucnang`);

--
-- Các ràng buộc cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`mahd`) REFERENCES `hoadon` (`mahd`),
  ADD CONSTRAINT `cthoadon_ibfk_2` FOREIGN KEY (`masp`) REFERENCES `quanao` (`masp`);

--
-- Các ràng buộc cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`masp`) REFERENCES `quanao` (`masp`),
  ADD CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`mapn`) REFERENCES `phieunhap` (`mapn`);

--
-- Các ràng buộc cho bảng `giolam`
--
ALTER TABLE `giolam`
  ADD CONSTRAINT `giolam_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  ADD CONSTRAINT `giolam_ibfk_2` FOREIGN KEY (`maca`) REFERENCES `calam` (`maca`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`maud`) REFERENCES `uudai` (`maud`);

--
-- Các ràng buộc cho bảng `luong`
--
ALTER TABLE `luong`
  ADD CONSTRAINT `luong_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`chucvu`) REFERENCES `chucvu` (`macv`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`);

--
-- Các ràng buộc cho bảng `quanao`
--
ALTER TABLE `quanao`
  ADD CONSTRAINT `fk_matheloai_quanao` FOREIGN KEY (`matheloai`) REFERENCES `theloai` (`matheloai`),
  ADD CONSTRAINT `quanao_ibfk_2` FOREIGN KEY (`makm`) REFERENCES `khuyenmai` (`makm`);

--
-- Các ràng buộc cho bảng `quyen`
--
ALTER TABLE `quyen`
  ADD CONSTRAINT `quyen_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `taikhoan` (`manv`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Các ràng buộc cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD CONSTRAINT `fk_maloaiquanao` FOREIGN KEY (`maloaiquanao`) REFERENCES `loaiquanao` (`maloaiquanao`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
