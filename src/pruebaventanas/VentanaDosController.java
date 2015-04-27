package pruebaventanas;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VentanaDosController implements Initializable {
    private SimpleDateFormat sdf;
    private Stage stagePrincipal;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
        
      
    }
    
    @FXML
    private void salirVentana(ActionEvent event) {
        stagePrincipal.close();
    }
    @FXML
    private TextField avisodelmal;
    @FXML
    private TextField idcliente;
    @FXML
    private TextField nombrecliente;
    @FXML
    private TextField apellidocliente;
    @FXML
    private TextField fechaventa;
    @FXML
    private TextField idarticulo;
    @FXML
    private TextField nombre;
    @FXML
    private TextField precio;
    @FXML
    private TextField stock;
    @FXML
    private TextField cantidad;
    @FXML
    private TextField total;
    @FXML
    private TextField idventavendedor;
    @FXML
    private TextField nombreventavendedor;
    @FXML
    private TextField apellidoventavendedor;
    @FXML
    private TextField idnumero;
    @FXML
    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data =
        FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com")
        );
   @FXML
   private void press(KeyEvent event){
       int bandera = 0;
       try{
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/concurso","root","");
                Statement estado = con.createStatement();
                ResultSet resultado;
                resultado = estado.executeQuery("SELECT * FROM cliente WHERE ID = '"+idcliente.getText()+"'");               
                while(resultado.next()){
                    if( idcliente.getText().equals(resultado.getString("id"))){
                        System.out.println("jdjsahdjahdjad");
                        nombrecliente.setText(resultado.getString("nombre"));
                        apellidocliente.setText(resultado.getString("apellidopaterno") +" " +resultado.getString("apellidomaterno"));
                    
                    }else if(!idcliente.getText().equals(resultado.getString("id"))){
                        System.out.println("nada");
                        nombrecliente.setText("");
                        apellidocliente.setText("");
                        
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
       
   }
    
  
    @FXML 
    private void cambio(KeyEvent event){
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/concurso","root","");
                Statement estado = con.createStatement();
                ResultSet resultado;
                resultado = estado.executeQuery("SELECT * FROM `productos` WHERE ID = '"+idarticulo.getText()+"'");               
                while(resultado.next()){
                    nombre.setText(resultado.getString("Nombre"));
                    precio.setText(resultado.getString("PrecioVenta"));
                    stock.setText(resultado.getString("Stock"));
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
    }
    @FXML
    private void cantidad(KeyEvent event){
        int numcantidad = Integer.parseInt(cantidad.getText());
        int numprecio = Integer.parseInt(precio.getText());
        int numtotal = numcantidad*numprecio;
        String hola =  Integer.toString(numtotal);
        total.setText(hola);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    table.setEditable(false);
 
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
 
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
 
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));
 
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol); 
        
        sdf = new SimpleDateFormat("dd.MM.yyyy  hh:mm:ss ");
        fechaventa.setText(sdf.format(new Date()));
        
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/concurso","root","");
                Statement estado = con.createStatement();
                ResultSet resultado;
                resultado = estado.executeQuery("SELECT * FROM ventas ORDER BY 'ID' LIMIT 1 ");               
                while(resultado.next()){ 
                     idnumero.setText(Integer.toString(Integer.parseInt(resultado.getString("ID"))+1));
                    System.out.println("holaaa "+resultado.getString("ID"));
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
        idventavendedor.setText("1");
        nombreventavendedor.setText("Pedro");
        apellidoventavendedor.setText("Perafan Carrasco");
    }
    
    public static class Person {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
 
        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
    } 
}
