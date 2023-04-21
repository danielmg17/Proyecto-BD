
import Controller.ConexionController;
import Modelos.Conexion;
import Modelos.PersonaModel;
import Vistas.frmPrincipal;
import Vistas.frmLogin;
import Vistas.frmPersonas;


public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmPrincipal VistaPrincipal=new frmPrincipal();
        frmLogin VistaLogin=new frmLogin(VistaPrincipal,true);
        frmPersonas VistaPersonas = new frmPersonas(VistaPrincipal,true);
        Conexion ModeloConexion=new Conexion();
        PersonaModel PerModel = new PersonaModel();
        
        
        ConexionController Controlador=new ConexionController( VistaPrincipal,VistaLogin,ModeloConexion,VistaPersonas,PerModel);        
    }
    
}
