/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author ACER
 */

import DAO.QuanAoDAO;
import DTO.QuanAoDTO;
import java.util.List;

public class QuanAoBUS {
    private QuanAoDAO quanAoDAO;

    public QuanAoBUS() {
        quanAoDAO = new QuanAoDAO();
    }

    public boolean addQuanAo(QuanAoDTO quanAo) {
        return quanAoDAO.addQuanAo(quanAo);
    }

    public boolean updateQuanAo(QuanAoDTO quanAo) {
        return quanAoDAO.updateQuanAo(quanAo);
    }

    public boolean deleteQuanAo(String masp) {
        return quanAoDAO.deleteQuanAo(masp);
    }

    public List<QuanAoDTO> searchQuanAoByName(String tensp) {
        return quanAoDAO.searchQuanAoByName(tensp);
    }

    public List<QuanAoDTO> getAllQuanAo() {
        return quanAoDAO.getAllQuanAo();
    }

    public QuanAoDTO getQuanAoByMasp(String masp) {
        return quanAoDAO.getQuanAoByMasp(masp);
    }
    public String getNextMasP() {
        List<QuanAoDTO> allQuanAo = quanAoDAO.getAllQuanAo(); 
        String maxMasP = "SP000"; 
        
        for (QuanAoDTO quanAoDTO : allQuanAo) {
            String masP = quanAoDTO.getMasp(); 
            if (masP.compareTo(maxMasP) > 0) {
                maxMasP = masP;  
            }
        }
        
        int numberPart = Integer.parseInt(maxMasP.substring(2)) + 1;
        return "SP" + String.format("%03d", numberPart); 
    }
}



