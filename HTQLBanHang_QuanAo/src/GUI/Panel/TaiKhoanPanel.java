/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;
import javax.swing.*;
import java.awt.*;
import DTO.*;
import BUS.*;
import Excel.*;
import GUI.Dialog.SanPhamDialog;
import GUI.Dialog.SanPhamThuocTinh;
import GUI.Dialog.TaiKhoanDialog;
import GUI.Main.TrangChuGUI;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class TaiKhoanPanel extends javax.swing.JPanel {

    private TrangChuGUI trangChuGUI;
    private AccountsBUS accountsBUS;
    private QuyenBUS quyenBUS;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> sorter;

    public TaiKhoanPanel(TrangChuGUI trangChuGUI) {
        accountsBUS = new AccountsBUS();
        quyenBUS = new QuyenBUS();
        this.trangChuGUI = trangChuGUI;
        initComponents();

        loadQuyenToComboBox(quyencbx);
        loadAccToTable(jTable1);

        customizeScrollPane(jScrollPane1);
        customizeComboBox(quyencbx);
        customizeTable(jTable1);
        addHoverEffect(jButton8);
        addHoverEffect(jButton9);
        addHoverEffect(jButton12);
        setPlaceholder(jTextField1, "Nhập Tài Khoản Cần Tìm");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        quyencbx = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(250, 250, 255));
        setMaximumSize(new java.awt.Dimension(1150, 800));
        setMinimumSize(new java.awt.Dimension(1150, 800));
        setPreferredSize(new java.awt.Dimension(1150, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton8.setBackground(new java.awt.Color(255, 255, 254));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 153, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton8.setText("Xóa");
        jButton8.setToolTipText("");
        jButton8.setAutoscrolls(true);
        jButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton8.setBorderPainted(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 254));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 153, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        jButton9.setText("Sửa");
        jButton9.setToolTipText("");
        jButton9.setAutoscrolls(true);
        jButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton9.setBorderPainted(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 254));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 153, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        jButton12.setText("Xuất excel");
        jButton12.setToolTipText("");
        jButton12.setAutoscrolls(true);
        jButton12.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton12.setBorderPainted(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        quyencbx.setMaximumRowCount(30);
        quyencbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quyencbxActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(259, 39));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
            .addComponent(jTextField1)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 485, Short.MAX_VALUE)
                .addComponent(quyencbx, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(quyencbx, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jTable1.setBackground(new java.awt.Color(254, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên Đăng Nhập", "Quyền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
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

    public void customizeScrollPane(JScrollPane scrollPane) {
        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(200, 200, 200);
                this.trackColor = new Color(240, 240, 240);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                return button;
            }

            // Điều chỉnh chiều rộng thanh cuộn
            @Override
            public Dimension getPreferredSize(JComponent c) {
                Dimension dim = super.getPreferredSize(c);
                dim.width = 8;
                return dim;
            }
        });
    }
   

     public void loadAccToTable(JTable table) {
        List<AccountsDTO> accList = accountsBUS.getAll();

        // Tạo DefaultTableModel
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
            "Tên Đăng Nhập", "Quyền"});

        // Thêm dữ liệu vào model
        for (AccountsDTO acc : accList) {
            tableModel.addRow(new Object[]{
                acc.getUsername(),
                quyenBUS.getTenQuyen(acc.getQuyen())
            });
        }

        // Gắn model vào JTable
        table.setModel(tableModel);
        sorter = new TableRowSorter<>(tableModel);
        jTable1.setRowSorter(sorter);
        tableModel.fireTableDataChanged();
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


    private void customizeComboBox(javax.swing.JComboBox<String> comboBox) {
//        customizeComboBoxScroll(comboBox);
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
    
    private java.awt.Color adjustBrightness(java.awt.Color color, float factor)
    {
        int r = Math.min((int)(color.getRed() * factor), 255);
        int g = Math.min((int)(color.getGreen() * factor), 255);
        int b = Math.min((int)(color.getBlue() * factor), 255);
        return new java.awt.Color(r, g, b);
    }
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            String tendangnhap = jTable1.getValueAt(selectedRow, 0).toString();

            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa tài khoản: " + tendangnhap + " không?",
                    "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            // Kiểm tra phản hồi của người dùng
            if (confirm == JOptionPane.YES_OPTION) {
                if (accountsBUS.deleteAcc(tendangnhap)) {
                    JOptionPane.showMessageDialog(this, "Xóa tài khoản thành công!", "Thông báo", JOptionPane.PLAIN_MESSAGE);

                    // Cập nhật lại dữ liệu trên bảng
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0); // Xóa dữ liệu cũ
                    loadAccToTable(jTable1);
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa tài khoản thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String tendangnhap = jTable1.getValueAt(selectedRow, 0).toString();
        TaiKhoanDialog sanPhamDialog = new TaiKhoanDialog(trangChuGUI, true, tendangnhap, jTable1);
        sanPhamDialog.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            loadAccToTable(jTable1); // Gọi hàm cập nhật dữ liệu
        }
    });
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       
    }//GEN-LAST:event_jButton12ActionPerformed

    public static List<List<Object>> getDataFromTableModel(DefaultTableModel tableModel) {
        List<List<Object>> data = new ArrayList<>();

        // Lấy tất cả các hàng
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            List<Object> row = new ArrayList<>();
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                row.add(tableModel.getValueAt(i, j));
            }
            data.add(row);
        }

        return data;
    }
    
    private void loadQuyenToComboBox(JComboBox<String> comboBox) {
    List<QuyenDTO> listQuyen = quyenBUS.getAllQuyen();
    comboBox.removeAllItems();
    comboBox.addItem("Tất cả");
    for (QuyenDTO quyen : listQuyen) {
        comboBox.addItem(quyen.getTenquyen());
    }
}

    
    private void quyencbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quyencbxActionPerformed
        String selectedQuyen = (String) quyencbx.getSelectedItem(); // Lấy quyền từ JComboBox
        List<RowFilter<Object, Object>> filters = new ArrayList<>();

        sorter = new TableRowSorter<>(tableModel);
        jTable1.setRowSorter(sorter); // Đặt sorter cho JTable

        if (selectedQuyen != null && !selectedQuyen.equalsIgnoreCase("Tất cả")) {
            // Thêm bộ lọc dựa trên quyền (giả sử quyền ở cột 3)
            filters.add(RowFilter.regexFilter("(?i)" + selectedQuyen, 1)); // Cột 3 là quyền
        }

