/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Tablero extends JFrame {

    JButton[][] c1,c2,c3,c4,c5,c6;
    int contador;

    public Tablero() {
        c1 = new JButton[3][3];
        contador = 0;
        plantilla();
        generarCuadricula();
    }

    private void plantilla() {
        setSize(500, 500);
        setTitle("A");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generarCuadricula() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton asiento = new JButton("" + (contador + 1));
                asiento.setBounds((r * 100) + 50, c * 100, 100, 100);
                add(asiento);
                c1[r][c] = asiento;
                asiento.setBackground(Color.GREEN);
                System.out.println(contador);
                contador++;
            }

        }

    }

    public static void main(String[] args) {
        new Tablero();
    }

}
