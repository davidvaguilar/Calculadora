/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import interfaces.InterfazDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author David
 */
public class UsuarioDAO implements InterfazDAO<Usuario>{

    private static final String URL= "agenda.dat";
    
    
    
    
    @Override
    public boolean ingresar(Usuario x) {
        File f=null;
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            f=new File(this.URL);
            
            fw=new FileWriter(f);
            bw=new BufferedWriter(fw);
            
            bw.write(x.getUsuAlias()+"%"+x.getUsuPassword());
            
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }finally{
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        return true;       
    }
    
    

    @Override
    public Usuario buscar(Object llave) {
        File f;
        FileReader fr=null;
        BufferedReader br=null;
        return null;
    
    }
    
    

    @Override
    public ArrayList<Usuario> listar() {
        File f;
        FileReader fr=null;
        BufferedReader br=null;
        String linea="";
        String partes[] = null;
        ArrayList<Usuario> usuarios = new ArrayList();
        
        try{
            f = new File(this.URL);
            if(f.exists()){
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                //linea = br.readLine();
                //System.out.println(br.readLine());
                while((linea=br.readLine())!=null){
                    partes = linea.split("%");
                    usuarios.add(new Usuario(partes[0], partes[1]));
            
                }  
            }else{
                JOptionPane.showMessageDialog(null, "El Archivo no Existe");
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;        
    }

    @Override
    public boolean actualizar(Object llave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean eliminar(Usuario x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
