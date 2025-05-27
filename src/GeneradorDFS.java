import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implementación del algoritmo DFS para la generación de laberintos.
 * Crea un laberinto completamente cerrado y abre caminos aleatorios desde un punto inicial.
 */
public class GeneradorDFS implements GenerarLaberinto {

    // Generador de números aleatorios para mezclar las direcciones
    private final Random random = new Random();

    @Override
    public Laberinto generar(int filas, int columnas) {
        Laberinto laberinto = new Laberinto(filas, columnas); // Inicialmente todo son paredes
        boolean[][] visitado = new boolean[filas][columnas];  // Matriz para marcar las celdas visitadas
        dfs(laberinto, 1, 1, visitado);  // Comienza desde (1,1) para evitar bordes
        return laberinto;
    }

    /**
     * Algoritmo DFS recursivo para generar el laberinto.
     */
    private void dfs(Laberinto laberinto, int x, int y, boolean[][] visitado) {
        visitado[x][y] = true;
        laberinto.data[x][y] = Laberinto.VACIO; // Marca como camino

        // Direcciones posibles: arriba, abajo, izquierda, derecha (saltando 2 celdas para dejar paredes entre celdas)
        List<int[]> direcciones = new ArrayList<>();
        direcciones.add(new int[]{-2, 0}); // Arriba
        direcciones.add(new int[]{2, 0});  // Abajo
        direcciones.add(new int[]{0, -2}); // Izquierda
        direcciones.add(new int[]{0, 2});  // Derecha
        Collections.shuffle(direcciones);  // Mezcla para que los caminos sean aleatorios

        for (int[] dir : direcciones) {
            int nx = x + dir[0]; // Nueva coordenada X
            int ny = y + dir[1]; // Nueva coordenada Y

            // Si la nueva celda está dentro del laberinto y no ha sido visitada aún
            if (enRango(laberinto, nx, ny) && !visitado[nx][ny]) {
                // Quita la pared intermedia entre (x, y) y (nx, ny)
                laberinto.data[x + dir[0] / 2][y + dir[1] / 2] = Laberinto.VACIO;

                // Llama recursivamente para continuar desde la nueva celda
                dfs(laberinto, nx, ny, visitado);
            }
        }
    }

    /**
     * Verifica si la celda está dentro de los límites del laberinto (sin contar bordes).
     */
    private boolean enRango(Laberinto lab, int x, int y) {
        return x > 0 && x < lab.filas - 1 && y > 0 && y < lab.columnas - 1;
    }
}
