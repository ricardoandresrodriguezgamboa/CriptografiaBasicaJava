
import criptografia.ManejadorCriptografia;
import java.util.Scanner;

/**
 *
 * @author jocampo
 */
public class Aplicacion {
    
    /*
    Método main
    */
    public static void main(String[] args) {
        
        //Control de ejecución
        boolean ejecutar = true;
        //Entrada de texto por línea de comandos
        Scanner entrada = new Scanner(System.in);
        //Menú principal
        StringBuilder menu = new StringBuilder();
        menu.append("Menu\n");
        menu.append("Seleccione una opción\n");
        menu.append("1. Criptografía Simétrica\n");
        menu.append("9. Salir\n");

        //Opción a seleccionar de menú
        int option;
        //Mensaje y clave
        String mensaje;
        String clave;
        
        //Manager para control de criptografía simétrica y pronto asimétrica
        ManejadorCriptografia manejador = new ManejadorCriptografia();
        
        //Vamos a ver la estructura del proyecto:
        while(ejecutar){
            System.out.println(menu.toString());
            option = Integer.parseInt(entrada.nextLine());

            switch (option) {
                //Criptografía Simétrica
                case 1:
                    manejador.criptografiaSimetrica();
                    break;
                    
                case 9:
                    ejecutar = false;
                    break;
                    
                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
        }
    }
}
