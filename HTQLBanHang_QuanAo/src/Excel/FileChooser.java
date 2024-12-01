/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;
import java.awt.*;
/**
 *
 * @author ACER
 */


public class FileChooser {
    public static String chooseFile(Frame parent, String extension) {
        FileDialog fileDialog = new FileDialog(parent, "Chọn vị trí lưu file", FileDialog.SAVE);
        fileDialog.setFile("*.xlsx");
        fileDialog.setVisible(true);
        String directory = fileDialog.getDirectory();
        String fileName = fileDialog.getFile();

        if (directory != null && fileName != null) {
            if (!fileName.endsWith(extension)) {
                fileName += extension;
            }
            return directory + fileName;
        }

        return null;
    }
}

