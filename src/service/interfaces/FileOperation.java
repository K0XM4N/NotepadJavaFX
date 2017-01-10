package service.interfaces;

import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-10.
 */
public interface FileOperation {
    public void performOperation(Stage notepadWindow) throws IOException;
}
