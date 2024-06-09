import java.util.Scanner;

//Main
public class Cafetera_Amaretto {
    public static void main(String[] args) {
        //Llama una nueva cafetera
        Cafetera cafetera = new Cafetera();
        //Abre de nuevo las opciones en
        InterfazCafetera interfaz = new InterfazCafetera(cafetera);
        //El scanner mira la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        //Ciclo que controla la interaccion del usuario
        while (true) {
            //Se muestran las opciones disponibles
            interfaz.mostrarOpciones();
            //se lee la opcion seleccionada y
            String opcion = scanner.nextLine().trim().toLowerCase();
            //recibe la opcion seleccionada
            interfaz.procesarOpcion(opcion);
            System.out.println();
        }
    }
}
