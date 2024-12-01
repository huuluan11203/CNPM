/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import DAO.AccountsDAO;
import DAO.UserDAO;
import DTO.ChucVu;
import DTO.TrangThai;
import DTO.UserDTO;
import GUI.Main.Login;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class main {
    
    private static void init(){
        AccountsDAO accountsDAO = new AccountsDAO();
        UserDAO userDAO = new UserDAO();
        
        UserDTO admin = new UserDTO(
                "null",
                "Luân",
                "Hữu",
                "Nam",
                LocalDate.of(2003, 10, 14),
                "huuluan11203@gmail.com",
                "083203011575",
                "0878678692",
                LocalDateTime.now(),
                TrangThai.ACTIVE,
                ChucVu.EMPLOYEE
                
        );

        String ADMIN_USERNAME = "employee";
        String ADMIN_PASSWORD = "employee";
        
        if (accountsDAO.findByUsername(ADMIN_USERNAME) == null) {
            
            try {
                userDAO.addUser(admin);
                accountsDAO.insert("NV001",ADMIN_USERNAME, ADMIN_PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                //init();
                
                
            }
        });
    }
}
