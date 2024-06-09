import java.util.HashMap;
import java.util.Map;

public class Cafetera {
    //Estado en que se encuentra la cafetera
    private int estadoActual;
    //Este constructor da apertura a la cafetera en estado apagado o estado 0
    public Cafetera() {
        estadoActual = EstadosCafetera.ESTADOS.get("Apagado");
    }
    //metodo para cambiar de estado :)
    public void cambiarEstado(int nuevoEstado) {
        estadoActual = nuevoEstado;
    }

    //metodo para encender la cafetera o acceder al estado 1
    public void encender() {
        if (estadoActual == EstadosCafetera.ESTADOS.get("Apagado")) {
            cambiarEstado(EstadosCafetera.ESTADOS.get("Encendido"));
        } else {
            System.out.println("La cafetera ya está encendida o no puede encenderse en el estado actual.");
        }
    }

    //metodo para seleccionar el tamaño del cafe o accedr al estado 2
    public void seleccionarTamaño(String tamaño) {
        if (estadoActual == EstadosCafetera.ESTADOS.get("Encendido") && (tamaño.equals("S") || tamaño.equals("L") || tamaño.equals("XL"))) {
            cambiarEstado(EstadosCafetera.ESTADOS.get("Seleccionar_Tamaño"));
        }
    }
    //metodo para preparar el cafe o acceder al estado 3
    public void preparar() {
        if (estadoActual == EstadosCafetera.ESTADOS.get("Seleccionar_Tamaño")) {
            cambiarEstado(EstadosCafetera.ESTADOS.get("Preparando"));
        } else {
            System.out.println("Debe seleccionar un tamaño primero.");
        }
    }
    //metodo para finalizar o acceder al estado 4
    public void finalizarPreparacion() {
        if (estadoActual == EstadosCafetera.ESTADOS.get("Preparando")) {
            cambiarEstado(EstadosCafetera.ESTADOS.get("Listo"));
        } else {
            System.out.println("Debe iniciar la preparación primero.");
        }
    }
    //Metodo para apagar la cafetera
    public void apagar() {
        if (estadoActual == EstadosCafetera.ESTADOS.get("Encendido") || estadoActual == EstadosCafetera.ESTADOS.get("Seleccionar_Tamaño") ||
                estadoActual == EstadosCafetera.ESTADOS.get("Preparando") || estadoActual == EstadosCafetera.ESTADOS.get("Listo")) {
            cambiarEstado(EstadosCafetera.ESTADOS.get("Apagado"));
        } else {
            System.out.println("La cafetera no se puede apagar en el estado actual.");
        }
    }
    //metodo para obtener el estado actual de la cafetera GEt
    public String obtenerEstado() {
        for (Map.Entry<String, Integer> entry : EstadosCafetera.ESTADOS.entrySet()) {
            if (estadoActual == entry.getValue()) {
                return entry.getKey();
            }
        }
        return "Estado desconocido";
    }
    //Aqui se traducen los metodos a estados numericos
    public int getEstadoActual() {
        return estadoActual;
    }
}
