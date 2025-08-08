/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

/**
 *
 * @author hnleo
 */
abstract class Validador {
    protected int tabla[][];
    
    public Validador(int tabla[][]){
    this.tabla = tabla;
}
    
   abstract boolean verificar(int fila, int col, int x);
   abstract boolean partidaTerminada();
    
}
