import java.util.List;

public interface ResolverLaberinto {
    List<int[]> solve(Laberinto laberinto, int[] origen, int[] destino);
}

/**
 * Resuelve el laberinto buscando un camino válido desde el origen al destino.
 *
 * @param laberinto el laberinto a resolver
 * @param origen coordenadas de inicio [fila, columna]
 * @param destino coordenadas de destino [fila, columna]
 * @return una lista de posiciones (como arrays [fila, columna]) que representan el camino desde origen a destino.
 *         Si no hay camino, puede devolver una lista vacía o null según la implementación.
 */