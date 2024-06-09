import java.util.HashMap;
import java.util.Map;

public class EstadosCafetera {
//Esta clase contiene todos los estados posibles que puede adoptar la cafetera
    public static final Map<String, Integer> ESTADOS = new HashMap<>();

//Inicializa los estados
    static {
        ESTADOS.put("Apagado", 0);
        ESTADOS.put("Encendido", 1);
        ESTADOS.put("Seleccionar_Tamaño", 2);
        ESTADOS.put("Preparando", 3);
        ESTADOS.put("Listo", 4);
    }
}
