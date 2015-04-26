package pruebaventanas;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PruebaVentanas extends Application {

    private Stage stagePrincipal;
    private AnchorPane rootPane;
    private TextField user;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();

    }

    /*
     * cargamos la ventana principal
     */
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("VentanaPrincipal.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Ventana Principal");
            stagePrincipal.setScene(scene);
            VentanaPrincipalController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stagePrincipal.show();
        } catch (IOException e) {
        }
    }

    public void mostrarVentanaSecundaria() {
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("VentanaDos.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Dos");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            VentanaDosController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();

        } catch (Exception e) {
        }
    }
    public void mostrarVentanaPresupuesto() {
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("Prueba2.fxml"));
            AnchorPane prueba3 = (AnchorPane) loader.load();
            Stage ventana3 = new Stage();
            ventana3.setTitle("Nuevo Presupuesto");
            ventana3.initOwner(stagePrincipal);
            Scene scene = new Scene(prueba3);
            ventana3.setScene(scene);
            Prueba2Controller controller = loader.getController();
            controller.setStagePrincipal(ventana3);
            ventana3.show();

        } catch (Exception e) {
        }
    }
    public void salir(){
        stagePrincipal.close();
    }

    public void login(){
         try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("loginvendedor.fxml"));
            AnchorPane login = (AnchorPane) loader.load();
            Stage ventanalogin = new Stage();
            ventanalogin.setTitle("Inicio de Sesión");
            ventanalogin.initOwner(stagePrincipal);
            Scene scene = new Scene(login);
            ventanalogin.setScene(scene);
            LoginvendedorController controller = loader.getController();
            controller.setStagePrincipal(ventanalogin);
            ventanalogin.show();

        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}