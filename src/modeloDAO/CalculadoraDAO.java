/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import controlador.Conexion;
import interfaces.InterfazDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Calculadora;

/**
 *
 * @author David
 */
public class CalculadoraDAO implements InterfazDAO<Calculadora>{

    private static final String SQL_INGRESAR=
            "INSERT INTO Calculadora(calPriOperando, calSegOperando, calOperador) "
            + "VALUES (?, ?, ?)";
    private static final String SQL_BUSCAR= 
            "SELECT * FROM Calculadora WHERE calCodigo = ?";
    private static final String SQL_LISTAR=
            "SELECT * FROM Calculadora";
    
    private static final Conexion cnn=Conexion.saberEstado();
    
    @Override
    public boolean ingresar(Calculadora x) {
        try {
            PreparedStatement ps;
            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
            ps.setInt(1, x.getCalPriOperando());
            ps.setInt(2, x.getCalSegOperando());
            ps.setString(3, x.getCalOperador());
            int bandera=ps.executeUpdate();
            if(bandera > 0){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public Calculadora buscar(Object llave) {
        
        PreparedStatement ps;
        ResultSet rs;
        Calculadora c=null;
            try {
            
            ps=cnn.getCnn().prepareStatement(SQL_BUSCAR);
            ps.setInt(1, (Integer)llave);
            rs=ps.executeQuery();
            while(rs.next()){
                c=new Calculadora(rs.getInt("calCodigo"),rs.getInt("calPriOperando"),rs.getInt("calSegOperando"),rs.getString("calOperador"));
            }
            } catch (SQLException ex) {
                Logger.getLogger(CalculadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                cnn.cerrarConexion();
            }
        return c;
    }

    @Override
    public ArrayList<Calculadora> listar() {
    
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Calculadora> calculadoras= new ArrayList();
        
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs=ps.executeQuery();
            while(rs.next()){
                calculadoras.add(
                        new Calculadora(rs.getInt("calCodigo"),
                                rs.getInt("calPriOperando"),
                                rs.getInt("calSegOperando"),
                                rs.getString("calOperador")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalculadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calculadoras;
    }

    @Override
    public boolean actualizar(Object llave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Calculadora x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
