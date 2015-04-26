/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaventanas;

import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/*
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ale
 */
public class LoginvendedorController implements Initializable {
     private Stage stagePrincipal;
     @FXML
    public TextField user;
    @FXML
    public PasswordField pass;
    @FXML
    private PruebaVentanas ProgramaPrincipal;
    /*
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }*/
    public void setProgramaPrincipal(PruebaVentanas ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
    @FXML
    private void salirVentana(ActionEvent event) {
        stagePrincipal.close();
    }
    
    @FXML
    private void IniciarSesion(ActionEvent event){
        int bandera=0;
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/concurso","root","");
                Statement estado = con.createStatement();
                ResultSet resultado;
                resultado = estado.executeQuery("SELECT * FROM `vendedor` WHERE usuario = '"+ user.getText() +"' and password = '"+ pass.getText() +"'");               
                while(resultado.next()){
                    if(resultado.getString("usuario").equals(user.getText()) && resultado.getString("password").equals(pass.getText())){
                        bandera=1;
                    }
                }
                  
        }
        catch(SQLException e){
            System.out.println("Error de mysql");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Se ha encontrado  "+ e.getMessage());
        }  
        if(bandera==1){
            ProgramaPrincipal.mostrarVentanaPrincipal();
            System.out.println("Listo");    
        }else{
            System.out.println("Error en usuario y/o contraseña");
                
        }
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
