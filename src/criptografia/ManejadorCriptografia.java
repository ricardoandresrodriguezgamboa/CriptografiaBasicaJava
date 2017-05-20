package criptografia;

import java.util.Scanner;

/**
 *
 * @author jocampo
 */
public class ManejadorCriptografia {

    String mensaje;
    Scanner entrada;
    int option;

    public ManejadorCriptografia() {
        entrada = new Scanner(System.in);
    }

    public void criptografiaSimetrica() {
        CriptografiaSimetrica cSimetrica = CriptografiaSimetrica.obtenerInstancia();
        String clave = "";
        boolean ejecutar = true;
        String submenu = cSimetrica.generarMenuOpciones();
        
        while(ejecutar){
            System.out.println(submenu);
            option = Integer.parseInt(entrada.nextLine());
            
            switch(option){
                case 1:
                    System.out.println("Ingrese la nueva clave");
                    clave = entrada.nextLine();
                    cSimetrica.setPassword(clave);
                    break;
                case 2:
                    System.out.println("Ingrese el Mensaje");
                    mensaje = entrada.nextLine();
                    cSimetrica.cifrarMensaje(mensaje);
                    break;
                case 3:
                    System.out.println("Ingrese la clave");
                    clave = entrada.nextLine();
                    System.out.println("El mensaje original es: " + cSimetrica.descifrarMensaje(clave));
                    break;
                case 4:
                    System.out.println("Ingrese la clave");
                    clave = entrada.nextLine();
                    System.out.println("El mensaje encriptado es: " + cSimetrica.getMsj(clave));
                    break;
                case 9:
                    ejecutar = false;
                    break;
                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
            
            System.out.println("\n");
        }
        
    }
    
    public void criptografiaAsimetrica(){
        
    }
}
