package criptografia;

/**
 *
 * @author jocampo
 */
public class CriptografiaSimetrica {

    //Variable estática para manejar nuestra instancia de clase estilo singleton
    private static CriptografiaSimetrica instancia = null;
    
    //Password de encriptación
    private String password;
    //Mensaje 
    private String msj;

    //Constructor
    private CriptografiaSimetrica() {
        //Valores por defecto
        msj = null;
        password = "634";
    }
    
    //Método para obtener instancia singleton
    public static CriptografiaSimetrica obtenerInstancia() {
      if(instancia == null) {
         instancia = new CriptografiaSimetrica();
      }
      return instancia;
   }

    /*                Métodos relacionados con proceso de criptografía       */
    
    /*
    Método para asignar contraseña
    */
    public void setPassword(String password) {
        /*
        Se debe tener en cuenta que si ya existe un mensaje previamente guardado,
        se debe descifrar primero para obtenerlo en su forma original, ya que
        si cambiamos la clave y no desciframos mensaje antes de esto, ya no podremos
        descifrarlo con la nueva clave, nos arrojará un resultado erróneo.
        */
        if(msj != null)
            descifrarMensaje(this.password);
        
        //Asignar nuevo password
        this.password = password;
        
        /*
        Se debe validar si existe mensaje (previamente desencriptado), para volverlo
        a encriptar con la nueva clave.
        */
        if(msj != null)
            cifrarMensaje(msj);
    }

    /**
     * Método que permite asignar un nuevo mensaje y encriptarlo.
     * Recibe como parámetro el mensaje a encriptar
     * @param msj 
     */
    public void setMsj(String msj) {
        //Llamado al método de encriptación
        this.msj = cifrarMensaje(msj);
    }
    
    /**
     * Método para obtener y visualizar el mensaje en el estado que este se
     * encuentre (Encriptado o no), validando de antemano la clave.
     * @param clave
     * @return 
     */
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

        //Dividimos mensaje en caracteres que lo componen
        String caracteres[] = msj.split("");
        
        //Contador
        int i = 0;
        //Contador de longitud de contraseña
        int max = password.length() - 1;
        //Dividimos contraseña en caracteres
        String pass[] = password.split("");
        
        //Buffer para mensaje encriptado
        StringBuffer cripto_pass = new StringBuffer();
        
        /*Recorremos cada caracter del mensaje y lo asociamos con un número de
          la contraseña
        */
        for (String caracter : caracteres) {
            /*
            Si el mensaje es más extenso que la contraseña, reiniciamos la 
            asignación de digitos de la contraseña
            */
            if (i > max) {
                i = 0;
            }

            /*
            Aquí se obtiene el nuevo caracter al desplazar a la derecha, tantas
            posiciones como lo indique el digito asociado de contraseña, el carac
            ter original del mensaje.
            */
            cripto_pass.append((char) ((int) caracter.charAt(0) + Integer.parseInt(pass[i])));

            //Desplaamiento al siguiente dígito de contraseña
            i++;
        }

        //Se asigna nuevo mensaje encriptado a variable (atributo) msj
        this.msj = cripto_pass.toString();
        return this.msj;
    }

    /**
     * Método que retorna el mensaje descifrado
     * @param clave
     * @return 
     */
    protected String descifrarMensaje(String clave) {
        //Validación de clave
        if (!clave.equals(password)) {
            return "Clave incorrecta\n";
        }

        //Obtener dígitos de contraseña
        String caracteres[] = msj.split("");
        
        //Variables de control iguale que método de cifrado
        int i = 0;
        int max = password.length() - 1;
        String pass[] = password.split("");

        //Buffer para almacenar caracteres de mensaje descifrado
        StringBuffer decripto_pass = new StringBuffer();
        for (String caracter : caracteres) {
            if (i > max) {
                i = 0;
            }
            /*
            Para el caso de descifrar, el desplazamiento en el código ASCII
            se realiza hacia la izquierda, esto es, devolviendonos las posiciones
            que indica la clave, en dicho código.
            */
            decripto_pass.append((char) ((int) caracter.charAt(0) - Integer.parseInt(pass[i])));
            i++;
        }

        //Se asigna mensaje decodificado
        this.msj = decripto_pass.toString();
        //Retorna mensaje
        return this.msj;
    }
    
    /**
     * Método que construye menú de opciones para criptografía Simétrica.
     * @return 
     */
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
