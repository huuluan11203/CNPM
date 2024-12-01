/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChucNangDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author huulu
 */
public class ChucNangDAO {
    private Connection conn;

    public ChucNangDAO() {
        ConnectDB connectDB = new ConnectDB();
        if (connectDB.openConnectDB()) {
            this.conn = connectDB.conn;
        } else {
            this.conn = null;
            System.out.println("Failed to connect to database");
        }
    }

    public List<String> getAllMaChucNangByQuyen(String maquyen) {
        List<String> machucnangList = new ArrayList<>();
        String sql = "SELECT DISTINCT machucnang FROM chucnang_quyen WHERE maquyen = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maquyen);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Thêm mã chức năng vào danh sách
                    machucnangList.add(rs.getString("machucnang"));
                }
            } catch (SQLException e) {
                System.err.println("Lỗi khi xử lý dữ liệu: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi kết nối hoặc truy vấn cơ sở dữ liệu: " + e.getMessage());
            e.printStackTrace();
        }

        return machucnangList;
    }

    public List<ChucNangDTO> getAllChucNang(){
        List<ChucNangDTO> chucNangList = new ArrayList<>();
        String sql = "SELECT * FROM chucnang"; 

        try (PreparedStatement pstmt = conn.prepareStatement(sql); 
                ResultSet rs = pstmt.executeQuery()) {

            // Duyệt qua kết quả trả về và thêm vào danh sách
            while (rs.next()) {
                String machucnang = rs.getString("machucnang");
                String tenchucnang = rs.getString("tenchucnang");
                ChucNangDTO chucNang = new ChucNangDTO(machucnang, tenchucnang);
                chucNangList.add(chucNang);
            }
        }catch(SQLException exception){
            
        }
        return chucNangList;
    }


    public List<ChucNangDTO> getChucNangByQuyen(String maquyen) {
        List<ChucNangDTO> chucNangList = new ArrayList<>();
        String sql = "SELECT c.machucnang, c.tenchucnang "
                + "FROM chucnang c "
                + "JOIN chucnang_quyen cq ON c.machucnang = cq.machucnang "
                + "WHERE cq.maquyen = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maquyen);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucNangDTO chucNang = new ChucNangDTO();
                chucNang.setMachucnang(rs.getString("machucnang"));
                chucNang.setTenchucnang(rs.getString("tenchucnang"));
                chucNangList.add(chucNang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chucNangList;
    }

    public String getNextMaChucNang() {
        String sql = "SELECT MAX(machucnang) AS max_machucnang FROM chucnang";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                String maxMaChucNang = rs.getString("max_machucnang");
                if (maxMaChucNang != null) {
                    int nextId = Integer.parseInt(maxMaChucNang.substring(2)) + 1;
                    return String.format("CN%03d", nextId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "CN001"; // Nếu bảng chưa có dữ liệu
    }

    public boolean addChucNangToQuyen(String maChucNang, String tenChucNang, String maQuyen) {
        String sqlInsertChucNang = "INSERT INTO chucnang (machucnang, tenchucnang) VALUES (?, ?)";
        String sqlInsertChucNangQuyen = "INSERT INTO chucnang_quyen (machucnang, maquyen) VALUES (?, ?)";

        try {
            // Tắt chế độ autoCommit
            conn.setAutoCommit(false);

            // Thêm vào bảng chucnang
            try (PreparedStatement psChucNang = conn.prepareStatement(sqlInsertChucNang)) {
                psChucNang.setString(1, maChucNang);
                psChucNang.setString(2, tenChucNang);
                psChucNang.executeUpdate();
            }

            // Thêm vào bảng chucnang_quyen
            try (PreparedStatement psChucNangQuyen = conn.prepareStatement(sqlInsertChucNangQuyen)) {
                psChucNangQuyen.setString(1, maChucNang);
                psChucNangQuyen.setString(2, maQuyen);
                psChucNangQuyen.executeUpdate();
            }

            // Commit giao dịch nếu mọi thứ thành công
            conn.commit();
            return true;
        } catch (SQLException ex) {
            try {
                // Quay lại giao dịch nếu có lỗi
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, "Rollback failed", rollbackEx);
            }
            Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, "Transaction failed", ex);
        } finally {
            try {
                // Bật lại autoCommit về trạng thái ban đầu
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, "Failed to reset autoCommit", ex);
            }
        }

        return false;
    }

    public boolean deleteChucNang(String maChucNang) {
        String sqlDeleteChucNangQuyen = "DELETE FROM chucnang_quyen WHERE machucnang = ?";
        String sqlDeleteChucNang = "DELETE FROM chucnang WHERE machucnang = ?";

        try {
            // Bắt đầu giao dịch
            conn.setAutoCommit(false);

            // Xóa các liên kết trong bảng chucnang_quyen
            try (PreparedStatement psDeleteChucNangQuyen = conn.prepareStatement(sqlDeleteChucNangQuyen)) {
                psDeleteChucNangQuyen.setString(1, maChucNang);
                psDeleteChucNangQuyen.executeUpdate();
            }

            // Xóa chức năng trong bảng chucnang
            try (PreparedStatement psDeleteChucNang = conn.prepareStatement(sqlDeleteChucNang)) {
                psDeleteChucNang.setString(1, maChucNang);
                psDeleteChucNang.executeUpdate();
            }

            // Commit giao dịch
            conn.commit();
            return true;
        } catch (SQLException ex) {
            // Rollback nếu có lỗi
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, rollbackEx);
            }
            Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Đặt lại chế độ autoCommit về true
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

 
    public List<String> getQuyenByChucNang(String maChucNang) {
    List<String> quyenList = new ArrayList<>();
    String sql = "SELECT maquyen FROM chucnang_quyen WHERE machucnang = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, maChucNang);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            quyenList.add(rs.getString("maquyen"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }

    return quyenList;
}

    
    
    
}
