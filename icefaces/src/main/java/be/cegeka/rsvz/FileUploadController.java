package be.cegeka.rsvz;

import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "fileUpload")
@SessionScoped
public class FileUploadController implements Serializable {

    private String message;

    public void uploadFile(FileEntryEvent event) {
        FileEntry fileEntry = (FileEntry) event.getSource();
        FileEntryResults results = fileEntry.getResults();

        if(results.getFiles().size() > 1) {
            throw new IllegalStateException("Multiple file upload not supported");
        }

        for (FileEntryResults.FileInfo fileInfo : results.getFiles()) {
            System.out.println("file name = " + fileInfo.getFileName());
        }
    }

}
