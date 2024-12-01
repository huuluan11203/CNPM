/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.QuyenDAO;
import DTO.QuyenDTO;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author huulu
 */
public class QuyenBUS {
    private QuyenDAO quyenDAO;

    public QuyenBUS() {
        quyenDAO = new QuyenDAO();
    }
    
    public List<QuyenDTO> getAllQuyen() {
        QuyenDAO quyenDAO = new QuyenDAO();
        return quyenDAO.getAllQuyen();
    }

    public String getTenQuyen(String maquyen) {
        return quyenDAO.getTenQuyenByMaQuyen(maquyen);
    }

    public boolean deleteQuyen(String maquyen) {
        AccountsBUS accountsBUS = new AccountsBUS();
        if (!accountsBUS.checkUsed(maquyen)) {
            return quyenDAO.deleteQuyen(maquyen);
        }
        return false;
    }

    public String generateNextMaQuyen() {
        return quyenDAO.generateNextMaQuyen();
    }

    public boolean addQuyen(QuyenDTO quyen) {
        if (quyen == null || quyen.getMaquyen() == null || quyen.getTenquyen().trim().isEmpty()) {
            return false; // Kiểm tra dữ liệu đầu vào
        }
        return quyenDAO.addQuyen(quyen);
    }

    public boolean updateQuyen(QuyenDTO quyen) {
    // Kiểm tra dữ liệu đầu vào
    if (quyen == null) {
        System.out.println("Dữ liệu quyền không hợp lệ!");
        return false;
    }
    if (quyen.getMaquyen() == null || quyen.getMaquyen().trim().isEmpty()) {
        System.out.println("Mã quyền không được để trống!");
        return false;
    }
    if (quyen.getTenquyen() == null || quyen.getTenquyen().trim().isEmpty()) {
        System.out.println("Tên quyền không được để trống!");
        return false;
    }

    // Gọi DAO để thực hiện sửa
    return quyenDAO.updateQuyen(quyen);
}

public String getMaQuyenByTenQuyen(String tenQuyen) {
    return quyenDAO.getQuyenByTenQuyen(tenQuyen);
}


    
}
