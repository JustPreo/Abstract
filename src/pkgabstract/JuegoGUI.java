/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ricardomadrid
 */
abstract class JuegoGUI extends JFrame{
    protected JPanel gPanel;
    protected JPanel cPanel;
    
    public JuegoGUI(String title) {
        super(title);
    }
    
    protected void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        setgPanel();
        setcPanel();
        
        add(gPanel, BorderLayout.CENTER);
        add(cPanel, BorderLayout.SOUTH);
        
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
    
    protected abstract void setgPanel();
    protected abstract void setcPanel();
    protected abstract void update();
}
