/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class QuanAoDTO {
    private String masp;       
    private String tensp;        
    private String anh;         
    private int giaban;        
    private int soluongtonkho;  
    private int trangthai;       
    private String makm;        
    private String matheloai;    


    public QuanAoDTO() {
    }


    public QuanAoDTO(String masp, String tensp, String anh, int giaban, int soluongtonkho, int trangthai, String makm, String matheloai) {
        this.masp = masp;
        this.tensp = tensp;
        this.anh = anh;
        this.giaban = giaban;
        this.soluongtonkho = soluongtonkho;
        this.trangthai = trangthai;
        this.makm = makm;
        this.matheloai = matheloai;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getSoluongtonkho() {
        return soluongtonkho;
    }

    public void setSoluongtonkho(int soluongtonkho) {
        this.soluongtonkho = soluongtonkho;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }
}
