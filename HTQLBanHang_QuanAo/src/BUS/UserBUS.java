/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.UserDAO;
import DTO.UserDTO;

/**
 *
 * @author huulu
 */
public class UserBUS {
    private static UserDTO userDTO;
    private static UserDAO userDAO;

    public UserBUS() {
        userDAO = new UserDAO();
    }
    
    public UserDTO findbyId(String id){
        UserDTO user = null;
        if (!id.isBlank()) {
            return user = userDAO.findUserById(id);
        }
        return user;
    }
    
     public String getEmailByMaNV(String manv) {
        return userDAO.getEmailByMaNV(manv);
     }
    
}
