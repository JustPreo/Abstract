/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

/**
 *
 * @author user
 */
public abstract class ElementosABS {

    protected int valor;
    protected boolean editable;

    public ElementosABS(int valor, boolean editable) {
        this.valor = valor;
        this.editable = editable;
    }

    public abstract boolean valido();//Validacion del numero

    public abstract void resetear();//Resetear el valor del cosito

    public int getValor() {
        return valor;
    }

    public void setValue(int valor) {
        this.valor = valor;
    }

    public boolean esEditable() {
        return editable;
    }

    public void modEditable(boolean editable) {
        this.editable = editable;
    }
}
