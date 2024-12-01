/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AccountsDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author huulu
 */
public class AccountsDAO {

    private Connection conn;

    public AccountsDAO() {
        ConnectDB connectDB = new ConnectDB();
        if (connectDB.openConnectDB()) {
            this.conn = connectDB.conn;
        } else {
            this.conn = null;
            System.out.println("Failed to connect to database");
        }
    }

    public boolean insert(String manv ,String username, String password) throws SQLException {
        String sql = "INSERT INTO taikhoan (manv, tendangnhap, matkhau, maquyen) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, manv);
            pstmt.setString(2,  username);
            pstmt.setString(3, hashPassword(password)); 
            pstmt.setString(4, "Q003");
            return pstmt.executeUpdate() == 1;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete an account by ID
    public boolean delete(String manv) {
    String sql = "DELETE FROM taikhoan WHERE manv = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        // Gán giá trị cho tham số
        pstmt.setString(1, manv);

        // Thực thi câu lệnh và kiểm tra số dòng bị ảnh hưởng
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0; // Thành công nếu có ít nhất 1 dòng bị xóa
    } catch (SQLException e) {
        // Ghi log lỗi để theo dõi chi tiết
        System.err.println("Lỗi khi xóa tài khoản (manv: " + manv + "): " + e.getMessage());
        return false;
    }
}

    // Update an account
    public boolean update(AccountsDTO acc) {
        String sql = "UPDATE taikhoan SET matkhau = ?, maquyen = ? WHERE manv = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Gán giá trị cho các tham số trong câu lệnh SQL
            pstmt.setString(1, hashPassword(acc.getPassword())); // Mã hóa mật khẩu
            pstmt.setString(2, acc.getQuyen()); // Mã quyền
            pstmt.setString(3, acc.getId()); // Mã nhân viên (manv)

            // Thực thi và trả về kết quả
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Thành công nếu có ít nhất 1 dòng được cập nhật
        } catch (SQLException e) {
            // Ghi lỗi vào log để dễ theo dõi
            System.err.println("Lỗi khi cập nhật tài khoản: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateQuyen(AccountsDTO acc) {
        String sql = "UPDATE taikhoan SET matkhau = ?, maquyen = ? WHERE manv = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Gán giá trị cho các tham số trong câu lệnh SQL
            pstmt.setString(1, acc.getPassword()); 
            pstmt.setString(2, acc.getQuyen()); // Mã quyền
            pstmt.setString(3, acc.getId()); // Mã nhân viên (manv)

            // Thực thi và trả về kết quả
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Thành công nếu có ít nhất 1 dòng được cập nhật
        } catch (SQLException e) {
            // Ghi lỗi vào log để dễ theo dõi
            System.err.println("Lỗi khi cập nhật tài khoản: " + e.getMessage());
            return false;
        }
    }

    public boolean isQuyenInUse(String maquyen) {
        String sql = "SELECT COUNT(*) FROM taikhoan WHERE maquyen = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maquyen);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Nếu số lượng lớn hơn 0 -> quyền đang được sử dụng
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false; // Lỗi xảy ra hoặc không tìm thấy
    }



    // Find account by ID
    public AccountsDTO findById(String manv) throws SQLException {
        String sql = "SELECT * FROM taikhoan WHERE manv = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, manv);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new AccountsDTO(rs.getString("manv"), rs.getString("tendangnhap"), rs.getString("matkhau"), rs.getString("maquyen"));
            }
            return null;
        }
    }
    
   public List<AccountsDTO> getAllAcc() {
    List<AccountsDTO> accountList = new ArrayList<>();
    String sql = "SELECT manv, tendangnhap, matkhau, maquyen FROM taikhoan";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        // Lặp qua kết quả trả về và thêm vào danh sách accountList
        while (rs.next()) {
            AccountsDTO acc = new AccountsDTO();
            acc.setId(rs.getString("manv"));
            acc.setUsername(rs.getString("tendangnhap"));
            acc.setPassword(rs.getString("matkhau"));
            acc.setQuyen(rs.getString("maquyen"));

            accountList.add(acc);
        }
    } catch (SQLException e) {
        // Log lỗi hoặc thông báo
        System.err.println("Lỗi khi lấy danh sách tài khoản: " + e.getMessage());
    }
    return accountList;
}


    public AccountsDTO findByUsername(String username) {
        String sql = "SELECT * FROM taikhoan WHERE tendangnhap = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new AccountsDTO(
                        rs.getString("manv"),
                        rs.getString("tendangnhap"),
                        rs.getString("matkhau"),
                        rs.getString("maquyen")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String generateNextId() {
        String sql = "SELECT MAX(manv) AS maxId FROM taikhoan";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String maxId = rs.getString("maxId");
                if (maxId != null) {
                    // Lấy số từ ID hiện tại
                    int number = Integer.parseInt(maxId.substring(2));
                    // Tăng số và tạo ID mới
                    return String.format("NV%03d", number + 1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "NV000";
    }
    
    
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    public boolean verifyPassword(String rawPassword, String hashedPassword) {
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }
    
     public AccountsDTO authenticate(String username, String password) {
        AccountsDTO account = findByUsername(username);
        if (account == null) {
            return account; // Không tìm thấy tài khoản
        }
        boolean isVerify = verifyPassword(password, account.getPassword());
         if (isVerify) {
             return account;
         }
        return null;
    }
}
