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
       if( x == 0){
           return true;
       }
       return verificarFila(fila, col, x) && verificarColumna(fila, col, x) && verificarCelda(fila, col, x);
    }
    
   @Override
    public boolean partidaTerminada(){ //Verificar si ya se solucionó el cuadro
       for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               if(tabla[i][j] == 0 || verificar(i, j, tabla[i][j])){
                   return false;
               }
           }
       }
       return true;
    }
    
    private boolean verificarFila(int fila, int col, int x){
        for (int i = 0; i < 9; i++) {
            if(i != col && tabla[fila][i] == x){
                return false;
            }
        }
        return true;
    }
    
    private boolean verificarColumna(int fila, int col, int x){
        for (int i = 0; i < 9; i++) {
           if(i != fila && tabla[i][col] == x){
               return false;
           }
        }
        return true;
    }
    
    private boolean verificarCelda(int fila, int col, int x){
        int subCeldaFila = (fila/3)*3;
        int subCeldaColumna = (col/3)*3;
        
        for (int i = subCeldaFila; subCeldaFila+3 > i; i++) {
            for (int j = subCeldaColumna; subCeldaColumna > i; j++) {
                if(i != fila && j != col && tabla[i][j] == x){
                    return false;
                }
            }
        }
        return true;
    }
}
