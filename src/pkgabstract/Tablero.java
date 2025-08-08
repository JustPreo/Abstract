package pkgabstract;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tablero extends JFrame {

    JButton[][][] botones; // [subcuadro][fila][columna]
    JButton[] numeros;     // Botones 1-9 para escribir
    JButton seleccionado;  // Botón de la celda seleccionada
    int contador;

    public Tablero() {
        botones = new JButton[9][3][3];
        numeros = new JButton[9];

        contador = 0;
        plantilla();
        generarCuadricula();
        generarBotones();
    }

    private void plantilla() {
        setLayout(null);
        setSize(900, 550);
        setTitle("Sudoku");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void generarCuadricula() {
        int offsetX = 0;
        int offsetY = 0;
        int subIndex = 0;

        for (int sub = 0; sub < 9; sub++) {

            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    contador++;

                    JButton asiento = new JButton(String.valueOf(contador));
                    asiento.setBounds(offsetX + (c * 50), offsetY + (r * 50), 50, 50);
                    asiento.setBackground(Color.WHITE);

                    // Al hacer click, marcar como seleccionado
                    asiento.addActionListener(e -> {
                        if (seleccionado != null) {
                            seleccionado.setBackground(Color.WHITE);
                        }
                        seleccionado = asiento;
                        seleccionado.setBackground(Color.CYAN);
                    });

                    add(asiento);
                    botones[sub][r][c] = asiento;
                }
            }

            subIndex++;
            offsetX += 160;
            if (subIndex % 3 == 0) {
                offsetX = 0;
                offsetY += 160;
            }

            if (contador == 9) {
                contador = 0;
            }
        }
    }

    private void generarBotones() {
        int startX = 500;
        int startY = 50;

        for (int i = 0; i < 9; i++) {
            JButton numBtn = new JButton(String.valueOf(i + 1)); //Basicamente la creacion de los botones [1-9] 
            //El 
            numBtn.setBounds(startX, startY + (i * 45), 50, 40);

            int numero = i + 1;

            numBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (seleccionado != null) {
                        seleccionado.setText(String.valueOf(numero));
                    }
                }
            });

            add(numBtn);
            numeros[i] = numBtn;//Agrega al array de numeros [1-9]
        }
    }

    public static void main(String[] args) {
        new Tablero().setVisible(true);
    }
}
