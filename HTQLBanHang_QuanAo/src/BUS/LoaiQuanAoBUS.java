/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author ACER
 */
import DAO.LoaiQuanAoDAO;
import DTO.LoaiQuanAoDTO;
import java.util.List;

public class LoaiQuanAoBUS {
    private LoaiQuanAoDAO loaiQuanAoDAO;

    public LoaiQuanAoBUS() {
        loaiQuanAoDAO = new LoaiQuanAoDAO();
    }

    // Thêm một loại quần áo mới
    public boolean addLoaiQuanAo(LoaiQuanAoDTO loaiQuanAo) {
        return loaiQuanAoDAO.addLoaiQuanAo(loaiQuanAo);
    }

    // Cập nhật thông tin loại quần áo
    public boolean updateLoaiQuanAo(LoaiQuanAoDTO loaiQuanAo) {
        return loaiQuanAoDAO.updateLoaiQuanAo(loaiQuanAo);
    }

    // Xóa một loại quần áo theo mã loại
    public boolean deleteLoaiQuanAo(String maloaiquanao) {
        return loaiQuanAoDAO.deleteLoaiQuanAo(maloaiquanao);
    }

    // Tìm kiếm loại quần áo theo tên loại
    public List<LoaiQuanAoDTO> searchLoaiQuanAoByName(String tenloaiquanao) {
        return loaiQuanAoDAO.searchLoaiQuanAoByName(tenloaiquanao);
    }

    // Lấy tất cả loại quần áo
    public List<LoaiQuanAoDTO> getAllLoaiQuanAo() {
        return loaiQuanAoDAO.getAllLoaiQuanAo();
    }

    // Lấy thông tin loại quần áo theo mã loại
    public LoaiQuanAoDTO getLoaiQuanAoByMaloai(String maloaiquanao) {
        return loaiQuanAoDAO.getLoaiQuanAoByMaloai(maloaiquanao);
    }
    
    // Lấy mã loại quần áo tiếp theo
    public String getNextMaloai() {
        List<LoaiQuanAoDTO> allLoaiQuanAo = loaiQuanAoDAO.getAllLoaiQuanAo();

        String maxMaloai = "LQ000";

        for (LoaiQuanAoDTO loaiQuanAo : allLoaiQuanAo) {
            String maloai = loaiQuanAo.getMaloaiquanao();
            if (maloai.compareTo(maxMaloai) > 0) {
                maxMaloai = maloai;
            }
        }

        int numberPart = Integer.parseInt(maxMaloai.substring(2)) + 1;
        return "LQ" + String.format("%03d", numberPart);
    }

}

