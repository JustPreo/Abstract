package pkgabstract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Cuidado con este frankeinstein pq aaron lo bugueo feo

public class SudokuGUI extends JuegoGUI implements ActionListener, KeyListener {

    private celda[][] celdas;
    private JTextField[][] camposTexto;
    private ValidacionesJuego validador;
    private TableroSudoku generador;
    private int[][] tableroActual;
    private int[][] tableroOriginal;

    private JButton btnVerificar, btnMostrarSolucion, btnReiniciar;

    public SudokuGUI() {
        super("Sudoku");

        celdas = new celda[9][9];
        camposTexto = new JTextField[9][9];
        tableroActual = new int[9][9];
        generador = new TableroSudoku();

        initGui();
        iniciarJuego();
    }

    @Override
    protected void setgPanel() {
        gPanel = new JPanel(new GridLayout(3, 3, 2, 2));
        gPanel.setBackground(Color.BLACK);
        gPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int filaCaja = 0; filaCaja < 3; filaCaja++) {
            for (int colCaja = 0; colCaja < 3; colCaja++) {
                JPanel panelCaja = crearCaja(filaCaja, colCaja);
                gPanel.add(panelCaja);
            }
        }
    }

    private JPanel crearCaja(int filaCaja, int colCaja) {
        JPanel panelCaja = new JPanel(new GridLayout(3, 3, 1, 1));
        panelCaja.setBackground(Color.GRAY);
        panelCaja.setBorder(BorderFactory.createRaisedBevelBorder());

        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                int filaReal = filaCaja * 3 + fila;
                int colReal = colCaja * 3 + col;

                JTextField campo = new JTextField();
                campo.setHorizontalAlignment(JTextField.CENTER);
                campo.setFont(new Font("Arial", Font.BOLD, 20));
                campo.addKeyListener(this);

                camposTexto[filaReal][colReal] = campo;
                panelCaja.add(campo);
            }
        }

        return panelCaja;
    }

    @Override
    protected void setcPanel() {
        cPanel = new JPanel(new FlowLayout());

        btnVerificar = new JButton("Verificar");
        btnMostrarSolucion = new JButton("Mostrar Solución");
        btnReiniciar = new JButton("Reiniciar");

        btnVerificar.addActionListener(this);
        btnMostrarSolucion.addActionListener(this);
        btnReiniciar.addActionListener(this);

        cPanel.add(btnVerificar);
        cPanel.add(btnMostrarSolucion);
        cPanel.add(btnReiniciar);
    }

    private void iniciarJuego() {
        generarNuevoJuego();
    }

    private void generarNuevoJuego() {

        int dificultad = 70;
        tableroActual = generador.generatePuzzle(dificultad);

        tableroOriginal = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(tableroActual[i], 0, tableroOriginal[i], 0, 9);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boolean esOriginal = tableroActual[i][j] != 0;
                celdas[i][j] = new celda(i, j, tableroActual[i][j], esOriginal);
            }
        }

        validador = new ValidacionesJuego(tableroActual);
        update();
    }

    @Override
    protected void update() {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                JTextField campo = camposTexto[fila][col];
                celda celd = celdas[fila][col];

                if (celd.getValor() == 0) {
                    campo.setText("");
                } else {
                    campo.setText(String.valueOf(celd.getValor()));
                }

                if (celd.unico()) {
                    campo.setBackground(Color.LIGHT_GRAY);
                    campo.setEditable(false);
                    campo.setFont(new Font("Arial", Font.BOLD, 20));
                } else {
                    campo.setBackground(Color.WHITE);
                    campo.setEditable(true);
                    campo.setFont(new Font("Arial", Font.PLAIN, 20));
                }

                if (celd.getValor() != 0 && !validador.verificar(fila, col, celd.getValor())) {
                    campo.setBackground(Color.PINK);
                }
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == btnVerificar) {
            verificarSolucion();
        } else if (fuente == btnMostrarSolucion) {
            mostrarSolucion();
        } else if (fuente == btnReiniciar) {
            reiniciarJuego();
        }
    }

    private void verificarSolucion() {
        actualizarTablero();

        if (validador.partidaTerminada()) {
            JOptionPane.showMessageDialog(this, "Has completado el Sudoku correctamente.",
                    "VICTORIA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El Sudoku no está completo o tiene errores.",
                    "ALERTA", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarSolucion() {
        int[][] solucion = generador.getSolution();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                celdas[i][j].setValor(solucion[i][j]);
                tableroActual[i][j] = solucion[i][j];
            }
        }
        update();
    }

    private void reiniciarJuego() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!celdas[i][j].unico()) {
                    celdas[i][j].resetear();
                    tableroActual[i][j] = 0;
                }
            }
        }
        update();
    }

    private void actualizarTablero() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String texto = camposTexto[i][j].getText().trim();
                if (texto.isEmpty()) {
                    tableroActual[i][j] = 0;
                    celdas[i][j].setValor(0);
                } else {
                    try {
                        int valor = Integer.parseInt(texto);
                        if (valor >= 1 && valor <= 9) {
                            tableroActual[i][j] = valor;
                            celdas[i][j].setValor(valor);
                        }
                    } catch (NumberFormatException ex) {
                        // no hace nada si se ingresa una entrada invalida att: fer :D
                    }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c >= '1' && c <= '9') || c == KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        actualizarTablero();
        update();
    }
}
