package DTO;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO class for NhanVien table
 * @author huulu
 */
public class UserDTO {
    private String maNV; // Mã nhân viên
    private String hoNV; // Họ nhân viên
    private String tenNV; // Tên nhân viên
    private String gioiTinh; // Giới tính
    private LocalDate ngaySinh; // Ngày sinh
    private String email; // Email
    private String cmnd; // Chứng minh nhân dân/Căn cước công dân
    private String soDienThoai; // Số điện thoại
    private LocalDateTime ngayVaoLam; // Ngày vào làm
    private TrangThai trangThai; // Trạng thái hoạt động
    private ChucVu chucVu; // Chức vụ

    // Constructors
    public UserDTO() {
    }

    public UserDTO(String maNV, String hoNV, String tenNV, String gioiTinh, LocalDate ngaySinh, 
                   String email, String cmnd, String soDienThoai, LocalDateTime ngayVaoLam, 
                   TrangThai trangThai, ChucVu chucVu) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.ngayVaoLam = ngayVaoLam;
        this.trangThai = trangThai;
        this.chucVu = chucVu;
    }

    // Getters and Setters
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public LocalDateTime getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(LocalDateTime ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "maNV='" + maNV + '\'' +
                ", hoNV='" + hoNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", email='" + email + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", ngayVaoLam=" + ngayVaoLam +
                ", trangThai=" + trangThai +
                ", chucVu='" + chucVu + '\'' +
                '}';
    }
}
