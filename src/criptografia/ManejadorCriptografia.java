package criptografia;

import java.util.Scanner;

/**
 *
 * @author jocampo
 */
public class ManejadorCriptografia {

    //Mensaje a encriptar
    String mensaje;
    //Datos de entrada por línea de comandos
    Scanner entrada;
    //Opción seleccionada
    int option;

    public ManejadorCriptografia() {
        entrada = new Scanner(System.in);
    }

    /**
     * Método que maneja las opciones relacionadas a criptografía simétrica
     */
    public void criptografiaSimetrica() {
        //Obtener instancia de CriptografiaSimetrica
        CriptografiaSimetrica cSimetrica = CriptografiaSimetrica.obtenerInstancia();
        String clave = "";
        //Control de ejecución
        boolean ejecutar = true;
        String submenu = cSimetrica.generarMenuOpciones();
        
        while(ejecutar){
            //Mostrar submenu 
            System.out.println(submenu);
            option = Integer.parseInt(entrada.nextLine());
            
            switch(option){
                //Asignar nueva clave
                case 1:
                    System.out.println("Ingrese la nueva clave");
                    clave = entrada.nextLine();
                    cSimetrica.setPassword(clave);
                    break;
                //Encriptar mensaje
                case 2:
                    System.out.println("Ingrese el Mensaje");
                    mensaje = entrada.nextLine();
                    cSimetrica.cifrarMensaje(mensaje);
                    break;
                //Desencriptar mensaje
                case 3:
                    System.out.println("Ingrese la clave");
                    clave = entrada.nextLine();
                    System.out.println("El mensaje original es: " + cSimetrica.descifrarMensaje(clave));
                    break;
                //Mostrar mensaje encriptado
                case 4:
                    System.out.println("Ingrese la clave");
                    clave = entrada.nextLine();
                    System.out.println("El mensaje encriptado es: " + cSimetrica.getMsj(clave));
                    break;
                //Salir de cifrado simétrico
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
}
