package service;

import javafx.scene.control.TextArea;
import model.FileModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Krzysztof on 2017-01-10.
 */
public class SaveService {

    protected TextArea textArea;;
    protected FileModel fileModel;

    //---------------------------CONSTRUCTOR---------------------------------

    public SaveService(TextArea textArea, FileModel fileModel){
        this.textArea = textArea;
        this.fileModel = fileModel;
    }



    //--------------------FUNCTIONALITY METHODS-----------------------

    /**
     * writeToFile Method - Writes text from TextArea (actually from FileModel's contentBeforeSave field) to a file.txt
     * where file - name of txt file
     * **/
    protected void writeToFile(String textContent, File savedFile) throws IOException {

        fileModel.setEssentialFields(savedFile.getAbsolutePath(), savedFile.getName(), textContent, true);
        FileWriter fileWriter = new FileWriter(savedFile);
        PrintWriter writer = new PrintWriter(fileWriter);
        Scanner inputText = new Scanner(textContent);

        while (inputText.hasNextLine()) {
            writer.print(inputText.nextLine());
            if (inputText.hasNextLine()) {
                writer.print("\r\n");
            }
        }
        writer.close();
        inputText.close();

    }
}
