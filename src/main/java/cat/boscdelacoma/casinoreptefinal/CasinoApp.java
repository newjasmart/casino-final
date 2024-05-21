package cat.boscdelacoma.casinoreptefinal;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CasinoApp extends Application {
    private MySQLDatabase mySQLDatabase = new MySQLDatabase();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestió del Casino");

        Label label = new Label("Gestió del Casino");
        ListView<String> listViewClients = new ListView<>();
        ListView<String> listViewJocs = new ListView<>();
        
        TextField txtNomClient = new TextField();
        TextField txtDniClient = new TextField();
        TextField txtPuntsFidelitat = new TextField();
        
        TextField txtNomJoc = new TextField();
        TextField txtTipusJoc = new TextField();
        
        Button btnAfegirClient = new Button("Afegir Client");
        Button btnAfegirJoc = new Button("Afegir Joc");
        
        Button btnLoadClients = new Button("Carregar Clients");
        Button btnLoadJocs = new Button("Carregar Jocs");
        
        Button btnActualitzarClient = new Button("Actualitzar Client");
        Button btnActualitzarJoc = new Button("Actualitzar Joc");
        
        Button btnEliminarClient = new Button("Eliminar Client");
        Button btnEliminarJoc = new Button("Eliminar Joc");


        // Event handlers per afegir clients i jocs
        btnAfegirClient.setOnAction(e -> {
            String nom = txtNomClient.getText();
            String dni = txtDniClient.getText();
            int puntsFidelitat = Integer.parseInt(txtPuntsFidelitat.getText());
            Client client = new Client(nom, dni, puntsFidelitat);
            mySQLDatabase.inserirClient(client);
            btnLoadClients.fire();
        });

        btnAfegirJoc.setOnAction(e -> {
            String nom = txtNomJoc.getText();
            String tipus = txtTipusJoc.getText();
            Joc joc = new Joc(nom, tipus);
            mySQLDatabase.inserirJoc(joc);
            btnLoadJocs.fire();
        });

        // Event handlers per carregar clients i jocs
        btnLoadClients.setOnAction(e -> {
            listViewClients.getItems().clear();
            List<Client> clients = mySQLDatabase.obtenirClients();
            for (Client client : clients) {
                listViewClients.getItems().add(client.getNom() + " - " + client.getDni() + " - " + client.getPuntsFidelitat());
            }
        });

        btnLoadJocs.setOnAction(e -> {
            listViewJocs.getItems().clear();
            List<Joc> jocs = mySQLDatabase.obtenirJocs();
            for (Joc joc : jocs) {
                listViewJocs.getItems().add(joc.getNom() + " - " + joc.getTipus());
            }
        });
        
        // Event handlers per actualitzar clients i jocs
        btnActualitzarClient.setOnAction(e -> {
            String selectedItem = listViewClients.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Aquí pots implementar la lògica per mostrar una finestra de diàleg per a l'actualització del client seleccionat
            } else {
                // Mostra un missatge d'error si no s'ha seleccionat cap client
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Si us plau, selecciona un client per actualitzar.");
                alert.showAndWait();
            }
        });

        btnEliminarClient.setOnAction(e -> {
            String selectedItem = listViewClients.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Aquí pots implementar la lògica per eliminar el client seleccionat
                String dni = selectedItem.split(" - ")[1];
                mySQLDatabase.eliminarClient(dni);
                btnLoadClients.fire(); // Torna a carregar la llista de clients després de l'eliminació
            } else {
                // Mostra un missatge d'error si no s'ha seleccionat cap client
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Si us plau, selecciona un client per eliminar.");
                alert.showAndWait();
            }
        });

        btnActualitzarJoc.setOnAction(e -> {
            String selectedItem = listViewJocs.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Aquí pots implementar la lògica per mostrar una finestra de diàleg per a l'actualització del joc seleccionat
            } else {
                // Mostra un missatge d'error si no s'ha seleccionat cap joc
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Si us plau, selecciona un joc per actualitzar.");
                alert.showAndWait();
            }
        });

        btnEliminarJoc.setOnAction(e -> {
            String selectedItem = listViewJocs.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Aquí pots implementar la lògica per eliminar el joc seleccionat
                String nomJoc = selectedItem.split(" - ")[0];
                mySQLDatabase.eliminarJoc(nomJoc);
                btnLoadJocs.fire(); // Torna a carregar la llista de jocs després de l'eliminació
            } else {
                // Mostra un missatge d'error si no s'ha seleccionat cap joc
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Si us plau, selecciona un joc per eliminar.");
                alert.showAndWait();
            }
        });


        VBox vbox = new VBox(
            label,
            new Label("Clients:"),
            listViewClients,
            new Label("Nom Client:"),
            txtNomClient,
            new Label("DNI Client:"),
            txtDniClient,
            new Label("Punts de Fidelitat:"),
            txtPuntsFidelitat,
            btnAfegirClient,
            btnActualitzarClient,
            btnEliminarClient,
            btnLoadClients,
            new Label("Jocs:"),
            listViewJocs,
            new Label("Nom Joc:"),
            txtNomJoc,
            new Label("Tipus Joc:"),
            txtTipusJoc,
            btnAfegirJoc,
            btnActualitzarJoc,
            btnEliminarJoc,
            btnLoadJocs
        );

        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
