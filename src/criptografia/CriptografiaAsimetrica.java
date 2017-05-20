
package criptografia;

/**
 *
 * @author jocampo
 */
public class CriptografiaAsimetrica {
    
    
    
    private final int P = 5;
    private final int Q = 7;
    private int z;
    private int phi;
    private int n;
    
    private static CriptografiaAsimetrica instancia = null;
    
    private CriptografiaAsimetrica(){
        z = P * Q;
        phi = (P -1) * (Q -1);
    }
    
    public static CriptografiaAsimetrica obtenerInstancia() {
      if(instancia == null) {
         instancia = new CriptografiaAsimetrica();
      }
      return instancia;
    }
    
    public String generarMenuOpciones(){
        StringBuilder menu = new StringBuilder();
        
        menu.append("\n\n");
        menu.append("********* Criptografía Asimétrica*************");
        menu.append("\n");
        menu.append("****menú****");
        menu.append("\n");
        menu.append("1. Cambiar clave\n");
        menu.append("2. Encriptar Mensaje\n");
        menu.append("3. Desencriptar Mensaje\n");
        menu.append("4. Ver mensaje encriptado\n");
        menu.append("9. Regresar\n");
        
        return menu.toString();
    }
    
}
