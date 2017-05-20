package criptografia;

/**
 *
 * @author jocampo
 */
public class CriptografiaSimetrica {

    private static CriptografiaSimetrica instancia = null;
    
    private String password;
    private String msj;

    private CriptografiaSimetrica() {
        msj = null;
        password = "634";
    }
    
    public static CriptografiaSimetrica obtenerInstancia() {
      if(instancia == null) {
         instancia = new CriptografiaSimetrica();
      }
      return instancia;
   }

    public void setPassword(String password) {
        
        if(msj != null)
            descifrarMensaje(this.password);
        
        this.password = password;
        
        if(msj != null)
            cifrarMensaje(msj);
    }

    public void setMsj(String msj) {
        this.msj = cifrarMensaje(msj);
    }
    
    public String getMsj(String clave){
        if(msj == null)
            return "Error. No hay un mensaje configurado.\n";
        if (!clave.equals(password)) 
            return "Clave incorrecta\n";
        return msj;
    }

    /**
     * Método encargado de cifrar mensaje de forma simétrica.
     *
     * @param msj
     * @return
     */
    protected String cifrarMensaje(String msj) {

        String caracteres[] = msj.split("");
        int i = 0;
        int max = password.length() - 1;
        String pass[] = password.split("");

        StringBuffer cripto_pass = new StringBuffer();
        for (String caracter : caracteres) {
            if (i > max) {
                i = 0;
            }

            cripto_pass.append((char) ((int) caracter.charAt(0) + Integer.parseInt(pass[i])));

            i++;
        }

        this.msj = cripto_pass.toString();
        return this.msj;
    }

    protected String descifrarMensaje(String clave) {
        if (!clave.equals(password)) {
            return "Clave incorrecta\n";
        }

        String caracteres[] = msj.split("");
        int i = 0;
        int max = password.length() - 1;
        String pass[] = password.split("");

        StringBuffer decripto_pass = new StringBuffer();
        for (String caracter : caracteres) {
            if (i > max) {
                i = 0;
            }
            decripto_pass.append((char) ((int) caracter.charAt(0) - Integer.parseInt(pass[i])));
            i++;
        }

        this.msj = decripto_pass.toString();
        return this.msj;
    }
    
    public String generarMenuOpciones(){
         StringBuilder menu = new StringBuilder();
        
        menu.append("\n\n");
        menu.append("********* Criptografía Simétrica*************");
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
