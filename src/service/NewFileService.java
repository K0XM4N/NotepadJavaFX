package service;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.FileModel;
import service.interfaces.FileOperation;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-10.
 */
public class NewFileService implements FileOperation {

    private TextArea textArea;
    private FileModel fileModel;
    private NotSavedService notSavedService;

    public NewFileService(TextArea textArea, FileModel fileModel, NotSavedService notSavedService){
        this.textArea = textArea;
        this.fileModel = fileModel;
        this.notSavedService = notSavedService;
    }


    /**
     *  Method that allows to create a new file, also handle problem if file need to be
     *  saved.
     *  @param notepadWindow Stage object that is needed by FileChooser to open dialog pop up.
     * **/
    @Override
    public void performOperation(Stage notepadWindow) throws IOException {

        fileModel.setFileContentBeforeSave(textArea.getText());
        fileModel.checkSaveStatus();

        if (fileModel.getFileContentBeforeSave().isEmpty() || fileModel.getIsSaved()){

            textArea.clear();
            fileModel.setDefaultSettings();
            notepadWindow.setTitle(fileModel.getName());
            System.out.println("SAVED -> OPEN NEW FILE");

        }
        else{

            System.out.println("NOT SAVED -> ASK USER TO SAVE OR NOT");
            notSavedService.setNotepadWindow(notepadWindow);
            notSavedService.loadMessageWindow(this);

        }

    }
}
