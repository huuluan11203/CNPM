/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.KhuyenMaiBUS;
import DTO.QuanAoDTO;
import DTO.LoaiQuanAoDTO;
import DTO.TheLoaiDTO;
import DTO.KhuyenMaiDTO;
import BUS.LoaiQuanAoBUS;
import BUS.QuanAoBUS;
import BUS.TheLoaiBUS;
import GUI.Panel.SanPhamPanel;
import java.util.List;
import javax.swing.*; 
import java.awt.*;      
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.FlowLayout;

/**
 *
 * @author ACER
 */
public class SanPhamDialog extends javax.swing.JDialog {

    /**
     * Creates new form SanPhamDialog
     */
    private String masp;
    private String selectedFilePath="";
    private String chucnang;
    private QuanAoBUS quanAoBUS=new QuanAoBUS();
    private LoaiQuanAoBUS loaiQuanAoBUS =new LoaiQuanAoBUS();
    private KhuyenMaiBUS khuyenMaiBUS =new KhuyenMaiBUS();
    private TheLoaiBUS theLoaiBUS =new TheLoaiBUS();
    private JTable jTable;
    public SanPhamDialog(java.awt.Frame parent, boolean modal,String chucnang,String masp,JTable jTable) {
        super(parent, modal);
        this.chucnang=chucnang;
        this.masp=masp;
        this.jTable=jTable;
        initComponents();
        loadDataToComboBox();
        customizeComboBox(jComboBox1);
        customizeComboBox(jComboBox2);
        customizeComboBox(jComboBox3);
        addHoverEffect(jButton1);
        addHoverEffect(jButton2);
        addHoverEffect(jButton3);
        setLocationRelativeTo(null);
        if(this.chucnang.equals("them")){
            jLabel1.setText("Thêm quần áo");
            jButton1.setText("Thêm mới");
        }
        else{
            jLabel1.setText("Sửa quần áo");
            jButton1.setText("Đồng ý");

            QuanAoDTO quanao = quanAoBUS.getQuanAoByMasp(masp);
            jTextField1.setText(quanao.getTensp());

            jComboBox1.setSelectedItem(loaiQuanAoBUS.getLoaiQuanAoByMaloai(theLoaiBUS.getTheLoaiByMatheloai(quanao.getMatheloai()).getMaloaiquanao()).getTenloaiquanao());
            jComboBox2.setSelectedItem(theLoaiBUS.getTheLoaiByMatheloai(quanao.getMatheloai()).getTentheloai());
            jComboBox3.setSelectedItem(khuyenMaiBUS.getKhuyenMaiByMakm(quanao.getMakm()).getTenkm());
            String imagePath = quanao.getAnh();

            if (imagePath != null && !imagePath.isEmpty()) {
                String basePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "img_quanao" + File.separator;
                String fullImagePath = basePath + imagePath;

                File imageFile = new File(fullImagePath);
                if (imageFile.exists()) {
                    ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(jPanel2.getWidth(), jPanel2.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    JLabel imageLabel = new JLabel(scaledIcon);
                    jPanel2.setLayout(new FlowLayout());
                    jPanel2.removeAll();
                    jPanel2.add(imageLabel);
                    jPanel2.revalidate();
                    jPanel2.repaint();
                } else {
                    JOptionPane.showMessageDialog(this, "Ảnh không tồn tại, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không có ảnh được lưu trữ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
    public void loadDataToComboBox() {
        List<LoaiQuanAoDTO> listLoaiQuanAo = loaiQuanAoBUS.getAllLoaiQuanAo();
        List<TheLoaiDTO> listTheLoai = theLoaiBUS.getAllTheLoai();
        List<KhuyenMaiDTO> listKhuyenMai=khuyenMaiBUS.getAllKhuyenMai();

        DefaultComboBoxModel<String> loaiQuanAoModel = new DefaultComboBoxModel<>();
        for (LoaiQuanAoDTO loaiQuanAo : listLoaiQuanAo) {
            loaiQuanAoModel.addElement(loaiQuanAo.getTenloaiquanao());
        }
        jComboBox1.setModel(loaiQuanAoModel);

        jComboBox1.addActionListener(e -> {
            int selectedIndex = jComboBox1.getSelectedIndex();
            if (selectedIndex >= 0) {
                LoaiQuanAoDTO selectedLoaiQuanAo = listLoaiQuanAo.get(selectedIndex);
                updateTheLoaiComboBox(selectedLoaiQuanAo, listTheLoai);
            }
        });

        if (!listLoaiQuanAo.isEmpty()) {
            jComboBox1.setSelectedIndex(0);
            updateTheLoaiComboBox(listLoaiQuanAo.get(0), listTheLoai);
        }
        DefaultComboBoxModel<String> khuyenMaiModel = new DefaultComboBoxModel<>();
        for(KhuyenMaiDTO khuyenmai : listKhuyenMai){
            khuyenMaiModel.addElement(khuyenmai.getTenkm());
        }
        jComboBox3.setModel(khuyenMaiModel);
        jComboBox3.setSelectedIndex(0);
    }
    private void updateTheLoaiComboBox(LoaiQuanAoDTO selectedLoaiQuanAo, List<TheLoaiDTO> listTheLoai) {
        DefaultComboBoxModel<String> theLoaiModel = new DefaultComboBoxModel<>();
        for (TheLoaiDTO theLoai : listTheLoai) {
            if (theLoai.getMaloaiquanao().equals(selectedLoaiQuanAo.getMaloaiquanao())) {
                theLoaiModel.addElement(theLoai.getTentheloai());
            }
        }
        jComboBox2.setModel(theLoaiModel);

        if (theLoaiModel.getSize() > 0) {
            jComboBox2.setSelectedIndex(0);
        }
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Quần Áo");
        jLabel1.setOpaque(true);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên sản phẩm");

        jLabel4.setText("Khuyến mãi");

        jComboBox1.setMaximumRowCount(30);

        jComboBox2.setMaximumRowCount(30);

        jLabel5.setText("Loại quần áo");

        jLabel6.setText("Thể loại");

        jButton1.setBackground(new java.awt.Color(0, 204, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm mới");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jButton3.setBackground(new java.awt.Color(51, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Chọn ảnh");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel2.setPreferredSize(new java.awt.Dimension(217, 217));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().isEmpty() || selectedFilePath == null ||
            jComboBox2.getSelectedItem() == null || jComboBox3.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đầy đủ thông tin!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(this.chucnang.equals("them")){
            QuanAoDTO quanAoDTO=new QuanAoDTO();
            quanAoDTO.setTensp(jTextField1.getText());
            quanAoDTO.setAnh(selectedFilePath);
            quanAoDTO.setGiaban(0);
            quanAoDTO.setMakm(getByKMName((String)jComboBox3.getSelectedItem()).getMakm());
            quanAoDTO.setMatheloai(getByTLName((String)jComboBox2.getSelectedItem()).getMatheloai());
            quanAoDTO.setTrangthai(1);
            quanAoDTO.setSoluongtonkho(0);
            quanAoDTO.setMasp(quanAoBUS.getNextMasP());
            quanAoBUS.addQuanAo(quanAoDTO);
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.setRowCount(0);
            for (QuanAoDTO item : quanAoBUS.getAllQuanAo()) {
                model.addRow(new Object[]{
                    item.getMasp(),
                    item.getTensp(),
                    item.getGiaban(),
                    item.getMatheloai(),
                    item.getMakm(),
                    item.getSoluongtonkho(),
                    item.getAnh()
                });
            }
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            QuanAoDTO quanAoDTO=new QuanAoDTO();
            quanAoDTO.setTensp(jTextField1.getText());
            quanAoDTO.setAnh(selectedFilePath);
            quanAoDTO.setGiaban(quanAoBUS.getQuanAoByMasp(this.masp).getGiaban());
            quanAoDTO.setMakm(getByKMName((String)jComboBox3.getSelectedItem()).getMakm());
            quanAoDTO.setMatheloai(getByTLName((String)jComboBox2.getSelectedItem()).getMatheloai());
            quanAoDTO.setTrangthai(1);
            quanAoDTO.setSoluongtonkho(quanAoBUS.getQuanAoByMasp(this.masp).getSoluongtonkho());
            quanAoDTO.setMasp(this.masp);
            quanAoBUS.updateQuanAo(quanAoDTO);
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.setRowCount(0);
            for (QuanAoDTO item : quanAoBUS.getAllQuanAo()) {
                model.addRow(new Object[]{
                    item.getMasp(),
                    item.getTensp(),
                    item.getGiaban(),
                    item.getMatheloai(),
                    item.getMakm(),
                    item.getSoluongtonkho(),
                    item.getAnh()
                });
            }
            JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private KhuyenMaiDTO getByKMName(String khuyenmai){
        List<KhuyenMaiDTO> khuyenMaiDTOs=khuyenMaiBUS.getAllKhuyenMai();
        for(KhuyenMaiDTO khuyenMaiDTO:khuyenMaiDTOs){
            if(khuyenMaiDTO.getTenkm().equals(khuyenmai)){
                return khuyenMaiDTO;
            }
        }
        return null;
    }
    
    private TheLoaiDTO getByTLName(String tentheloai){
        List<TheLoaiDTO> theLoaiDTOs=theLoaiBUS.getAllTheLoai();
        for(TheLoaiDTO theLoaiDTO:theLoaiDTOs){
            if(theLoaiDTO.getTentheloai().equals(tentheloai)){
                return theLoaiDTO;
            }
        }
        return null;
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // Mở FileDialog để người dùng chọn ảnh
        FileDialog fileDialog = new FileDialog(this, "Chọn ảnh", FileDialog.LOAD);
        fileDialog.setFile("*.jpg;*.png;*.jpeg;*.gif");  // Các định dạng ảnh cho phép
        fileDialog.setVisible(true);

        // Kiểm tra xem người dùng có chọn tệp không
        if (fileDialog.getFile() != null) {
            // Lấy đường dẫn tệp ảnh người dùng chọn
            String selectedFilePath = fileDialog.getDirectory() + fileDialog.getFile();
            File selectedFile = new File(selectedFilePath);

            // Đường dẫn đích (thư mục img trong dự án)
            String destinationDir = "src/img_quanao/";  // Cập nhật lại đường dẫn nếu cần
            File destinationFile = new File(destinationDir + selectedFile.getName());

            try {
                // Sao chép ảnh từ nơi chọn vào thư mục đích
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Cập nhật đường dẫn ảnh trong cơ sở dữ liệu nếu cần (ví dụ: quanao.setAnh(destinationFile.getPath()))
                String newImagePath = destinationFile.getPath();

                // Hiển thị ảnh trong jPanel2
                ImageIcon imageIcon = new ImageIcon(newImagePath);
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(jPanel2.getWidth(), jPanel2.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                JLabel imageLabel = new JLabel(scaledIcon);
                jPanel2.setLayout(new FlowLayout());
                jPanel2.removeAll();
                jPanel2.add(imageLabel);
                jPanel2.revalidate();
                jPanel2.repaint();

            } catch (IOException e) {
                // Nếu có lỗi khi sao chép, hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(this, "Không thể tải ảnh. Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
