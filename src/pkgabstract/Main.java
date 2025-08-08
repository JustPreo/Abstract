package pkgabstract;

import javax.swing.*;

/**
 *
 * @author ricardomadrid
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SudokuGUI().setVisible(true);
        });
    }
}
