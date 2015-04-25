package pruebaventanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class VentanaPrincipalController implements Initializable {

    private PruebaVentanas ProgramaPrincipal;

    @FXML
    private void nuevaVentana(ActionEvent event) {
        ProgramaPrincipal.mostrarVentanaSecundaria();
    }
    @FXML
    private void nuevaVentana2(ActionEvent event) {
        ProgramaPrincipal.mostrarVentanaPresupuesto();
    }
    @FXML
    private void salirVentana(ActionEvent event) {
        ProgramaPrincipal.salir();
    }

    public void setProgramaPrincipal(PruebaVentanas ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}