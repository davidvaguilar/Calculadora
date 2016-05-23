/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Calculadora;
import modeloDAO.CalculadoraDAO;
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
        Principal vistaCalculadora=new Principal();
        CalculadoraDAO modeloCalculadora= new CalculadoraDAO();
        ControladorCalculadora controlCal=new ControladorCalculadora(vistaCalculadora, modeloCalculadora);
    }
    
}
