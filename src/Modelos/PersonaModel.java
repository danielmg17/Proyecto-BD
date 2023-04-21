package Modelos;
        
import java.sql.*;
import javax.swing.JOptionPane;

public class PersonaModel {
    
   String apellidos;
   String nombre;
   int telefono;
   Connection  miConexion;

    public PersonaModel(String Apellidos, String Nombre, int Telefono) {
        this.apellidos = Apellidos;
        this.nombre = Nombre;
        this.telefono = Telefono;
    }
    
   public PersonaModel() {

    }    

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int Telefono) {
        this.telefono = Telefono;
    }
   
   
  public void GuardarPersona(){
       try{
           Conexion nuevaConexion=new Conexion();
           this.miConexion= nuevaConexion.conectar(nombre, nombre);
           
           Statement sentencia = miConexion.createStatement();
           sentencia.execute("isert into Persona values('"+this.getApellidos()+"','"+this.getNombre()+"','"+this.getTelefono()+"')");
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error al Insertar Registro..."+e.getMessage());
       }
   }
            
}
