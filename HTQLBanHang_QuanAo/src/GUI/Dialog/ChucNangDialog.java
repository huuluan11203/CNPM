/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.AccountsBUS;
import BUS.ChucNangBUS;

import BUS.QuyenBUS;
import DTO.AccountsDTO;
import DTO.ChucNangDTO;
import DTO.QuyenDTO;
import GUI.Panel.PhanQuyenPanel;
import java.util.List;
import javax.swing.*; 
import java.awt.*;      
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class ChucNangDialog extends javax.swing.JDialog {


    private JTable jTable;
    private AccountsBUS accountsBUS;
    private QuyenBUS quyenBUS;
    private ChucNangBUS chucNangBUS;
    private String chucnang;
    private String machucnang;
    
    public ChucNangDialog( java.awt.Frame parent, boolean modal, String chucnang, String macn1) {
        initComponents();
        setLocationRelativeTo(null);
        this.chucnang = chucnang;
        quyenBUS = new QuyenBUS();
        chucNangBUS = new ChucNangBUS();
        this.machucnang = macn1;
        loadQuyenToComboBox(quyencbx3);
       
        if (chucnang.equals("Sua")) {
            quyencbx3.setVisible(false);
            jLabel4.setVisible(false);
            macn.setText(machucnang);
        }else{
             macn.setText(chucNangBUS.getNextId());
        }
        
        this.setVisible(true);
       
    }

    private void loadQuyenToComboBox(JComboBox<String> comboBox) {
        List<QuyenDTO> listQuyen = quyenBUS.getAllQuyen();
        comboBox.removeAllItems();
        for (QuyenDTO quyen : listQuyen) {
            comboBox.addItem(quyen.getTenquyen());
        }
    }

    
    private void customizeTable(javax.swing.JTable table) {
        // Tùy chỉnh Header (cột tiêu đề)
        javax.swing.table.JTableHeader header = table.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        header.setBackground(new java.awt.Color(235, 235, 235));
        header.setForeground(java.awt.Color.BLACK);
        header.setReorderingAllowed(false);
        header.setPreferredSize(new java.awt.Dimension(header.getWidth(), 35));

        header.setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                c.setBackground(new java.awt.Color(230, 230, 230));
                c.setForeground(java.awt.Color.BLACK);
                c.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
                setBorder(javax.swing.BorderFactory.createEmptyBorder());
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                return c;
            }
        });
        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                if (isSelected) {
                    c.setBackground(new java.awt.Color(220, 220, 220));
                    c.setForeground(java.awt.Color.BLACK);
                } else {
                    c.setBackground(java.awt.Color.WHITE);
                    c.setForeground(java.awt.Color.BLACK);
                }

                if (c instanceof javax.swing.JLabel) {
                    javax.swing.JLabel label = (javax.swing.JLabel) c;
                    label.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(220, 220, 220)));
                }

                return c;
            }
        });

        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table.setSelectionBackground(new java.awt.Color(220, 220, 220));
        table.setSelectionForeground(java.awt.Color.BLACK);
        table.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));

        if (table.getParent() instanceof javax.swing.JViewport) {
            javax.swing.JScrollPane scrollPane = (javax.swing.JScrollPane) table.getParent().getParent();
            scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        }
    }
    
    public void setPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
    
   
    private void customizeComboBox(javax.swing.JComboBox<String> comboBox) {
        comboBox.setFocusable(false);

        comboBox.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        comboBox.setForeground(new java.awt.Color(50, 50, 50));
        comboBox.setBackground(new java.awt.Color(255, 255, 255));

        comboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150), 1));

        comboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        comboBox.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus
            ) {
                java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (isSelected) {
                    setBackground(new java.awt.Color(0, 153, 255));
                    setForeground(java.awt.Color.WHITE);
                } else {
                    setBackground(java.awt.Color.WHITE);
                    setForeground(new java.awt.Color(50, 50, 50));
                }

                setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));

                return c;
            }
        });

        comboBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setPreferredSize(new java.awt.Dimension(20, 20));

                button.setIcon(new javax.swing.ImageIcon(new java.awt.image.BufferedImage(20, 20, java.awt.image.BufferedImage.TYPE_INT_ARGB) {
                    {
                        java.awt.Graphics2D g2 = createGraphics();
                        g2.setColor(new java.awt.Color(100, 100, 100));
                        g2.fillPolygon(new int[] {5, 15, 10}, new int[] {8, 8, 14}, 3);
                        g2.dispose();
                    }
                }));

                return button;
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                g.setColor(new java.awt.Color(255, 255, 255));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });
    }



    private void addHoverEffect(javax.swing.JButton button) {
        button.setFocusPainted(false);
        java.awt.Color originalColor = button.getBackground();
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(adjustBrightness(originalColor, 0.9f));
                button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }
    
    
    
    private java.awt.Color adjustBrightness(java.awt.Color color, float factor) {
        int r = Math.min((int)(color.getRed() * factor), 255);
        int g = Math.min((int)(color.getGreen() * factor), 255);
        int b = Math.min((int)(color.getBlue() * factor), 255);
        return new java.awt.Color(r, g, b);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tencn = new javax.swing.JTextField();
        macn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quyencbx3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chức Năng");
        jLabel1.setOpaque(true);

        jButton2.setBackground(new java.awt.Color(204, 51, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Hủy bỏ");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Đồng ý");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tencn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tencnActionPerformed(evt);
            }
        });

        macn.setEnabled(false);
        macn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macnActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Chức Năng");

        jLabel3.setText("Mã Chức Năng");

        quyencbx3.setMaximumRowCount(30);
        quyencbx3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quyencbx3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Quyền");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(macn, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(tencn, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(quyencbx3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(macn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quyencbx3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tencn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
   
   
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (chucnang.equals("Sua")) {
            
            
            
        }else {
            String tenChucNang = tencn.getText().trim();
            String selectedQuyen = (String) quyencbx3.getSelectedItem();

            if (tenChucNang.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tên chức năng không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedQuyen == null || selectedQuyen.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn quyền!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isSuccess = chucNangBUS.addChucNangToQuyen(tenChucNang, selectedQuyen);

            if (isSuccess) {
                JOptionPane.showMessageDialog(this, "Thêm chức năng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Thêm chức năng thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tencnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tencnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tencnActionPerformed

    private void macnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_macnActionPerformed

    private void quyencbx3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quyencbx3ActionPerformed
        String selectedQuyen = (String) quyencbx3.getSelectedItem(); // Lấy quyền từ JComboBox
       

    }//GEN-LAST:event_quyencbx3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField macn;
    private javax.swing.JComboBox<String> quyencbx;
    private javax.swing.JComboBox<String> quyencbx1;
    private javax.swing.JComboBox<String> quyencbx2;
    private javax.swing.JComboBox<String> quyencbx3;
    private javax.swing.JTextField tencn;
    // End of variables declaration//GEN-END:variables
}
