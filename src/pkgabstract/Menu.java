/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class Menu extends JFrame {

    private JLabel fondo1;
    public JButton b1, b2;

    public Menu() {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/pkgabstract/SREK.PNG"));
        Image imagenEscalada = originalIcon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        JLabel fondo1 = new JLabel(iconoEscalado);
        fondo1.setBounds(0, 0, 500, 500); // Tamaño igual al JFrame
        setContentPane(fondo1);
        fondo1.setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        plantilla();

        b1 = new JButton("JUGAR");
        b1.setBounds(200, 150, 100, 50); //X , Y , WIDTH , HEIGHT
        fondo1.add(b1);

        b2 = new JButton("SALIR");
        b2.setBounds(200, 250, 100, 50); //X , Y , WIDTH , HEIGHT
        fondo1.add(b2);

        //Action Perfomed
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SudokuGUI().setVisible(true);
                dispose();

            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

    }

    private void plantilla() {
        setSize(500, 500);
        setTitle("Menu");
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new Menu().setVisible(true);
    }

}
