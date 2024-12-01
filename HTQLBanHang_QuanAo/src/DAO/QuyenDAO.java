/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.QuyenDTO;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author huulu
 */
public class QuyenDAO {
    private Connection conn;

    public QuyenDAO() {
        ConnectDB connectDB = new ConnectDB();
        if (connectDB.openConnectDB()) {
            this.conn = connectDB.conn;
        } else {
            this.conn = null;
            System.out.println("Failed to connect to database");
        }
    }
    
    
   public List<QuyenDTO> getAllQuyen() {
    List<QuyenDTO> list = new ArrayList<>();
    String sql = "SELECT maquyen, tenquyen FROM quyen";
    
    try (
            
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
         
        while (rs.next()) {
            QuyenDTO quyen = new QuyenDTO(
                rs.getString("maquyen"), 
                rs.getString("tenquyen")
            );
            list.add(quyen);
        }
    } catch (SQLException ex) {
    }
    return list;
}

    public String getTenQuyenByMaQuyen(String maquyen) {
        String tenQuyen = null;
        String sql = "SELECT tenquyen FROM quyen WHERE maquyen = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maquyen);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    tenQuyen = rs.getString("tenquyen");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tenQuyen;
    }

    public boolean deleteQuyen(String maquyen) {
        String sql = "DELETE FROM quyen WHERE maquyen = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maquyen);
            return pstmt.executeUpdate() == 1; // Trả về true nếu xóa thành công
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String generateNextMaQuyen() {
    String sql = "SELECT MAX(maquyen) AS maxMaQuyen FROM quyen";
    String prefix = "Q";
    int defaultNumber = 1;

    try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        if (rs.next()) {
            String maxMaQuyen = rs.getString("maxMaQuyen");
            if (maxMaQuyen != null) {
                // Lấy số phía sau chữ 'Q'
                int currentNumber = Integer.parseInt(maxMaQuyen.substring(1));
                return String.format("%s%03d", prefix, currentNumber + 1);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    // Trường hợp không có mã nào trong bảng
    return String.format("%s%03d", prefix, defaultNumber);
}

    public boolean addQuyen(QuyenDTO quyen) {
    String sql = "INSERT INTO quyen (maquyen, tenquyen) VALUES (?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, quyen.getMaquyen());
        pstmt.setString(2, quyen.getTenquyen());

        return pstmt.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

    public boolean updateQuyen(QuyenDTO quyen) {
    String sql = "UPDATE quyen SET tenquyen = ? WHERE maquyen = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, quyen.getTenquyen()); // Cột "tenquyen"
        pstmt.setString(2, quyen.getMaquyen()); // Điều kiện "maquyen"

        return pstmt.executeUpdate() > 0; // Trả về true nếu sửa thành công
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

    public String getQuyenByTenQuyen(String tenQuyen) {
    String sql = "SELECT maquyen FROM quyen WHERE tenquyen = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, tenQuyen);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("maquyen");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // Trả về null nếu không tìm thấy
}

   

    
    
    
    
    
}
