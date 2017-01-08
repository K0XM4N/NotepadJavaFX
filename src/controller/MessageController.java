package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Krzysztof on 2017-01-08.
 */
public class MessageController {

    @FXML
    private Label labelMessage;



    public void handleButtonYes(ActionEvent event) {

    }

    public void handleButtonNo(ActionEvent event) {

    }

    public void handleButtonCancel(ActionEvent event) {

    }

    public void setLabelFileName(String name) {
        labelMessage.setText(labelMessage.getText().replaceAll("\\#FILE",name));
    }
}
