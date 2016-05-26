/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modeloDAO.CalculadoraDAO;
import modeloDAO.UsuarioDAO;
import vista.Login;
import vista.Calcular;
import vista.Principal;

/**
 *
 * @author David
 */
public class ControlLogin implements ActionListener{
    private Login visLogin;
    private UsuarioDAO modUsuario;

    public ControlLogin(Login vLogin, UsuarioDAO mUsuario) {
        this.visLogin = vLogin;
        this.modUsuario = mUsuario;
        this.visLogin.btnIngresar.addActionListener(this);
        this.visLogin.btnCancelar.addActionListener(this);
        
    }
    
    public void limpiar(){
        visLogin.txtAlias.setText("");
        visLogin.txtPassword.setText("");
        visLogin.txtAlias.setBackground(Color.WHITE);
        visLogin.txtPassword.setBackground(Color.WHITE);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==this.visLogin.btnCancelar){
            this.visLogin.dispose();
        }
        
        
        if(e.getSource()==this.visLogin.btnIngresar){
            String alias;
            String pass;
            Usuario u;
            boolean bandera=false;
            ArrayList<Usuario> usuarios=new ArrayList();
            alias = this.visLogin.txtAlias.getText();
            pass = new String(this.visLogin.txtPassword.getPassword());
            if(!alias.isEmpty()&&
                    !pass.isEmpty()){
                u=new Usuario(alias, pass);
                usuarios=modUsuario.listar();
                for (int i = 0; i < usuarios.size(); i++) {
                    if(u.equals(usuarios.get(i))){
                        this.visLogin.dispose();
                        this.modUsuario=null;
                        bandera=true;
                        Principal vPrincipal=new Principal();
                        ControlPrincipal controlPri=new ControlPrincipal(vPrincipal, u);



                    }
                }
                if(!bandera){
                    JOptionPane.showMessageDialog(this.visLogin, "Su usuario o Password no son Correctos");
                }
                
            }else{
                if(alias.isEmpty()){
                    visLogin.txtAlias.setBackground(Color.red);
                }else{
                    visLogin.txtAlias.setBackground(Color.white);
                }
                if(pass.isEmpty()){
                    visLogin.txtPassword.setBackground(Color.red);
                }else{
                    visLogin.txtPassword.setBackground(Color.white);
                }
                visLogin.lblInformacion.setText("Ingrese valor (es)");
            }
            
            
        }
        
    }
    
    
    
}
