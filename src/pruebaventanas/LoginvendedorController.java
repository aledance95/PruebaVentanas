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
import javafx.scene.control.Label;
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
    
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
        
      
    }
    
    @FXML
    private void salirVentana(ActionEvent event) {
        stagePrincipal.close();
    }
    
    @FXML
    private void IniciarSesion(ActionEvent event){
        System.out.println("holi");
        try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("entree");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/concurso","root","");
                System.out.println("casi");
                Statement estado = con.createStatement();
                ResultSet resultado;
                resultado = estado.executeQuery("SELECT * FROM `vendedor` WHERE usuario = '"+ user.getText() +"' and password = '"+ pass.getText() +"'");               
                System.out.println("lishto");
                  while(resultado.next()){
                      
                      if(resultado.getString("usuario").equals(user.getText()) && resultado.getString("password").equals(pass.getText())){
                            System.out.println("si son iguales");                  
                      }
                      else{
                          System.out.println("nooson iguales");
                        
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
        stagePrincipal.close();
        ProgramaPrincipal.mostrarVentanaPrincipal();
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
