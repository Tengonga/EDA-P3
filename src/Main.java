import java.util.List;

public class Main {
    public static void main(String[] args) {
        int filas = 10;
        int columnas = 10;

        // Genera un laberinto usando DFS
        GenerarLaberinto generador = new GeneradorDFS();
        Laberinto lab = generador.generar(filas, columnas);

        // Punto de inicio (origen) y final (destino) en el laberinto
        int[] origen = {1, 1};
        int[] destino = {filas - 2, columnas - 2};

        // Resuelve el laberinto para encontrar el camino desde origen a destino
        ResolverLaberinto solver = new ResolverDivideYVenceras();
        List<int[]> camino = solver.solve(lab, origen, destino);

        // Mostrar laberinto en consola con el camino marcado
        for (int i = 0; i < lab.filas; i++) {
            for (int j = 0; j < lab.columnas; j++) {
                boolean enCamino = false;
                // Verifica si la posición (i,j) está en el camino
                for (int[] paso : camino) {
                    if (paso[0] == i && paso[1] == j) {
                        enCamino = true;
                        break;
                    }
                }

                // Marca el origen con 'S'
                if (i == origen[0] && j == origen[1]) System.out.print("S");
                    // Marca el destino con 'E'
                else if (i == destino[0] && j == destino[1]) System.out.print("E");
                    // Marca el camino con '.'
                else if (enCamino) System.out.print(".");
                    // Muestra '#' para paredes y espacio para pasillos
                else System.out.print(lab.data[i][j] == Laberinto.PARED ? "#" : " ");
            }
            System.out.println();
        }
    }
}
