import java.util.*;

/**
 * Implementación de una estrategia de resolución de laberintos mediante
 * búsqueda en profundidad (DFS). A pesar del nombre, no es un verdadero
 * algoritmo de "divide y vencerás".
 */
public class ResolverDivideYVenceras implements ResolverLaberinto {

    @Override
    public List<int[]> solve(Laberinto lab, int[] origen, int[] destino) {
        List<int[]> camino = new ArrayList<>();
        boolean[][] visitado = new boolean[lab.filas][lab.columnas];

        // Si se encuentra un camino desde el origen al destino
        if (dfs(lab, origen[0], origen[1], destino, camino, visitado)) {
            Collections.reverse(camino); // Se construyó al revés, hay que invertirlo
            return camino;
        }

        // Si no hay camino, se devuelve una lista vacía
        return new ArrayList<>();
    }

    /**
     * Búsqueda en profundidad para encontrar el camino desde (x,y) hasta el destino.
     */
    private boolean dfs(Laberinto lab, int x, int y, int[] destino, List<int[]> camino, boolean[][] visitado) {
        // Verifica si está fuera de rango, si es una pared o si ya fue visitado
        if (!enRango(lab, x, y) || lab.data[x][y] == Laberinto.PARED || visitado[x][y]) {
            return false;
        }

        // Si llegamos al destino, añadimos la posición al camino
        if (x == destino[0] && y == destino[1]) {
            camino.add(new int[]{x, y});
            return true;
        }

        visitado[x][y] = true; // Marcamos como visitado

        // Direcciones posibles: arriba, abajo, izquierda, derecha
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];

            // Llamada recursiva: si encuentra camino, añade la posición actual
            if (dfs(lab, nx, ny, destino, camino, visitado)) {
                camino.add(new int[]{x, y});
                return true;
            }
        }

        // No se encontró camino desde esta posición
        return false;
    }

    /**
     * Verifica si las coordenadas están dentro de los límites del laberinto.
     */
    private boolean enRango(Laberinto lab, int x, int y) {
        return x >= 0 && x < lab.filas && y >= 0 && y < lab.columnas;
    }
}

