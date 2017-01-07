package service;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.FileModel;

/**
 * Created by Krzysztof on 2017-01-07.
 */
public class CreatingNewFileService {
    private TextArea textArea;
    private FileModel fileModel;

    public CreatingNewFileService(TextArea textArea, FileModel fileModel){
        this.textArea = textArea;
        this.fileModel = fileModel;
    }

    public void createNewFile(Stage window){

        fileModel.setFileContentBeforeSave(textArea.getText());
        fileModel.isSaved();

        if (fileModel.getFileContentBeforeSave().isEmpty() || fileModel.getIsSaved()){
            textArea.clear();
            fileModel.setDefaultSettings();
            window.setTitle(fileModel.getName());
            System.out.println("SAVED -> OPEN NEW FILE");
        }
        else{
            System.out.println("NOT SAVED -> ASK USER TO SAVE OR NOT");
        }
    }
}
