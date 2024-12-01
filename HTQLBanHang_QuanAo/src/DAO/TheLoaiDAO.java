/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ACER
 */
import DTO.TheLoaiDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    private Connection conn;

    public TheLoaiDAO() {
        ConnectDB connectDB = new ConnectDB();
        if (connectDB.openConnectDB()) {
            this.conn = connectDB.conn;
        } else {
            this.conn = null;
            System.out.println("Failed to connect to database");
        }
    }

    public boolean addTheLoai(TheLoaiDTO theLoai) {
        String sql = "INSERT INTO theloai (matheloai, tentheloai, maloaiquanao) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, theLoai.getMatheloai());
            ps.setString(2, theLoai.getTentheloai());
            ps.setString(3, theLoai.getMaloaiquanao());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTheLoai(TheLoaiDTO theLoai) {
        String sql = "UPDATE theloai SET tentheloai = ?, maloaiquanao = ? WHERE matheloai = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, theLoai.getTentheloai());
            ps.setString(2, theLoai.getMaloaiquanao());
            ps.setString(3, theLoai.getMatheloai());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTheLoai(String matheloai) {
        String sql = "DELETE FROM theloai WHERE matheloai = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matheloai);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TheLoaiDTO> searchTheLoaiByName(String tentheloai) {
        List<TheLoaiDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM theloai WHERE tentheloai LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + tentheloai + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoaiDTO theLoai = new TheLoaiDTO(
                    rs.getString("matheloai"),
                    rs.getString("tentheloai"),
                    rs.getString("maloaiquanao")
                );
                list.add(theLoai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<TheLoaiDTO> getAllTheLoai() {
        List<TheLoaiDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM theloai";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TheLoaiDTO theLoai = new TheLoaiDTO(
                    rs.getString("matheloai"),
                    rs.getString("tentheloai"),
                    rs.getString("maloaiquanao")
                );
                list.add(theLoai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public TheLoaiDTO getTheLoaiByMatheloai(String matheloai) {
        TheLoaiDTO theLoai = null;
        String sql = "SELECT * FROM theloai WHERE matheloai = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matheloai);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                theLoai = new TheLoaiDTO(
                    rs.getString("matheloai"),
                    rs.getString("tentheloai"),
                    rs.getString("maloaiquanao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theLoai;
    }
}

