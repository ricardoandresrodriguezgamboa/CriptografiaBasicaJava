
import criptografia.ManejadorCriptografia;
import java.util.Scanner;

/**
 *
 * @author jocampo
 */
public class Aplicacion {
    public static void main(String[] args) {
        
        boolean ejecutar = true;
        
        Scanner entrada = new Scanner(System.in);
        
        StringBuilder menu = new StringBuilder();
        menu.append("Menu\n");
        menu.append("Seleccione una opción\n");
        menu.append("1. Criptografía Simétrica\n");
        menu.append("9. Salir\n");

        int option;
        String mensaje;
        String clave;
        ManejadorCriptografia manejador = new ManejadorCriptografia();
        
        while(ejecutar){
            System.out.println(menu.toString());
            option = Integer.parseInt(entrada.nextLine());

            switch (option) {
                
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
