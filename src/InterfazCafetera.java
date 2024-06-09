//Desde aqui se controlan las interacciones con la terminal
public class InterfazCafetera {
    private Cafetera cafetera;
    //Primer constructor, recibe el estado de la cafetera
    public InterfazCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }
    //Este metodo muestra las opciones dependiendo del estado
    //En que se encuentre la cafetera
    //EJ: Seleccionar tamaño = tamallo S , L , XL
    public void mostrarOpciones() {
        System.out.println("Estado actual: " + cafetera.obtenerEstado());
        switch (cafetera.getEstadoActual()) {
            case 0:
                opcionesApagado();
                break;
            case 1:
                opcionesEncendido();
                break;
            case 2:
                opcionesSeleccionarTamaño();
                break;
            case 3:
                opcionesPreparando();
                break;
            case 4:
                opcionesListo();
                break;
        }
    }
    //Opciones cuando esta apagado
    private void opcionesApagado() {
        System.out.println("Opciones: encender, salir");
    }
    //Opciones cuando esta encendida
    private void opcionesEncendido() {
        System.out.println("Opciones: preparar, apagar");
    }
    //Opciones de tamaño
    private void opcionesSeleccionarTamaño() {
        System.out.println("Opciones: seleccionar S, seleccionar L, seleccionar XL");
    }

    // Opciones cuando el café se está preparando.
    private void opcionesPreparando() {
        System.out.println("El café se está preparando...");
        cafetera.finalizarPreparacion();
        System.out.println("El café está listo.");
        System.out.println("Opciones: finalizar");
    }

    private void opcionesListo() {
        System.out.println("Opciones: finalizar");
    }
    //Aqui se procesa la opcion seleccionada por el usuario
    public void procesarOpcion(String opcion) {
        switch (cafetera.getEstadoActual()) {
            case 0:
                if (opcion.equals("encender")) {
                    cafetera.encender();
                } else if (opcion.equals("salir")) {
                    System.exit(0);
                } else {
                    cerrarPrograma();
                }
                break;
            case 1:
                if (opcion.equals("preparar")) {
                    cafetera.cambiarEstado(EstadosCafetera.ESTADOS.get("Seleccionar_Tamaño"));
                } else if (opcion.equals("apagar")) {
                    cafetera.apagar();
                } else {
                    cerrarPrograma();
                }
                break;
            case 2:
                if (opcion.startsWith("seleccionar")) {
                    String[] partes = opcion.split(" ");
                    if (partes.length == 2) {
                        cafetera.seleccionarTamaño(partes[1].toUpperCase());
                        cafetera.preparar();
                    } else {
                        cerrarPrograma();
                    }
                } else {
                    cerrarPrograma();
                }
                break;
            case 3:
                if (opcion.equals("finalizar")) {
                    cafetera.finalizarPreparacion();
                    cafetera.cambiarEstado(EstadosCafetera.ESTADOS.get("Encendido"));
                } else {
                    cerrarPrograma();
                }
                break;
            case 4:
                if (opcion.equals("finalizar")) {
                    cafetera.cambiarEstado(EstadosCafetera.ESTADOS.get("Encendido"));
                } else {
                    cerrarPrograma();
                }
                break;
            default:
                cerrarPrograma();
        }
    }
    //Metodo de Foso, Cuando se equivoca incluso en una Letra
    //Se va al foso  ☠️💀
    private void cerrarPrograma() {
        System.out.println("Opción no valida. Se fue al Foso ☠️💀.");
        System.exit(1);
    }
}
