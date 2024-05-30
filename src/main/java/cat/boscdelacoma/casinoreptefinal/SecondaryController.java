package cat.boscdelacoma.casinoreptefinal;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        CasinoApp.setRoot("primary");
    }
}