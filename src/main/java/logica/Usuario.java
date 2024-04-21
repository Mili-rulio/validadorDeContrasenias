package logica;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;


public class Usuario {
    // private int id;
    private String nombreUsuario;
    private String contrasenia;
    private List<String> lineas;

    //Constructor
    public Usuario(String nombreUsuario, String contrasenia) {

        this.nombreUsuario = nombreUsuario;

        this.contrasenia = contrasenia;

    }


// Validar contraseña

    public boolean esContraseñaSegura() {

        if (this.contrasenia.length() < 8 || seEncuentraEnElTopDeLasPeoresContraseñas() || coincideConUsuario())
            return false;

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
        return tieneMayuscula && tieneMinuscula && tieneNumero && tieneCaracterEspecial;
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


    public boolean seEncuentraEnElTopDeLasPeoresContraseñas() {
        int i = 0;
        for (String cadena : this.leerArchivo()) {
            if (Objects.equals(contrasenia, cadena)) {
                i++;
            }
        }
        return i != 0; //si es verdadero significa que seEncuentraEnElTopDeLasPeoresContraseñas y arroja verdadero
    }


    public boolean coincideConUsuario() {
    return Objects.equals(this.nombreUsuario, this.contrasenia);
    }
}