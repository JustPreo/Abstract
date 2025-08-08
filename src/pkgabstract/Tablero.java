package pkgabstract;

import java.awt.Color;
import javax.swing.*;

public class Tablero extends JFrame {

    JButton[][][] botones; // 3D: [subcuadro][fila][columna]
    JButton[][] c1, c2, c3, c4, c5, c6, c7, c8, c9;
    int contador;

    public Tablero() {
        // Crear cada subcuadro
        c1 = new JButton[3][3];
        c2 = new JButton[3][3];
        c3 = new JButton[3][3];
        c4 = new JButton[3][3];
        c5 = new JButton[3][3];
        c6 = new JButton[3][3];
        c7 = new JButton[3][3];
        c8 = new JButton[3][3];
        c9 = new JButton[3][3];

        // Meterlos en el arreglo principal
        botones = new JButton[][][] {
            c1, c2, c3,
            c4, c5, c6,
            c7, c8, c9
        };

        contador = 0;
        plantilla();
        generarCuadricula();
    }

    private void plantilla() {
        setLayout(null); // Necesario para usar setBounds
        setSize(500, 500);
        setTitle("A");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void generarCuadricula() {
        int offsetX = 0;
        int offsetY = 0;
        int subIndex = 0;

        // Recorre cada subcuadro
        for (JButton[][] subcuadro : botones) {

            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    JButton asiento = new JButton("" + (contador + 1));
                    asiento.setBounds(offsetX + (c * 50), offsetY + (r * 50), 50, 50);
                    asiento.setBackground(Color.GREEN);
                    add(asiento);
                    subcuadro[r][c] = asiento;
                    contador++;
                }
            }

            // Actualiza posición de siguiente subcuadro
            subIndex++;
            offsetX += 160;
            if (subIndex % 3 == 0) {
                offsetX = 0;
                offsetY += 160;
            }
        }
    }

    public static void main(String[] args) {
        new Tablero();
    }
}
