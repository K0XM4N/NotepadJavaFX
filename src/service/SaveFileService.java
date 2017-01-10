package service;

import javafx.scene.control.TextArea;
import model.FileModel;

/**
 * Created by Krzysztof on 2017-01-10.
 */
public class SaveFileService  extends SaveService{

    public SaveFileService(TextArea textArea, FileModel fileModel) {
        super(textArea, fileModel);
    }
}
