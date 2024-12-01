/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.List;

/**
 *
 * @author ACER
 */

public class KhuyenMaiBUS {
    private KhuyenMaiDAO khuyenMaiDAO;

    public KhuyenMaiBUS() {
        this.khuyenMaiDAO = new KhuyenMaiDAO();
    }

    // Thêm khuyến mãi
    public boolean addKhuyenMai(KhuyenMaiDTO khuyenMai) {
        if (validateKhuyenMai(khuyenMai)) {
            return khuyenMaiDAO.addKhuyenMai(khuyenMai);
        }
        return false;
    }

    // Cập nhật thông tin khuyến mãi
    public boolean updateKhuyenMai(KhuyenMaiDTO khuyenMai) {
        if (validateKhuyenMai(khuyenMai)) {
            return khuyenMaiDAO.updateKhuyenMai(khuyenMai);
        }
        return false;
    }

    // Xóa khuyến mãi
    public boolean deleteKhuyenMai(String makm) {
        return khuyenMaiDAO.deleteKhuyenMai(makm);
    }

    // Lấy danh sách tất cả khuyến mãi
    public List<KhuyenMaiDTO> getAllKhuyenMai() {
        return khuyenMaiDAO.getAllKhuyenMai();
    }

    // Tìm kiếm khuyến mãi theo tên
    public List<KhuyenMaiDTO> searchKhuyenMaiByName(String tenkm) {
        return khuyenMaiDAO.searchKhuyenMaiByName(tenkm);
    }

    // Lấy khuyến mãi theo mã
    public KhuyenMaiDTO getKhuyenMaiByMakm(String makm) {
        return khuyenMaiDAO.getKhuyenMaiByMakm(makm);
    }

    // Phương thức kiểm tra tính hợp lệ của khuyến mãi (ví dụ: ngày bắt đầu phải trước ngày kết thúc, phần trăm phải hợp lý)
    private boolean validateKhuyenMai(KhuyenMaiDTO khuyenMai) {
        if (khuyenMai.getTenkm().isEmpty() || khuyenMai.getNoidung().isEmpty()) {
            System.out.println("Tên khuyến mãi và nội dung không được để trống.");
            return false;
        }
        if (khuyenMai.getNgaybatdau().after(khuyenMai.getNgayketthuc())) {
            System.out.println("Ngày bắt đầu phải trước ngày kết thúc.");
            return false;
        }
        if (khuyenMai.getPhantram() < 0 || khuyenMai.getPhantram() > 100) {
            System.out.println("Phần trăm khuyến mãi phải trong khoảng từ 0 đến 100.");
            return false;
        }
        return true;
    }
}

