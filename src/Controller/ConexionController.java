package Controller;

import Modelos.Conexion;
import Modelos.PersonaModel;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ConexionController implements ActionListener {
    

    frmPrincipal VistaPrincipal;
    frmLogin VistaLogin;
    frmPersonas VistaPersona;
    Conexion ModelConexion;
    PersonaModel ModeloPer;

    public ConexionController(frmPrincipal VistaPrincipal, frmLogin VistaLogin, Conexion ModelConexion,frmPersonas VistaPersona, PersonaModel ModeloPer) {
        this.VistaPrincipal = VistaPrincipal;
        this.VistaLogin = VistaLogin;
        this.VistaPersona = VistaPersona;
        this.ModelConexion = ModelConexion;
        this.ModeloPer = ModeloPer;
        
        this.VistaPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
        this.VistaPrincipal.setVisible(true);
        
        this.VistaLogin.btnAceptar.addActionListener(this);
        
        //levantar formulario login
        this.VistaLogin.setLocationRelativeTo(null);
        this.VistaLogin.setVisible(true);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource()==this.VistaLogin.btnAceptar){
            
            this.ModelConexion.conectar(this.VistaLogin.txtUser.getText(),
                    this.VistaLogin.txtPass.getText());
            
            if(ModelConexion!=null){
                this.VistaLogin.dispose();
                this.VistaPersona.btnGuardar.addActionListener(this);
                this.VistaPersona.setLocationRelativeTo(null);
                this.VistaPersona.setVisible(true);                
            }            
        }
        
        if(arg0.getSource()==this.VistaPersona.btnGuardar){
            //JOptionPane.showMessageDialog(null, "Hola");
            //Mandar a guardar el registro
            this.ModeloPer.GuardarPersona(this.VistaPersona.txtApellidos.getText(),this.VistaPersona.txtNombre.getText(),
                    this.VistaPersona.txtTelefono.getText());
            
        }
    }
    
}
