/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

/**
 *
 * @author user
 */
public class celda extends ElementosABS {
    private int r,c;
    private boolean unico;
    
    public celda(int r , int c , int valor , boolean unico)
    {
    super(valor , !unico);
    this. r = r;
    this.c = c;
    this.unico = unico;
    
    }
    
    public boolean valido() {
        return valor >=
        
    }

    
    public void resetear() {
    
    }
    
}
