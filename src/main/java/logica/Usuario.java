package logica;



import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    // private int id;
    private String nombreUsuario;
    private String contrasenia;
    private ArrayList<String> contraseniaAnterior =  new ArrayList<>();



    private List<String> lineas;

    //Constructor
    public Usuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }


// Validar contraseña

    public void esContraseñaSegura() {
        try {

            if (    cumpleCantidadDeCaracteres() &&
                    !seEncuentraEnElTopDeLasPeoresContraseñas() &&
                    coincideConUsuario() &&
                    !contieneCaracterRepetitivo() &&
                    !contieneCaracterSecuencial() &&
                    contieneDiversosCaracteres() &&
                    esDistintaALaAnterior()
            )
                {
                System.out.println("La contraseña ha cumplido exitosamente con los requisitos.");
                contraseniaAnterior.add(contrasenia);
            }


        } catch (CustomException e) {
            System.out.println("Contraseña inválida debido a: " +
                    e.getMessage());
        }

    }

    public List<String> leerArchivo() {
        Path path = Paths.get("src/main/java/logica/TopPeoresContraseñas.txt");
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean contieneDiversosCaracteres() throws CustomException{

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneCaracterEspecial = false;

        for (char c : contrasenia.toCharArray()) { //lo convierte en un vector de caracteres
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else {
                tieneCaracterEspecial = true;
            }

        }
        if (!(tieneMayuscula && tieneMinuscula && tieneNumero && tieneCaracterEspecial)){
            throw new CustomException("debe poseer como mínimo: " +
                                        "Un caracter especial, un número," +
                                        " una mayúscula, una minúsucla ");
        };
        return true;
    }
    public boolean seEncuentraEnElTopDeLasPeoresContraseñas() throws CustomException {
        int i = 0;
        for (String cadena : this.leerArchivo()) {
            if (contrasenia.equals(cadena)) {
                i++;
            }
        }
        if ( i != 0){
            throw new CustomException("se encuentra en el top de las peores contraseñas.");
        } else return false;

    }
    public boolean coincideConUsuario() throws CustomException{
    if (this.contrasenia.equals(this.nombreUsuario)){
        throw new CustomException("no puede coincidir con el usuario");
         } else return true;
    }
    public boolean contieneCaracterSecuencial() throws CustomException{
            char[] caracteres = contrasenia.toCharArray();
            int j = 0;
            for (int i = 0; i < caracteres.length - 1; i++) {
            // Verificar si el siguiente carácter es secuencial al actual

            if (caracteres[i] + 1 == caracteres[i + 1]) {
                j++;
            }
    }
            if (j != 0){
                throw new CustomException("no puede contener caracteres secuenciales.");

            } else return false;
    }
    public boolean contieneCaracterRepetitivo () throws CustomException {
        Pattern patron = Pattern.compile("(.)\\1+");
        Matcher matcher = patron.matcher(contrasenia);
        if (matcher.find()){
            throw new CustomException("no puede contener caracteres repetitivos.");
        }
        else return false;
    }
    public boolean cumpleCantidadDeCaracteres() throws CustomException{
    if     (this.contrasenia.length() < 8){
        throw new CustomException("no es lo suficientemente larga.");
         } else return true;
    }

    public  boolean esDistintaALaAnterior()throws  CustomException{
        if (contraseniaAnterior.contains(contrasenia)){
            throw new CustomException("no puede coincidir con la anterior contraseña.");
        } else return true;
    }
}