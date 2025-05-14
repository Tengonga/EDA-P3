public class Laberinto {

    public static final int VACIO = 0;
    public static final int PARED = 1;
    public int[][] data;
    public int filas;
    public int columnas;

    public Laberinto(int filas, int columnas) {
        this.data = new int[filas][columnas];
        this.filas = filas;
        this.columnas = columnas;
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                data[i][j] = PARED;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (data[i][j] == PARED) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
