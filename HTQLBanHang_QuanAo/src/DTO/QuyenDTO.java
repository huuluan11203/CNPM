package DTO;

public class QuyenDTO {
    private String maquyen; // Mã quyền
    private String tenquyen; // Tên quyền

    // Constructor mặc định
    public QuyenDTO() {
    }

    // Constructor có tham số
    public QuyenDTO(String maquyen, String tenquyen) {
        this.maquyen = maquyen;
        this.tenquyen = tenquyen;
    }

    // Getter và Setter cho thuộc tính maquyen
    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }

    // Getter và Setter cho thuộc tính tenquyen
    public String getTenquyen() {
        return tenquyen;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }

    // Override phương thức toString để hiển thị tên quyền trong ComboBox
    @Override
    public String toString() {
        return tenquyen; // Hiển thị tên quyền khi sử dụng trong giao diện
    }
}
