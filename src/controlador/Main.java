/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Calculadora;
import modelo.Usuario;
import modeloDAO.UsuarioDAO;
import modeloDAO.CalculadoraDAO;
import vista.Login;
import vista.Principal;

/**
 *
 * @author David
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login vlogin=new Login();
        UsuarioDAO mUsuario=new UsuarioDAO();
        ControlLogin cLogin=new ControlLogin(vlogin, mUsuario);
     
    }
    
}
