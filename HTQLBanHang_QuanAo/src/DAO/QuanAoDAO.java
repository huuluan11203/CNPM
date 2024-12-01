/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ACER
 */
import DTO.QuanAoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuanAoDAO {
    private Connection conn;

    public QuanAoDAO() {
        ConnectDB connectDB = new ConnectDB();
        if (connectDB.openConnectDB()) {
            this.conn = connectDB.conn;
        } else {
            this.conn = null;
            System.out.println("Failed to connect to database");
        }
    }

    // Thêm mới một sản phẩm
    public boolean addQuanAo(QuanAoDTO quanAo) {
        if (conn == null) return false;
        String sql = "INSERT INTO quanao (masp, tensp, anh, giaban, soluongtonkho, trangthai, makm, matheloai) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, quanAo.getMasp());
            ps.setString(2, quanAo.getTensp());
            ps.setString(3, quanAo.getAnh());
            ps.setInt(4, quanAo.getGiaban());
            ps.setInt(5, quanAo.getSoluongtonkho());
            ps.setInt(6, quanAo.getTrangthai());
            ps.setString(7, quanAo.getMakm());
            ps.setString(8, quanAo.getMatheloai());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Cập nhật thông tin sản phẩm
    public boolean updateQuanAo(QuanAoDTO quanAo) {
        if (conn == null) return false;
        String sql = "UPDATE quanao SET tensp = ?, anh = ?, giaban = ?, soluongtonkho = ?, trangthai = ?, "
                   + "makm = ?, matheloai = ? WHERE masp = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, quanAo.getTensp());
            ps.setString(2, quanAo.getAnh());
            ps.setInt(3, quanAo.getGiaban());
            ps.setInt(4, quanAo.getSoluongtonkho());
            ps.setInt(5, quanAo.getTrangthai());
            ps.setString(6, quanAo.getMakm()); 
            ps.setString(7, quanAo.getMatheloai());
            ps.setString(8, quanAo.getMasp());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Xóa sản phẩm
    public boolean deleteQuanAo(String masp) {
        if (conn == null) return false;
        String sql = "UPDATE quanao SET trangthai = 0 WHERE masp = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, masp);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Tìm kiếm sản phẩm theo tên
    public List<QuanAoDTO> searchQuanAoByName(String tensp) {
        List<QuanAoDTO> list = new ArrayList<>();
        if (conn == null) return list;
        String sql = "SELECT * FROM quanao WHERE tensp LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + tensp + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanAoDTO quanAo = new QuanAoDTO(
                    rs.getString("masp"),
                    rs.getString("tensp"),
                    rs.getString("anh"),
                    rs.getInt("giaban"),
                    rs.getInt("soluongtonkho"),
                    rs.getInt("trangthai"),
                    rs.getString("matheloai"),
                    rs.getString("makm")
                );
                list.add(quanAo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy tất cả sản phẩm
    public List<QuanAoDTO> getAllQuanAo() {
        List<QuanAoDTO> list = new ArrayList<>();
        if (conn == null) return list;
        String sql = "SELECT * FROM quanao";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                QuanAoDTO quanAo = new QuanAoDTO(
                    rs.getString("masp"),
                    rs.getString("tensp"),
                    rs.getString("anh"),
                    rs.getInt("giaban"),
                    rs.getInt("soluongtonkho"),
                    rs.getInt("trangthai"),
                    rs.getString("makm"),
                    rs.getString("matheloai")
                );
                list.add(quanAo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    // Lấy thông tin sản phẩm theo mã
    public QuanAoDTO getQuanAoByMasp(String masp) {
        QuanAoDTO quanAo = null;
        if (conn == null) return null;
        String sql = "SELECT * FROM quanao WHERE masp = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, masp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quanAo = new QuanAoDTO(
                    rs.getString("masp"),
                    rs.getString("tensp"),
                    rs.getString("anh"),
                    rs.getInt("giaban"),
                    rs.getInt("soluongtonkho"),
                    rs.getInt("trangthai"),
                    rs.getString("makm"),  // Lấy makm trước matheloai
                    rs.getString("matheloai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quanAo;
    }

    public void closeConnectDB() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
