/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

import java.awt.Cursor;
import java.awt.Font;
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

    private JLabel fondo1, titulo;
    public JButton b1, b2;

    public Menu() {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/pkgabstract/fondo.PNG"));
        Image imagenEscalada = originalIcon.getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        JLabel fondo1 = new JLabel(iconoEscalado);
        fondo1.setBounds(0, 0, 800, 700); // Tamaño igual al JFrame
        setContentPane(fondo1);
        fondo1.setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        plantilla();
        
        titulo = new JLabel();
        titulo.setBounds(190, 60, 400, 143); //X , Y , WIDTH , HEIGHT
        titulo.setIcon(new ImageIcon(getClass().getResource("/pkgabstract/titulo.png")));
        fondo1.add(titulo);

        b1 = new JButton("JUGAR");
        b1.setBounds(270, 250, 220, 70); //X , Y , WIDTH , HEIGHT
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFont(new Font("Kefa", Font.BOLD, 28));
        fondo1.add(b1);

        b2 = new JButton("SALIR");
        b2.setBounds(270, 350, 220, 70); //X , Y , WIDTH , HEIGHT
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFont(new Font("Kefa", Font.BOLD, 28));
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
                dispose();
                System.exit(0);

            }
        });

    }

    private void plantilla() {
        setSize(800, 700);
        setTitle("Menu");
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new Menu().setVisible(true);
    }

}
