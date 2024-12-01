/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */

public class TheLoaiDTO {
    private String matheloai;
    private String tentheloai;
    private String maloaiquanao;

    public TheLoaiDTO() {
    }

    public TheLoaiDTO(String matheloai, String tentheloai, String maloaiquanao) {
        this.matheloai = matheloai;
        this.tentheloai = tentheloai;
        this.maloaiquanao = maloaiquanao;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getMaloaiquanao() {
        return maloaiquanao;
    }

    public void setMaloaiquanao(String maloaiquanao) {
        this.maloaiquanao = maloaiquanao;
    }
}

