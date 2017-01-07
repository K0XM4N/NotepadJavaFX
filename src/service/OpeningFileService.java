package service;

import javafx.scene.control.TextArea;
import model.FileModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Krzysztof on 2017-01-07.
 */
public class OpeningFileService {
    private TextArea textArea;
    private FileModel fileModel;

    public OpeningFileService(TextArea textArea){
        this.textArea = textArea;
    }


}
