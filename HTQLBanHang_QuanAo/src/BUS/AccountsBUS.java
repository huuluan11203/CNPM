/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.AccountsDAO;
import DTO.AccountsDTO;
import java.util.List;
import javafx.concurrent.Task;
import java.util.Random;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail2.javax.DefaultAuthenticator;

/**
 *
 * @author huulu
 */
public class AccountsBUS {    
    
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String USER_NAME = "buihuuluan14102003@gmail.com";
    private static final String PASSWORD = "gsesdziwlinfmjtp";
    private static final String DEFAULT_PASSWORD = "12345678";
    private static String VERIFY_CODE;

    private static boolean isSuccess;
    private static AccountsDTO accountsDTO;
    private static AccountsDAO accountsDAO;

    public AccountsBUS() {
        accountsDAO = new AccountsDAO();
    }
    
    public AccountsDTO login(String username, String password){
        return accountsDAO.authenticate(username, password);
    }
    
     public boolean isExist(String username){
         if (accountsDAO.findByUsername(username) != null) {
            return true;
         }
        return false;
    }
     
    public List<AccountsDTO> getAll(){
        return accountsDAO.getAllAcc();
    }
    
    public boolean deleteAcc(String tdn){
        return accountsDAO.delete(tdn);
    }
    
     public boolean updatePassword(AccountsDTO acc){
        return accountsDAO.update(acc);
    }
    
    public boolean setDefaultPassword(AccountsDTO acc){
        acc.setPassword(DEFAULT_PASSWORD);
        return accountsDAO.update(acc);
    }
    
    public AccountsDTO findbyUsername(String username){
        return accountsDAO.findByUsername(username);
    }
    
    public boolean checkUsed(String maquyen){
        return accountsDAO.isQuyenInUse(maquyen);
    }
    
    public boolean updateQuyen(AccountsDTO acc){
        return accountsDAO.updateQuyen(acc);
    }
    
    public static String generateCode(int length) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            code.append(random.nextInt(10)); // Tạo số ngẫu nhiên từ 0 đến 9
        }
        return code.toString();
    }
    
    public void sendEmailAsync(String recipientEmail, String verificationCode) {
        // Tạo một Task để chạy hàm gửi email
        Task<Boolean> sendEmailTask = new Task<>() {
            @Override
            protected Boolean call()  throws Exception  {
                // Gọi hàm gửi email trong Task
                return sendVerificationCode(recipientEmail, verificationCode);
            }
        };
        
        // Xử lý kết quả sau khi Task hoàn thành
        sendEmailTask.setOnSucceeded(event -> {
            boolean success = sendEmailTask.getValue();
            if (success) {
                isSuccess = true;
            } else {
               isSuccess = false;
            }
        });

        // Xử lý lỗi nếu Task gặp vấn đề
        sendEmailTask.setOnFailed(event -> {
            Throwable exception = sendEmailTask.getException();
            exception.printStackTrace();
            System.out.println("Gửi email gặp lỗi!");
        });

        // Chạy Task trong một thread riêng biệt
        Thread thread = new Thread(sendEmailTask);
        thread.setDaemon(true);
        thread.start();
    }

    
    public static boolean sendVerificationCode(String recipientEmail, String verificationCode) {
        try {
            // Tạo đối tượng email
            SimpleEmail email = new SimpleEmail();
            email.setHostName(SMTP_HOST);
            email.setSmtpPort(SMTP_PORT);
            email.setAuthenticator(new DefaultAuthenticator(USER_NAME, PASSWORD));
            email.setStartTLSRequired(true);
            email.setStartTLSEnabled(true);

            // Thiết lập thông tin email
            email.setFrom(USER_NAME); // Email người gửi
            email.setSubject("Mã xác nhận đổi mật khẩu"); // Tiêu đề
            email.setMsg("Mã xác nhận của bạn là: " + verificationCode); // Nội dung
            email.addTo(recipientEmail); // Email người nhận

            // Gửi email
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean sendCode(String email){
        VERIFY_CODE = generateCode(6);
        //sendEmailAsync(email, VERIFY_CODE);
        //return isSuccess;
        return sendVerificationCode(email, VERIFY_CODE);
    }
    
    public boolean validateCode(String code){
        return VERIFY_CODE.equals(code);
    }
}
