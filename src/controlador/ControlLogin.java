/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modeloDAO.CalculadoraDAO;
import modeloDAO.UsuarioDAO;
import vista.Login;
import vista.Principal;

/**
 *
 * @author David
 */
public class ControlLogin implements ActionListener{
    private Login vistaLogin;
    private UsuarioDAO modeloUsuario;

    public ControlLogin(Login vista, UsuarioDAO modelo) {
        this.vistaLogin = vista;
        this.modeloUsuario = modelo;
        this.vistaLogin.btnIngresar.addActionListener(this);
        this.vistaLogin.btnCancelar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaLogin.btnCancelar){
            this.vistaLogin.dispose();
        }
        if(e.getSource()==this.vistaLogin.btnIngresar){
            String alias;
            String pass;
            Usuario u;
            
            alias = this.vistaLogin.txtAlias.getText();
            pass = new String(this.vistaLogin.txtPassword.getPassword());
            if(!alias.isEmpty()&&
                    !pass.isEmpty()){
                u=new Usuario(alias, pass);
                if(u.equals(modeloUsuario.listar().get(0))){
                    this.vistaLogin.dispose();
                    this.modeloUsuario=null;
                    Principal vCalculadora=new Principal();
                    CalculadoraDAO mCalculadora= new CalculadoraDAO();
                    ControlCalculadora controlCal=new ControlCalculadora(vCalculadora, mCalculadora);
                    
                    
                }else{
                    JOptionPane.showMessageDialog(vistaLogin, "Su usuario o Password no son Correctos");
                }
                
            }else{
                if(alias.isEmpty()){
                    vistaLogin.txtAlias.setBackground(Color.red);
                }else{
                    vistaLogin.txtAlias.setBackground(Color.white);
                }
                if(pass.isEmpty()){
                    vistaLogin.txtPassword.setBackground(Color.red);
                }else{
                    vistaLogin.txtPassword.setBackground(Color.white);
                }
                vistaLogin.lblInformacion.setText("Ingrese valor (es)");
            }
            
            
        }
        
    }
    
    
    
}
