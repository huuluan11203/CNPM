package DAO;


import DTO.UserDTO;
import DTO.TrangThai;
import DTO.ChucVu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huulu
 */
public class UserDAO {
    private Connection conn;

    public UserDAO() {
        ConnectDB connectDB = new ConnectDB();
        if (connectDB.openConnectDB()) {
            this.conn = connectDB.conn;
        } else {
            this.conn = null;
            System.out.println("Failed to connect to database.");
        }
    }

    public boolean addUser(UserDTO user) {
        String sql = "INSERT INTO nhanvien (manv, honv, tennv, gioitinh, ngaysinh, email, cmnd, sodienthoai, ngayvaolam, trangthai, chucvu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, generateNewEmployeeID());
            ps.setString(2, user.getHoNV());
            ps.setString(3, user.getTenNV());
            ps.setString(4, user.getGioiTinh());
            ps.setDate(5, Date.valueOf(user.getNgaySinh()));
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getCmnd());
            ps.setString(8, user.getSoDienThoai());
            ps.setTimestamp(9, Timestamp.valueOf(user.getNgayVaoLam()));
            ps.setString(10, user.getTrangThai().name());
            ps.setString(11, user.getChucVu().name());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Update an existing user's information
     * @param user UserDTO object
     * @return true if successful, false otherwise
     */
    public boolean updateUser(UserDTO user) {
        String sql = "UPDATE nhanvien SET honv = ?, tennv = ?, gioitinh = ?, ngaysinh = ?, email = ?, cmnd = ?, sodienthoai = ?, ngayvaolam = ?, trangthai = ?, chucvu = ? WHERE manv = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getHoNV());
            ps.setString(2, user.getTenNV());
            ps.setString(3, user.getGioiTinh());
            ps.setDate(4, Date.valueOf(user.getNgaySinh()));
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getCmnd());
            ps.setString(7, user.getSoDienThoai());
            ps.setTimestamp(8, Timestamp.valueOf(user.getNgayVaoLam()));
            ps.setString(9, user.getTrangThai().name());
            ps.setString(10, user.getChucVu().name());
            ps.setString(11, user.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Delete a user from the database
     * @param maNV ID of the user
     * @return true if successful, false otherwise
     */
    public boolean deleteUser(String maNV) {
        String sql = "DELETE FROM nhanvien WHERE manv = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNV);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Find a user by ID
     * @param maNV ID of the user
     * @return UserDTO object if found, null otherwise
     */
    public UserDTO findUserById(String maNV) {
        String sql = "SELECT * FROM nhanvien WHERE manv = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get all users from the database
     * @return List of UserDTO objects
     */
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Map ResultSet data to UserDTO object
     * @param rs ResultSet
     * @return UserDTO object
     */
    private UserDTO mapResultSetToUser(ResultSet rs) throws SQLException {
        UserDTO user = new UserDTO();
        user.setMaNV(rs.getString("manv"));
        user.setHoNV(rs.getString("honv"));
        user.setTenNV(rs.getString("tennv"));
        user.setGioiTinh(rs.getString("gioitinh"));
        user.setNgaySinh(rs.getDate("ngaysinh").toLocalDate());
        user.setEmail(rs.getString("email"));
        user.setCmnd(rs.getString("cmnd"));
        user.setSoDienThoai(rs.getString("sodienthoai"));
        user.setNgayVaoLam(rs.getTimestamp("ngayvaolam").toLocalDateTime());
        user.setTrangThai(TrangThai.valueOf(rs.getString("trangthai").toUpperCase()));
        user.setChucVu(ChucVu.valueOf(rs.getString("chucvu").toUpperCase()));
        return user;
    }
    
       public String generateNewEmployeeID() throws SQLException {
        String newID = "NV001"; // Mặc định giá trị ID ban đầu
        String query = "SELECT MAX(CAST(SUBSTRING(manv, 3) AS UNSIGNED)) FROM nhanvien";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Lấy giá trị ID hiện tại lớn nhất từ cột manv
                int maxId = rs.getInt(1);
                // Tạo ID mới bằng cách cộng thêm 1
                if (maxId > 0) {
                    maxId++;
                    newID = "NV" + String.format("%03d", maxId); // Định dạng "NV001", "NV002", ...
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại lỗi SQL nếu có
        }

        return newID; // Trả về ID mới
    }
       
       public String getEmailByMaNV(String manv) {
        String email = null;
        String query = "SELECT email FROM nhanvien WHERE manv = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, manv);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    email = rs.getString("email");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }

}
