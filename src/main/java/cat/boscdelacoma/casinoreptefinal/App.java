package cat.boscdelacoma.casinoreptefinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona la base de dades:");
        System.out.println("1. MySQL");
        System.out.println("2. ObjectDB");
        int eleccio = scanner.nextInt();

        if (eleccio == 1) {
            MySQLDatabase db = new MySQLDatabase();
            // Treballar amb MySQL
        } else if (eleccio == 2) {
          //  ObjectDBDatabase db = new ObjectDBDatabase();
            // Treballar amb ObjectDB
        } else {
            System.out.println("Elecció no vàlida");
        }
    }
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}