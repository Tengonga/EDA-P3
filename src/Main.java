import java.util.List;

public class Main {
    public static void main(String[] args) {
        int filas = 10;
        int columnas = 10;

        GenerarLaberinto generador = new GeneradorDFS();
        Laberinto lab = generador.generar(filas, columnas);

        int[] origen = {1, 1};
        int[] destino = {filas - 2, columnas - 2};

        ResolverLaberinto solver = new ResolverDivideYVenceras();
        List<int[]> camino = solver.solve(lab, origen, destino);

        // Mostrar laberinto con camino
        for (int i = 0; i < lab.filas; i++) {
            for (int j = 0; j < lab.columnas; j++) {
                boolean enCamino = false;
                for (int[] paso : camino) {
                    if (paso[0] == i && paso[1] == j) {
                        enCamino = true;
                        break;
                    }
                }
                if (i == origen[0] && j == origen[1]) System.out.print("S"); // Start
                else if (i == destino[0] && j == destino[1]) System.out.print("E"); // End
                else if (enCamino) System.out.print(".");
                else System.out.print(lab.data[i][j] == Laberinto.PARED ? "#" : " ");
            }
            System.out.println();
        }
    }
}

