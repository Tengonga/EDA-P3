import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorDFS implements GenerarLaberinto {

    private final Random random = new Random();

    @Override
    public Laberinto generar(int filas, int columnas) {
        Laberinto laberinto = new Laberinto(filas, columnas);
        boolean[][] visitado = new boolean[filas][columnas];
        dfs(laberinto, 1, 1, visitado);
        return laberinto;
    }

    private void dfs(Laberinto laberinto, int x, int y, boolean[][] visitado) {
        visitado[x][y] = true;
        laberinto.data[x][y] = Laberinto.VACIO;

        List<int[]> direcciones = new ArrayList<>();
        direcciones.add(new int[]{-2, 0}); // Arriba
        direcciones.add(new int[]{2, 0});  // Abajo
        direcciones.add(new int[]{0, -2}); // Izquierda
        direcciones.add(new int[]{0, 2});  // Derecha
        Collections.shuffle(direcciones);

        for (int[] dir : direcciones) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (enRango(laberinto, nx, ny) && !visitado[nx][ny]) {
                laberinto.data[x + dir[0] / 2][y + dir[1] / 2] = Laberinto.VACIO; // Quitar pared entre
                dfs(laberinto, nx, ny, visitado);
            }
        }
    }

    private boolean enRango(Laberinto lab, int x, int y) {
        return x > 0 && x < lab.filas - 1 && y > 0 && y < lab.columnas - 1;
    }
}
