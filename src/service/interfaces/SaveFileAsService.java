package service.interfaces;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.FileModel;
import service.SaveService;

import java.io.File;
import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-10.
 */
public class SaveFileAsService extends SaveService implements FileOperation{

    public SaveFileAsService(TextArea textArea, FileModel fileModel) {
        super(textArea, fileModel);
    }


    /**
     * Method that provices saving file as new file.
     * @param notepadWindow Stage object that is needed by FileChooser to open dialog pop up.
     * **/
    @Override
    public void performOperation(Stage notepadWindow) throws IOException {

        String textContent = fileModel.getFileContentBeforeSave();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("All files (*.*)","*.*")
        );

        File savedFile = fileChooser.showSaveDialog(notepadWindow);

        if (savedFile != null) {
            writeToFile(textContent, savedFile);
            notepadWindow.setTitle(fileModel.getName());
        }

    }
}