// Áp dụng bộ lọc
        if (filters.isEmpty()) {
            sorter.setRowFilter(null); // Không có bộ lọc -> Hiển thị tất cả
            loadAccToTable(jTable1);  // Tải lại dữ liệu từ database
        } else {
            sorter.setRowFilter(RowFilter.andFilter(filters)); // Áp dụng bộ lọc
        }


    }//GEN-LAST:event_quyencbxActionPerformed

    
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String keyword=jTextField1.getText().trim().toLowerCase();
        List<AccountsDTO> listTaiKhoan = accountsBUS.getAll();
        String[] columnNames = {"Tên Đăng Nhập", "Quyền"};
        tableModel = new DefaultTableModel(columnNames, 0);

        keyword = keyword.trim().toLowerCase();

        for (AccountsDTO taiKhoan : listTaiKhoan) {
            if (taiKhoan.getUsername().toLowerCase().startsWith(keyword)) {
                Object[] row = {
                    taiKhoan.getUsername(),
                    quyenBUS.getTenQuyen(taiKhoan.getQuyen())
                };
                tableModel.addRow(row);
            }
        }

        jTable1.setModel(tableModel);
        sorter = new TableRowSorter<>(tableModel);
        jTable1.setRowSorter(sorter);
        tableModel.fireTableDataChanged();
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> quyencbx;
    // End of variables declaration//GEN-END:variables
}
