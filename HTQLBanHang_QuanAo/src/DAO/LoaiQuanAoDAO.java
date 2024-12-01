/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ACER
 */
import DTO.LoaiQuanAoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoaiQuanAoDAO {
    private Connection conn;

    public LoaiQuanAoDAO() {
        ConnectDB connectDB = new ConnectDB();
        if (connectDB.openConnectDB()) {
            this.conn = connectDB.conn;
        } else {
            this.conn = null;
            System.out.println("Failed to connect to database");
        }
    }

    // Thêm loại quần áo mới
    public boolean addLoaiQuanAo(LoaiQuanAoDTO loaiQuanAo) {
        String sql = "INSERT INTO loaiquanao (maloaiquanao, tenloaiquanao) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loaiQuanAo.getMaloaiquanao());
            ps.setString(2, loaiQuanAo.getTenloaiquanao());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin loại quần áo
    public boolean updateLoaiQuanAo(LoaiQuanAoDTO loaiQuanAo) {
        String sql = "UPDATE loaiquanao SET tenloaiquanao = ? WHERE maloaiquanao = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loaiQuanAo.getTenloaiquanao());
            ps.setString(2, loaiQuanAo.getMaloaiquanao());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa loại quần áo theo mã loại quần áo
    public boolean deleteLoaiQuanAo(String maloaiquanao) {
        String sql = "DELETE FROM loaiquanao WHERE maloaiquanao = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maloaiquanao);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tìm kiếm loại quần áo theo tên
    public List<LoaiQuanAoDTO> searchLoaiQuanAoByName(String tenloaiquanao) {
        List<LoaiQuanAoDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM loaiquanao WHERE tenloaiquanao LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + tenloaiquanao + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiQuanAoDTO loaiQuanAo = new LoaiQuanAoDTO(
                    rs.getString("maloaiquanao"),
                    rs.getString("tenloaiquanao")
                );
                list.add(loaiQuanAo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy tất cả loại quần áo
    public List<LoaiQuanAoDTO> getAllLoaiQuanAo() {
        List<LoaiQuanAoDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM loaiquanao";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                LoaiQuanAoDTO loaiQuanAo = new LoaiQuanAoDTO(
                    rs.getString("maloaiquanao"),
                    rs.getString("tenloaiquanao")
                );
                list.add(loaiQuanAo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public LoaiQuanAoDTO getLoaiQuanAoByMaloai(String maloaiquanao) {
        LoaiQuanAoDTO loaiQuanAo = null;
        String sql = "SELECT * FROM loaiquanao WHERE maloaiquanao = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maloaiquanao);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loaiQuanAo = new LoaiQuanAoDTO(
                    rs.getString("maloaiquanao"),
                    rs.getString("tenloaiquanao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiQuanAo;
    }
}

