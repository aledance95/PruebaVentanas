/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaventanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
/*
import java.sql.*;
import java.io.*;
import java.util.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ale
 */
public class LoginvendedorController implements Initializable {
     private Stage stagePrincipal;
//    private TextField user;
//    private PasswordField pass;
    
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
   /*    
try{
                  Class.forName("com.mysql.jdbc.Driver");
                  System.out.println("entree");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/concurso","root","");
                  System.out.println("casi");
                  Statement estado = con.createStatement();
                 ResultSet resultado;
            resultado = estado.executeQuery("SELECT * FROM `vendedor` WHERE usuario = '"+ user.getText() +"' && password = '"+ pass.getText() +"'");
                  System.out.println(resultado.getString("usuario"));
                  System.out.println("casiiii");
        }catch(SQLException e){
            System.out.println("Error de mysql");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Se ha encontrado  "+ e.getMessage());
        }  

*/
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
