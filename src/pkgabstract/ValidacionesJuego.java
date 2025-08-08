/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

/**
 *
 * @author hnleo
 */
public class ValidacionesJuego extends Validador {
    
    public ValidacionesJuego(int tabla[][]){
        super(tabla);
    }
    
    @Override
    
    public boolean verificar(int fila, int col, int x){
        return true;
    }
    
   @Override
    public boolean partidaTerminada(){
        return false;
    }
    
}
