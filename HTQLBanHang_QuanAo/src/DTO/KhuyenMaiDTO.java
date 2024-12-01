/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.Date;
/**
 *
 * @author ACER
 */

import java.util.Date;

public class KhuyenMaiDTO {
    private String makm;         
    private String tenkm;        
    private String noidung;      
    private Date ngaybatdau;     
    private Date ngayketthuc;   
    private int phantram;        
    private int trangthai;       

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String makm, String tenkm, String noidung, Date ngaybatdau, Date ngayketthuc, int phantram, int trangthai) {
        this.makm = makm;
        this.tenkm = tenkm;
        this.noidung = noidung;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.phantram = phantram;
        this.trangthai = trangthai;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public int getPhantram() {
        return phantram;
    }

    public void setPhantram(int phantram) {
        this.phantram = phantram;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "KhuyenMaiDTO{" +
                "makm='" + makm + '\'' +
                ", tenkm='" + tenkm + '\'' +
                ", noidung='" + noidung + '\'' +
                ", ngaybatdau=" + ngaybatdau +
                ", ngayketthuc=" + ngayketthuc +
                ", phantram=" + phantram +
                ", trangthai=" + trangthai +
                '}';
    }
}


