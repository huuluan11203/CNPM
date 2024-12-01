
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




public class Login extends javax.swing.JFrame {


    
    public Login() {
        
        FlatLightLaf.setup();
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
        
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login_Panel = new Main.login.Login_Panel();
        Tittle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        passwd_txt = new javax.swing.JPasswordField();
        exit1 = new Main.login.Exit();
        submit = new Main.login.Button();
        jCheckBox1 = new javax.swing.JCheckBox();
        quenmatkhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Login_Panel.setForeground(new java.awt.Color(255, 153, 153));
        Login_Panel.setMaximumSize(new java.awt.Dimension(400, 500));
        Login_Panel.setMinimumSize(new java.awt.Dimension(400, 500));
        Login_Panel.setPreferredSize(new java.awt.Dimension(400, 500));
        Login_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tittle.setFont(new java.awt.Font("Arial", 1, 44)); // NOI18N
        Tittle.setForeground(Color.decode("#1da1f2")
        );
        Tittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tittle.setText("ĐĂNG NHẬP");
        Login_Panel.add(Tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 90));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Tài khoản");
        Login_Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 168, 333, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(80, 80, 80));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mật khẩu");
        Login_Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 233, 240, -1));

        jLabel4.setForeground(new java.awt.Color(80, 80, 80));
        jLabel4.setText("_______________________________________________________________");
        Login_Panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 201, 302, -1));

        msg.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        msg.setForeground(Color.red
        );
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login_Panel.add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 300, 26));

        jLabel7.setForeground(new java.awt.Color(80, 80, 80));
        jLabel7.setText("_______________________________________________________________");
        Login_Panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 269, 302, -1));

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
        Login_Panel.add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 182, 302, 40));

        passwd_txt.setBackground(new Color(0,0,0,0));
        passwd_txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        passwd_txt.setBorder(null);
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
        Login_Panel.add(passwd_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 249, 302, 40));

        exit1.setForeground(new java.awt.Color(255, 255, 255));
        Login_Panel.add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        submit.setBackground(Color.decode("#1da1f2")
        );
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Đăng nhập");
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
        quenmatkhau.setText("Quên mật khẩu");
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
        Login_Panel.add(quenmatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, -1, 26));

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

    private void username_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_username_txtMouseClicked
        
    }//GEN-LAST:event_username_txtMouseClicked

    private void username_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_txtFocusGained
        
    }//GEN-LAST:event_username_txtFocusGained

   
    
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
      

        doLogin();
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
            new Regist().setVisible(true);
        }
    }//GEN-LAST:event_quenmatkhauMouseClicked

    private void quenmatkhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quenmatkhauMouseEntered
        quenmatkhau.setForeground(Color.decode("#1da1f2"));
    }//GEN-LAST:event_quenmatkhauMouseEntered

    private void quenmatkhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quenmatkhauMouseExited
        quenmatkhau.setForeground(Color.decode("#0d2aaf"));
    }//GEN-LAST:event_quenmatkhauMouseExited

    private void username_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_txtKeyTyped
        jLabel4.setForeground(Color.decode("#505050"));
    }//GEN-LAST:event_username_txtKeyTyped

    private void passwd_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwd_txtKeyTyped
        jLabel7.setForeground(Color.decode("#505050"));
    }//GEN-LAST:event_passwd_txtKeyTyped
    
   
    private void doLogin() {
        String username = username_txt.getText();
        String password = String.valueOf(passwd_txt.getPassword());
        
        if (username.isBlank()) {
            jLabel4.setForeground(Color.red);
            username_txt.requestFocus();
            
        }else if (password.isBlank()) {
            jLabel7.setForeground(Color.red);
            passwd_txt.requestFocus();

        } else {
            AccountsBUS accountsBUS = new AccountsBUS();
            AccountsDTO acc = accountsBUS.login(username, password);
            if (acc != null) {
                msg.setForeground(Color.green);
                msg.setText("Đăng nhập thành công!");

                UserDTO user = new UserBUS().findbyId(acc.getId());
                
                Timer timer = new Timer(1000, e -> { 
                    this.setVisible(false);
                    new TrangChuGUI(user, username).setVisible(true);
                    ((Timer) e.getSource()).stop(); 
                });
                timer.setRepeats(false); 
                timer.start();
            } else {
                msg.setForeground(Color.red);
                msg.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
            }
        }
        
        
    }
    
   
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
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.login.Login_Panel Login_Panel;
    private javax.swing.JLabel Tittle;
    private Main.login.Exit exit1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel msg;
    private javax.swing.JPasswordField passwd_txt;
    private javax.swing.JLabel quenmatkhau;
    private Main.login.Button submit;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
