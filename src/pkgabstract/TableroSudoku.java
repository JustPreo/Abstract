/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

import java.util.Random;

/**
 *
 * @author hnleo
 */
public class TableroSudoku {

    private Random random;
    
    public TableroSudoku() {
        random = new Random();
    }
    
    public int[][] crearTablero(int level) {
     
        int[][] tableroCompleto = new int[9][9];
        generarTablaRandom(tableroCompleto);
        
        int[][] tableroJuego = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(tableroCompleto[i], 0, tableroJuego[i], 0, 9);
        }
        
        int celdasDeleted = 0;
        int maxCeldasAEliminar = level;
        
        while (celdasDeleted < maxCeldasAEliminar) {
            int fila = random.nextInt(9);
            int col = random.nextInt(9);
            
     
            if (tableroJuego[fila][col] != 0) {
                tableroJuego[fila][col] = 0;
                celdasDeleted++;
            }
        }
        
        return tableroJuego;
    }
    
    private void generarTablaRandom(int[][] tableroRandom) {
        generarDiagonal(tableroRandom);
        llenadoDeCeldas(tableroRandom, 0, 3);
    }
    
    private void generarDiagonal(int[][] tableroRandom) {
        for (int i = 0; i < 9; i += 3) {
            llenarSubCelda(tableroRandom, i, i);
        }
    }
    
    private void llenarSubCelda(int[][] tableroRandom, int fila, int col) {
        int x;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    x = random.nextInt(9) + 1;
                } while (!noUsado(tableroRandom, fila, col, x));
                tableroRandom[fila + i][col + j] = x;
            }
        }
    }
    
    private boolean noUsado(int[][] tableroRandom, int in, int fin, int x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableroRandom[in + i][fin + j] == x) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean llenadoDeCeldas(int[][] tableroRandom, int i, int j) {
        if (j >= 9 && i < 8) {
            i = i + 1;
            j = 0;
        }
        if (i >= 9 && j >= 9) {
            return true;
        }
        
        if (i < 3) {
            if (j < 3) {
                j = 3;
            }
        } else if (i < 6) {
            if (j == (i / 3) * 3) {
                j = j + 3;
            }
        } else {
            if (j == 6) {
                i = i + 1;
                j = 0;
                if (i >= 9) {
                    return true;
                }
            }
        }
        
        for (int num = 1; num <= 9; num++) {
            if (verificarVacio(tableroRandom, i, j, num)) {
                tableroRandom[i][j] = num;
                if (llenadoDeCeldas(tableroRandom, i, j + 1)) {
                    return true;
                }
                tableroRandom[i][j] = 0;
            }
        }
        return false;
    }
    
    private boolean verificarVacio(int[][] tableroRandom, int i, int j, int x) {
        return (vacioEnFila(tableroRandom, i, x) && vacioEnColumna(tableroRandom, j, x)
                && noUsado(tableroRandom, (i / 3) * 3, (j / 3) * 3, x));
    }
    
    private boolean vacioEnFila(int[][] tableroRandom, int i, int x) {
        for (int j = 0; j < 9; j++) {
            if (tableroRandom[i][j] == x) {
                return false;
            }
        }
        return true;
    }
    
    private boolean vacioEnColumna(int[][] tableroRandom, int j, int x) {
        for (int i = 0; i < 9; i++) {
            if (tableroRandom[i][j] == x) {
                return false;
            }
        }
        return true;
    }
}
