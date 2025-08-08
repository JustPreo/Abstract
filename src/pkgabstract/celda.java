/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

/**
 *
 * @author user
 */
public class Celda extends ElementosABS {

    private int r, c;
    private boolean unico;

    public Celda(int r, int c, int valor, boolean unico) {
        super(valor, !unico);
        this.r = r;
        this.c = c;
        this.unico = unico;

    }

    public boolean valido() {
        return valor >= 0 && valor <= 9;

    }

    public void resetear() {
        if (editable) {
            valor = 0;
        }

    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public boolean unico() {
        return unico;
    }

}
