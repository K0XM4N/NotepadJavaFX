package service;

import javafx.scene.control.TextArea;
import model.FileModel;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Krzysztof on 2017-01-10.
 */
public class SaveService {

    protected TextArea textArea;
    protected PrintWriter writer;
    protected FileWriter fileWriter;

    protected FileModel fileModel;

    public SaveService(TextArea textArea, FileModel fileModel){
        this.textArea = textArea;
        this.fileModel = fileModel;
    }
}
