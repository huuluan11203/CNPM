/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhuyenMaiDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhuyenMaiDAO {
    private Connection conn;

    public KhuyenMaiDAO() {
        ConnectDB connectDB = new ConnectDB();
        if (connectDB.openConnectDB()) {
            this.conn = connectDB.conn;
        } else {
            this.conn = null;
            System.out.println("Failed to connect to database");
        }
    }

    // Thêm khuyến mãi mới vào cơ sở dữ liệu
    public boolean addKhuyenMai(KhuyenMaiDTO khuyenMai) {
        String sql = "INSERT INTO khuyenmai (makm, tenkm, noidung, ngaybatdau, ngayketthuc, phantram, trangthai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, khuyenMai.getMakm());
            ps.setString(2, khuyenMai.getTenkm());
            ps.setString(3, khuyenMai.getNoidung());
            ps.setDate(4, new java.sql.Date(khuyenMai.getNgaybatdau().getTime()));
            ps.setDate(5, new java.sql.Date(khuyenMai.getNgayketthuc().getTime()));
            ps.setInt(6, khuyenMai.getPhantram());
            ps.setInt(7, khuyenMai.getTrangthai());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin khuyến mãi
    public boolean updateKhuyenMai(KhuyenMaiDTO khuyenMai) {
        String sql = "UPDATE khuyenmai SET tenkm = ?, noidung = ?, ngaybatdau = ?, ngayketthuc = ?, phantram = ?, trangthai = ? WHERE makm = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, khuyenMai.getTenkm());
            ps.setString(2, khuyenMai.getNoidung());
            ps.setDate(3, new java.sql.Date(khuyenMai.getNgaybatdau().getTime()));
            ps.setDate(4, new java.sql.Date(khuyenMai.getNgayketthuc().getTime()));
            ps.setInt(5, khuyenMai.getPhantram());
            ps.setInt(6, khuyenMai.getTrangthai());
            ps.setString(7, khuyenMai.getMakm());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa khuyến mãi
    public boolean deleteKhuyenMai(String makm) {
        String sql = "DELETE FROM khuyenmai WHERE makm = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, makm);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tìm kiếm khuyến mãi theo tên
    public List<KhuyenMaiDTO> searchKhuyenMaiByName(String tenkm) {
        List<KhuyenMaiDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM khuyenmai WHERE tenkm LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + tenkm + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMaiDTO khuyenMai = new KhuyenMaiDTO(
                        rs.getString("makm"),
                        rs.getString("tenkm"),
                        rs.getString("noidung"),
                        rs.getDate("ngaybatdau"),
                        rs.getDate("ngayketthuc"),
                        rs.getInt("phantram"),
                        rs.getInt("trangthai")
                );
                list.add(khuyenMai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy tất cả khuyến mãi
    public List<KhuyenMaiDTO> getAllKhuyenMai() {
        List<KhuyenMaiDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM khuyenmai";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                KhuyenMaiDTO khuyenMai = new KhuyenMaiDTO(
                        rs.getString("makm"),
                        rs.getString("tenkm"),
                        rs.getString("noidung"),
                        rs.getDate("ngaybatdau"),
                        rs.getDate("ngayketthuc"),
                        rs.getInt("phantram"),
                        rs.getInt("trangthai")
                );
                list.add(khuyenMai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy khuyến mãi theo mã khuyến mãi
    public KhuyenMaiDTO getKhuyenMaiByMakm(String makm) {
        KhuyenMaiDTO khuyenMai = null;
        String sql = "SELECT * FROM khuyenmai WHERE makm = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, makm);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                khuyenMai = new KhuyenMaiDTO(
                        rs.getString("makm"),
                        rs.getString("tenkm"),
                        rs.getString("noidung"),
                        rs.getDate("ngaybatdau"),
                        rs.getDate("ngayketthuc"),
                        rs.getInt("phantram"),
                        rs.getInt("trangthai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khuyenMai;
    }
}
