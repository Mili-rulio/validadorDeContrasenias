package logica;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        String nombreUsuario;
        String contrasenia;

        System.out.println("Ingrese el nombre de usuario: ");
        nombreUsuario = teclado.nextLine();
        System.out.println("Ingrese la nueva contraseña: ");
        contrasenia = teclado.nextLine();
        Usuario usuario = new Usuario(nombreUsuario, contrasenia);

        System.out.println("El sistema indica: " + usuario.esContraseñaSegura());

    }

}
