/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Main;

/**
 *
 * @author ACER
 */
import DTO.UserDTO;
import GUI.Main.Menu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import GUI.Panel.TrangChuPanel;

public class TrangChuGUI extends JFrame {

    private UserDTO user;
    private String username;
    
    public JPanel MainContent;
    Menu menuTaskbar;
    Color MainColor = new Color(250, 250, 250);
    
    private TrangChuPanel trangChu;
    public TrangChuGUI(UserDTO user, String username){
        this.user = user;
        this.username = username;
        this.initComponent();
    }
    private void initComponent() {
        this.setSize(new Dimension(1400, 800));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0, 0));
        this.setTitle("Cửa hàng bán quần áo ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainContent = new JPanel();
        MainContent.setBackground(MainColor);
        MainContent.setLayout(new BorderLayout(0, 0));
        
        menuTaskbar=new Menu(user.getTenNV(), username, this);
        
        this.add(menuTaskbar,BorderLayout.WEST);

        this.add(MainContent, BorderLayout.CENTER);

        trangChu = new TrangChuPanel();
        MainContent.add(trangChu).setVisible(true);
    }

    public void setPanel(JPanel pn) {
        MainContent.removeAll();
        MainContent.add(pn).setVisible(true);
        MainContent.repaint();
        MainContent.validate();
    }
}
