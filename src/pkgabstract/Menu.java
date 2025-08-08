/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class Menu extends JFrame {

    private JLabel fondo1;

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
