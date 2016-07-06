package desktopcleaner;
// @author Ľudovít "Luigi" Kováč

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DesktopCleaner extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("DesktopCleaner 1.2 (for Windows)");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

}
