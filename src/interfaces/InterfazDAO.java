/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Calculadora;

/**
 *
 * @author David
 */
public interface InterfazDAO <Algo> {
    public boolean ingresar (Algo x);
    public boolean actualizar (Object llave);
    public boolean eliminar (Algo x);
    public Algo buscar(Object llave);
    public ArrayList<Algo> listar();
}
