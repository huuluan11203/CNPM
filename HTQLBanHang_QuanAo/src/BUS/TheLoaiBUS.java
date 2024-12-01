/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author ACER
 */
import DAO.TheLoaiDAO;
import DTO.TheLoaiDTO;
import java.util.List;

public class TheLoaiBUS {
    private TheLoaiDAO theLoaiDAO;

    public TheLoaiBUS() {
        theLoaiDAO = new TheLoaiDAO();
    }

    // Thêm thể loại mới
    public boolean addTheLoai(TheLoaiDTO theLoai) {
        return theLoaiDAO.addTheLoai(theLoai);
    }

    // Cập nhật thông tin thể loại
    public boolean updateTheLoai(TheLoaiDTO theLoai) {
        return theLoaiDAO.updateTheLoai(theLoai);
    }

    // Xóa thể loại theo mã thể loại
    public boolean deleteTheLoai(String matheloai) {
        return theLoaiDAO.deleteTheLoai(matheloai);
    }

    // Tìm kiếm thể loại theo tên thể loại
    public List<TheLoaiDTO> searchTheLoaiByName(String tentheloai) {
        return theLoaiDAO.searchTheLoaiByName(tentheloai);
    }

    // Lấy tất cả thể loại
    public List<TheLoaiDTO> getAllTheLoai() {
        return theLoaiDAO.getAllTheLoai();
    }

    // Lấy thông tin thể loại theo mã thể loại
    public TheLoaiDTO getTheLoaiByMatheloai(String matheloai) {
        return theLoaiDAO.getTheLoaiByMatheloai(matheloai);
    }
    
    // Lấy mã thể loại tiếp theo
    public String getNextMatheloai() {
        List<TheLoaiDTO> allTheLoai = theLoaiDAO.getAllTheLoai();
        String maxMatheloai = "TL000";
        for (TheLoaiDTO theLoai : allTheLoai) {
            String matheloai = theLoai.getMatheloai();
            if (matheloai.compareTo(maxMatheloai) > 0) {
                maxMatheloai = matheloai;
            }
        }
        int numberPart = Integer.parseInt(maxMatheloai.substring(2)) + 1;
        return "TL" + String.format("%03d", numberPart);
    }

}

