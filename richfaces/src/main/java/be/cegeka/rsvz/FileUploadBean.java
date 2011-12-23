package be.cegeka.rsvz;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "fileUpload")
@SessionScoped
public class FileUploadBean implements Serializable {

    private static final String BASE_FILE_PATH = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator");

    List<UploadedFile> files = new ArrayList<UploadedFile>();

    public void uploadFileListener(FileUploadEvent event) {
        UploadedFile file = event.getUploadedFile();
        saveFileToDisk(file);
        files.add(file);
    }

    private void saveFileToDisk(UploadedFile file) {

        File diskFile = new File(BASE_FILE_PATH + file.getName());
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(diskFile);
            fileOut.write(file.getData());
        } catch (Exception e) {
            System.out.println("File " + file.getName() + "couldn't be created on disk.");
            e.printStackTrace();
        } finally {
            try {
                if (fileOut != null)
                    fileOut.close();
            } catch (IOException ex) {
                System.out.println("Error closing FileOutputStream.");
            }

        }

    }

}
