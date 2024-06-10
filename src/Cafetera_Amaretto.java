//Integrante 1: Juan Felipe Ruiz 2359397-2724
// Integrante 2: Jhorman Loaiza 2359710-2724
//Docente: Luis German Toro Pareja
//Matematicas Discretas 2
//Grupo 51
//Laboratorio 5

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
