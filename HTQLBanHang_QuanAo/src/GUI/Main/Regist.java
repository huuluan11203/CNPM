
package GUI.Main;


import BUS.AccountsBUS;
import BUS.UserBUS;
import DAO.AccountsDAO;
import DTO.AccountsDTO;
import DTO.UserDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author huulu
 */
public class Regist extends javax.swing.JFrame {
    
    private UserBUS nhanvienBUS;
    private AccountsBUS accountsBUS;
    private static String VERIFY_CODE;
    private boolean isVerify = false;
    private boolean isSuccess = false;
    public Regist() {
        accountsBUS = new AccountsBUS();
        nhanvienBUS = new UserBUS();
        FlatLightLaf.setup();
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
        
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        Login_Panel = new Main.login.Login_Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        email_txt = new javax.swing.JTextField();
        passwd_txt = new javax.swing.JPasswordField();
        exit1 = new Main.login.Exit();
        submit = new Main.login.Button();
        jCheckBox1 = new javax.swing.JCheckBox();
        quenmatkhau = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        code_txt = new javax.swing.JTextField();
        username_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(80, 80, 80));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Email");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Login_Panel.setForeground(new java.awt.Color(255, 153, 153));
        Login_Panel.setMaximumSize(new java.awt.Dimension(400, 500));
        Login_Panel.setMinimumSize(new java.awt.Dimension(400, 500));
        Login_Panel.setPreferredSize(new java.awt.Dimension(400, 500));
        Login_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Mã xác nhận");
        Login_Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 333, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(80, 80, 80));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mật khẩu mới");
        Login_Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 240, -1));

        jLabel4.setForeground(new java.awt.Color(80, 80, 80));
        jLabel4.setText("_______________________________________________________________");
        Login_Panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 302, -1));

        msg.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        msg.setForeground(Color.red
        );
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login_Panel.add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 300, 26));

        jLabel7.setForeground(new java.awt.Color(80, 80, 80));
        jLabel7.setText("_______________________________________________________________");
        Login_Panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 302, -1));

        email_txt.setBackground(new Color(0,0,0,0)
        );
        email_txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        email_txt.setBorder(null);
        email_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                email_txtFocusGained(evt);
            }
        });
        email_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                email_txtMouseClicked(evt);
            }
        });
        email_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                email_txtKeyTyped(evt);
            }
        });
        Login_Panel.add(email_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 302, 40));

        passwd_txt.setBackground(new Color(0,0,0,0));
        passwd_txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        passwd_txt.setBorder(null);
        passwd_txt.setEnabled(false);
        passwd_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwd_txtFocusGained(evt);
            }
        });
        passwd_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwd_txtMouseClicked(evt);
            }
        });
        passwd_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwd_txtKeyTyped(evt);
            }
        });
        Login_Panel.add(passwd_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 302, 40));

        exit1.setForeground(new java.awt.Color(255, 255, 255));
        Login_Panel.add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        submit.setBackground(Color.decode("#1da1f2")
        );
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Xác minh");
        submit.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        Login_Panel.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 300, 60));

        jCheckBox1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(80, 80, 80));
        jCheckBox1.setText("Hiện mật khẩu");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        Login_Panel.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        quenmatkhau.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        quenmatkhau.setForeground(Color.decode("#0d2aaf"));
        quenmatkhau.setText("Đăng nhập");
        quenmatkhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quenmatkhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quenmatkhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quenmatkhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quenmatkhauMouseExited(evt);
            }
        });
        Login_Panel.add(quenmatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, 26));

        jLabel5.setForeground(new java.awt.Color(80, 80, 80));
        jLabel5.setText("_______________________________________________________________");
        Login_Panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 302, -1));

        jLabel6.setForeground(new java.awt.Color(80, 80, 80));
        jLabel6.setText("_______________________________________________________________");
        Login_Panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 302, -1));

        code_txt.setBackground(new Color(0,0,0,0)
        );
        code_txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        code_txt.setBorder(null);
        code_txt.setEnabled(false);
        code_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                code_txtFocusGained(evt);
            }
        });
        code_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                code_txtMouseClicked(evt);
            }
        });
        code_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code_txtKeyTyped(evt);
            }
        });
        Login_Panel.add(code_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 302, 40));

        username_txt.setBackground(new Color(0,0,0,0)
        );
        username_txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        username_txt.setBorder(null);
        username_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                username_txtFocusGained(evt);
            }
        });
        username_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                username_txtMouseClicked(evt);
            }
        });
        username_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                username_txtKeyTyped(evt);
            }
        });
        Login_Panel.add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 302, 40));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(80, 80, 80));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tài khoản");
        Login_Panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 333, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(80, 80, 80));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Email");
        Login_Panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 333, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(80, 80, 80));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Email");
        Login_Panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 333, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Login_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleName("LOGIN");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwd_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwd_txtMouseClicked
       
    }//GEN-LAST:event_passwd_txtMouseClicked

    private void passwd_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwd_txtFocusGained
      
    }//GEN-LAST:event_passwd_txtFocusGained

    private void email_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_email_txtMouseClicked
        
    }//GEN-LAST:event_email_txtMouseClicked

    private void email_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email_txtFocusGained
        
    }//GEN-LAST:event_email_txtFocusGained

   
    
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String manv = username_txt.getText();
        String email = email_txt.getText();
        if (submit.getText().equals("Xác minh")) {

            if (manv.isBlank() || email.isBlank()) {
                msg.setText("Không được để trống!");
                return;
            }
            
            if (nhanvienBUS.findbyId(manv)== null) {
                msg.setForeground(Color.red);
                msg.setText("Sai tài khoản hoặc email!");
                return;
            }
                   
            isVerify = nhanvienBUS.getEmailByMaNV(manv).equals(email);
            if (isVerify) {
                if (accountsBUS.sendCode(email)) {
                    submit.setText("Tiếp tục");
                    username_txt.setEnabled(false);
                    email_txt.setEnabled(false);
                    passwd_txt.setEnabled(isVerify);
                    code_txt.setEnabled(isVerify);
                    msg.setForeground(Color.green);
                    msg.setText("Mã xác minh đã được gửi qua Email!"); 
                    isSuccess = true;
                }
            }else {
                 msg.setForeground(Color.red);
                 msg.setText("Sai tài khoản hoặc email!");
                 return;
            }
        }else{
            if (isVerify && isSuccess) {
                String pass = String.valueOf(passwd_txt.getPassword());
                String code = code_txt.getText();
                if (pass.isBlank() || code.isBlank()) {
                    msg.setForeground(Color.red);
                    msg.setText("Không được để trống!");
                    return;
                }
                
                if (accountsBUS.validateCode(code)) {
                    AccountsDTO acc = accountsBUS.findbyUsername(manv);
                    acc.setPassword(pass);
                    if (accountsBUS.updatePassword(acc)) {
                       msg.setForeground(Color.green);
                        msg.setText("Đổi mật khẩu thành công!");
                        Timer timer = new Timer(1000, e -> {
                            this.setVisible(false);
                            new Login().setVisible(true);
                            ((Timer) e.getSource()).stop();
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                }
                
            }
            
        }
        
    }//GEN-LAST:event_submitActionPerformed

    
    
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if ( passwd_txt.getEchoChar() != '\u0000' ) {
            passwd_txt.setEchoChar('\u0000');
            passwd_txt.requestFocus();
        } else {
            passwd_txt.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            passwd_txt.requestFocus();
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void quenmatkhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quenmatkhauMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt)) {
            this.setVisible(false);
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_quenmatkhauMouseClicked

    private void quenmatkhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quenmatkhauMouseEntered
        quenmatkhau.setForeground(Color.decode("#1da1f2"));
    }//GEN-LAST:event_quenmatkhauMouseEntered

    private void quenmatkhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quenmatkhauMouseExited
        quenmatkhau.setForeground(Color.decode("#0d2aaf"));
    }//GEN-LAST:event_quenmatkhauMouseExited

    private void email_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_email_txtKeyTyped
        jLabel4.setForeground(Color.decode("#505050"));
    }//GEN-LAST:event_email_txtKeyTyped

    private void passwd_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwd_txtKeyTyped
        jLabel7.setForeground(Color.decode("#505050"));
    }//GEN-LAST:event_passwd_txtKeyTyped

    private void code_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_code_txtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_code_txtFocusGained

    private void code_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_code_txtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_code_txtMouseClicked

    private void code_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code_txtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_code_txtKeyTyped

    private void username_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_txtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_username_txtFocusGained

    private void username_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_username_txtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_username_txtMouseClicked

    private void username_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_txtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_username_txtKeyTyped
    
   
    
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Regist().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.login.Login_Panel Login_Panel;
    private javax.swing.JTextField code_txt;
    private javax.swing.JTextField email_txt;
    private Main.login.Exit exit1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel msg;
    private javax.swing.JPasswordField passwd_txt;
    private javax.swing.JLabel quenmatkhau;
    private Main.login.Button submit;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
