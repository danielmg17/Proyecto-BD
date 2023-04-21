package Controller;

import Modelos.Conexion;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConexionController implements ActionListener {
    

    frmPrincipal VistaPrincipal;
    frmLogin VistaLogin;
    frmPersonas VistaPersona;
    Conexion ModelConexion;

    public ConexionController(frmPrincipal VistaPrincipal, frmLogin VistaLogin, Conexion ModelConexion,frmPersonas VistaPersona) {
        this.VistaPrincipal = VistaPrincipal;
        this.VistaLogin = VistaLogin;
        this.VistaPersona = VistaPersona;
        this.ModelConexion = ModelConexion;
        
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
                this.VistaPersona.setLocationRelativeTo(null);
                this.VistaPersona.setVisible(true);
            }
            
            
        }
    }
    
}
