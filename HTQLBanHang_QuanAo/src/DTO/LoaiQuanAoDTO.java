/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class LoaiQuanAoDTO {
    private String maloaiquanao;
    private String tenloaiquanao;

    public LoaiQuanAoDTO() {
    }

    public LoaiQuanAoDTO(String maloaiquanao, String tenloaiquanao) {
        this.maloaiquanao = maloaiquanao;
        this.tenloaiquanao = tenloaiquanao;
    }

    public String getMaloaiquanao() {
        return maloaiquanao;
    }

    public void setMaloaiquanao(String maloaiquanao) {
        this.maloaiquanao = maloaiquanao;
    }

    public String getTenloaiquanao() {
        return tenloaiquanao;
    }

    public void setTenloaiquanao(String tenloaiquanao) {
        this.tenloaiquanao = tenloaiquanao;
    }
}
