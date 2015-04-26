package pruebaventanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class VentanaPrincipalController implements Initializable {

    private PruebaVentanas ProgramaPrincipal;
    private Stage stagePrincipal;
    @FXML
    private void nuevaVentana(ActionEvent event) {
        ProgramaPrincipal = new PruebaVentanas();
        ProgramaPrincipal.mostrarVentanaSecundaria();
    }
    @FXML
    private void nuevaVentana2(ActionEvent event) {
        ProgramaPrincipal = new PruebaVentanas();
        ProgramaPrincipal.mostrarVentanaPresupuesto();
    }
    @FXML
    private void salirVentana(ActionEvent event) {
        ProgramaPrincipal.salir();
    }

/*
    public void setProgramaPrincipal(PruebaVentanas ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
*/
   public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
        
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}