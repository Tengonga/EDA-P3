public class Laberinto {

    // Constantes para representar el estado de una celda del laberinto
    public static final int VACIO = 0;  // Celda transitable
    public static final int PARED = 1;  // Celda bloqueada (pared)

    // Matriz que representa el laberinto
    public int[][] data;

    // Dimensiones del laberinto
    public int filas;
    public int columnas;

    /**
     * Constructor del laberinto.
     * Crea una matriz de 'filas' x 'columnas' y la inicializa con PAREDES.
     */
    public Laberinto(int filas, int columnas) {
        this.data = new int[filas][columnas];
        this.filas = filas;
        this.columnas = columnas;

        // Inicializa todas las celdas como paredes
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                data[i][j] = PARED;
    }

    /**
     * Devuelve una representación en forma de cadena del laberinto.
     * Las paredes se representan con '#' y los espacios vacíos con ' '.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Recorre todas las celdas del laberinto
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Añade un carácter según el contenido de la celda
                if (data[i][j] == PARED) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");  // Salto de línea al final de cada fila
        }

        return sb.toString();  // Devuelve la cadena completa
    }
}
