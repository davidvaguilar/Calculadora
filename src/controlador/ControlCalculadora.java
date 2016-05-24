/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Calculadora;
import modeloDAO.CalculadoraDAO;
import vista.Principal;

/**
 *
 * @author David
 */
public class ControlCalculadora implements ActionListener{
    private CalculadoraDAO calculadora;
    private Principal jfCalculadora;
    
    public ControlCalculadora(Principal jfCal, CalculadoraDAO cal){
        this.calculadora=cal;
        this.jfCalculadora=jfCal;
        this.jfCalculadora.btnResultado.addActionListener(this);
        this.jfCalculadora.btnLimpiar.addActionListener(this);
        this.jfCalculadora.btnActualizar.addActionListener(this);
    }
    
    public void ActualizarTabla(JTable t){
        DefaultTableModel modeloTabla= new DefaultTableModel();
        int cantidadRegitro;
        t.setModel(modeloTabla);
        modeloTabla.addColumn("Cod.");
        modeloTabla.addColumn("1° Numero");
        modeloTabla.addColumn("Signo");
        modeloTabla.addColumn("2° Numero");
        modeloTabla.addColumn("Resultado");
        
        Object[] columna=new Object[5];
        cantidadRegitro=calculadora.listar().size();
        if(cantidadRegitro>10){
            for (int i = (cantidadRegitro-1); i > cantidadRegitro-10; i--) {
                columna[0]=calculadora.listar().get(i).getCodigo();
                columna[1]= calculadora.listar().get(i).getCalPriOperando();
                columna[2]= calculadora.listar().get(i).getCalOperador();
                columna[3]= calculadora.listar().get(i).getCalSegOperando();
                columna[4]= calculadora.listar().get(i).calcular();
                modeloTabla.addRow(columna);
            }
        }else{
            for (int i = 0; i < cantidadRegitro; i++) {
                columna[0]=calculadora.listar().get(i).getCodigo();
                columna[1]= calculadora.listar().get(i).getCalPriOperando();
                columna[2]= calculadora.listar().get(i).getCalOperador();
                columna[3]= calculadora.listar().get(i).getCalSegOperando();
                columna[4]= calculadora.listar().get(i).calcular();
                modeloTabla.addRow(columna);
            }
        }
        
    }
    
    public void limpiar(){
        jfCalculadora.txtPrimer.setText("");
        jfCalculadora.txtSegundo.setText("");
        jfCalculadora.txtSigno.setText("");
        jfCalculadora.txtPrimer.setBackground(Color.WHITE);
        jfCalculadora.txtSegundo.setBackground(Color.WHITE);
        jfCalculadora.txtSigno.setBackground(Color.WHITE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jfCalculadora.btnResultado){
            Integer primerNumero;
            String signo;
            Integer segundoNumero;
            boolean bandera;
            Calculadora c;
            
            signo=jfCalculadora.txtSigno.getText();
            if(!signo.equals("+")&&!signo.equals("-")&&!signo.equals("*")&&!signo.equals("/")){
                JOptionPane.showMessageDialog(jfCalculadora, "Los operadores son:\n"
                        + "+ => suma \n"
                        + "- => resta \n"
                        + "* => multiplicacion \n"
                        + "/ => division \n");
                signo="";
            }
                
            if(!jfCalculadora.txtPrimer.getText().isEmpty()&&
                    !jfCalculadora.txtSegundo.getText().isEmpty()&&
                    !signo.isEmpty()){
               
                
                try{
                    primerNumero=Integer.valueOf(jfCalculadora.txtPrimer.getText());
                    segundoNumero=Integer.valueOf(jfCalculadora.txtSegundo.getText());
                    c= new Calculadora(primerNumero, segundoNumero, signo);
                    bandera=calculadora.ingresar(c);
                    if(bandera){
                        jfCalculadora.lblInformacion.setText("El resultado es: "+ c.calcular());
                    }else{
                        jfCalculadora.lblInformacion.setText("Hubo un error al ingresar, No se pudo terminar el ingreso");
                    }
                    limpiar();
                    
                }catch(Exception ex){
                    jfCalculadora.lblInformacion.setText( "Debe ingresar numeros");
                    ex.printStackTrace();
                }finally{
                    ActualizarTabla(jfCalculadora.tblDatos);
                }
            }else{
            
                if(jfCalculadora.txtPrimer.getText().isEmpty()){
                    jfCalculadora.txtPrimer.setBackground(Color.red);
                }else{
                    jfCalculadora.txtPrimer.setBackground(Color.white);
                }
                if(jfCalculadora.txtSegundo.getText().isEmpty()){
                    jfCalculadora.txtSegundo.setBackground(Color.red);
                }else{
                    jfCalculadora.txtSegundo.setBackground(Color.white);
                }
                if(jfCalculadora.txtSigno.getText().isEmpty()){
                    jfCalculadora.txtSigno.setBackground(Color.red);
                }else{
                    jfCalculadora.txtSigno.setBackground(Color.white);
                }
                jfCalculadora.lblInformacion.setText("Ingrese valor (es)");
            }
        }
        
        if(e.getSource()==jfCalculadora.btnActualizar){
            ActualizarTabla(jfCalculadora.tblDatos);
        }
    }
    
}
