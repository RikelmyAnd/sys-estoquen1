package org.sysestoquen1.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.sysestoquen1.model.Produto;
import org.sysestoquen1.utils.PathFXML;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(new FileInputStream(PathFXML.pathFXML() + "\\MainView.fxml"));
        Scene scene = new Scene(root, 450, 600);
        stage.setTitle("Controle de Estoque");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
            Application.launch(Main.class, args);
        }
}
