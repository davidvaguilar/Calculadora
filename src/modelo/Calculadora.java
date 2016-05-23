/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author David
 */
public class Calculadora{
    private Integer codigo;
    private Integer calPriOperando;
    private Integer calSegOperando;
    private String calOperador;

    public Calculadora() {
    }

    public Calculadora(Integer codigo) {
        this.codigo = codigo;
    }

    public Calculadora(Integer calPriOperando, Integer calSegOperando, String calOperador) {
        this.calPriOperando = calPriOperando;
        this.calSegOperando = calSegOperando;
        this.calOperador = calOperador;
    }

    public Calculadora(Integer codigo, Integer calPriOperando, Integer calSegOperando, String calOperador) {
        this.codigo = codigo;
        this.calPriOperando = calPriOperando;
        this.calSegOperando = calSegOperando;
        this.calOperador = calOperador;
    }

    public Integer calcular (){
        switch (this.calOperador){
            case "+":
                return this.calPriOperando + this.calSegOperando;
            case "-":
                return this.calPriOperando - this.calSegOperando;
            case "*":
                return this.calPriOperando * this.calSegOperando;
            case "/":
                return this.calPriOperando / this.calSegOperando;
            default:
                return 0;
        }
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCalPriOperando() {
        return calPriOperando;
    }

    public void setCalPriOperando(Integer calPriOperando) {
        this.calPriOperando = calPriOperando;
    }

    public Integer getCalSegOperando() {
        return calSegOperando;
    }

    public void setCalSegOperando(Integer calSegOperando) {
        this.calSegOperando = calSegOperando;
    }

    public String getCalOperador() {
        return calOperador;
    }

    public void setCalOperador(String calOperador) {
        this.calOperador = calOperador;
    }
    
}
