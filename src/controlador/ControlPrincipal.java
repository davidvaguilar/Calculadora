/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import modeloDAO.CalculadoraDAO;
import vista.Calcular;
import vista.Principal;

/**
 *
 * @author David
 */
public class ControlPrincipal implements ActionListener{
    private Principal vPrincipal;
    private Usuario u;

    public ControlPrincipal(Principal vistaPri, Usuario usu) {
        this.vPrincipal = vistaPri;
        this.u = usu;
        this.vPrincipal.btnCalcular.addActionListener(this);
        this.vPrincipal.btnEliminar.addActionListener(this);
        this.vPrincipal.lblBienvenido.setText("Bienvenido : "+u.getUsuAlias());
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vPrincipal.btnCalcular){
            Calcular vCalculadora=new Calcular();
            CalculadoraDAO mCalculadora= new CalculadoraDAO();
            ControlCalcular controlCal=new ControlCalcular(vCalculadora, mCalculadora); 
        }
        
        if(e.getSource()==this.vPrincipal.btnEliminar){
            
        }
    }
    
}
