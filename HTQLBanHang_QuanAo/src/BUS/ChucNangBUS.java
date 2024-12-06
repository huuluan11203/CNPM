/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChucNangDAO;
import DAO.QuyenDAO;
import DTO.ChucNangDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huulu
 */
public class ChucNangBUS {
    private static ChucNangDAO chucNangDAO;

    public ChucNangBUS() {
        chucNangDAO = new ChucNangDAO();
    }
    
    public List<String> getChucNangByQuyen(String maquyen) {
        return chucNangDAO.getAllMaChucNangByQuyen(maquyen);
    }
    
     public void displayChucNangOnTable(JTable table) {
    
            List<ChucNangDTO> chucNangList = chucNangDAO.getAllChucNang();

            // Tạo DefaultTableModel để hiển thị dữ liệu lên JTable
            String[] columnNames = {"Mã Chức Năng", "Tên Chức Năng"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            // Duyệt qua danh sách và thêm vào model
            for (ChucNangDTO chucNang : chucNangList) {
                Object[] row = {chucNang.getMachucnang(), chucNang.getTenchucnang()};
                model.addRow(row);
            }

            // Gán model cho JTable
            table.setModel(model);
  
    }
     
    public List<ChucNangDTO> getAll() {
        return chucNangDAO.getAllChucNang();
    }

    public List<ChucNangDTO> getAllChucNangByQuyen(String maquyen) {
        return chucNangDAO.getChucNangByQuyen(maquyen);
    }

    public boolean addNewChucNangToQuyen(String tenChucNang, String tenQuyen) {
        QuyenDAO quyenDAO = new QuyenDAO();
        String maQuyen = quyenDAO.getQuyenByTenQuyen(tenQuyen);
        if (maQuyen == null) {
            return false;
        }

        String maChucNang = chucNangDAO.getNextMaChucNang();
        return chucNangDAO.addNewChucNangToQuyen(maChucNang, tenChucNang, maQuyen);
    }
    
    public boolean addExistChucNangToQuyen(String maChucNang, String maquyen) {

        return chucNangDAO.addExistChucNangToQuyen(maChucNang, maquyen);
    }

    public String getNextId() {
        return chucNangDAO.getNextMaChucNang();
    }

    public boolean deleteChucNang(String maChucNang) {
        return chucNangDAO.deleteChucNang(maChucNang);
    }

    public List<String> getQuyenByChucNang(String maChucNang) {
        return chucNangDAO.getQuyenByChucNang(maChucNang);
    }

    public boolean isChucNangAndQuyenExist(String macn, String maquyen){
        return chucNangDAO.isChucNangAndQuyenExist(macn, maquyen);
    }

    public boolean deleteChucNangFromQuyen(String macn, String maquyen) {
        return chucNangDAO.deleteChucNangFromQuyen(macn, maquyen);
    }

}
