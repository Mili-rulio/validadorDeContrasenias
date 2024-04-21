package logica;

public class CustomException extends Exception{
    public static final long serialVersionUID = 700L;

    public CustomException(String mensaje) {
        super(mensaje); //mensaje de por qué está tirando la excepcion
    }
}
