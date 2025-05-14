import java.util.*;

public class ResolverDivideYVenceras implements ResolverLaberinto {

    @Override
    public List<int[]> solve(Laberinto lab, int[] origen, int[] destino) {
        List<int[]> camino = new ArrayList<>();
        boolean[][] visitado = new boolean[lab.filas][lab.columnas];
        if (dfs(lab, origen[0], origen[1], destino, camino, visitado)) {
            Collections.reverse(camino); // El camino se genera de atrás hacia adelante
            return camino;
        }
        return new ArrayList<>(); // vacío si no hay camino
    }

    private boolean dfs(Laberinto lab, int x, int y, int[] destino, List<int[]> camino, boolean[][] visitado) {
        if (!enRango(lab, x, y) || lab.data[x][y] == Laberinto.PARED || visitado[x][y]) {
            return false;
        }

        if (x == destino[0] && y == destino[1]) {
            camino.add(new int[]{x, y});
            return true;
        }

        visitado[x][y] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (dfs(lab, nx, ny, destino, camino, visitado)) {
                camino.add(new int[]{x, y});
                return true;
            }
        }

        return false;
    }

    private boolean enRango(Laberinto lab, int x, int y) {
        return x >= 0 && x < lab.filas && y >= 0 && y < lab.columnas;
    }
}

