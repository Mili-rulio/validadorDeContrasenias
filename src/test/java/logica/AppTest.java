package logica;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */

public class AppTest {

//Elegir alguno de estos para la primer clase de equivalencia

@Test

//TEST SIN MAYÚSCULAS: NO PASA
public void contraseñaSinMayuscula(){
    Usuario usuario = new Usuario("mrulio", "rosalia54!");
    Assertions.assertFalse(usuario.esContraseñaSegura());
}

@Test
//TEST SIN MINÚSCULAS: NO PASA
public void contraseñaSinMinuscula(){
    Usuario usuario = new Usuario("mrulio", "ROSALIA54!");
    Assertions.assertFalse(usuario.esContraseñaSegura());
}
@Test
//TEST SIN CARACTER_ESPECIAL: NO PASA
public void contraseñaSinCaracterEspecial(){
    Usuario usuario = new Usuario("mrulio", "ROSALIA54");
    Assertions.assertFalse(usuario.esContraseñaSegura());
}
@Test
//TEST SIN NÚMEROS: NO PASA
public void contraseñaSinCaracterNumero(){
    Usuario usuario = new Usuario("mrulio", "Rosalia!");
    Assertions.assertFalse(usuario.esContraseñaSegura());
}
@Test
//TEST NO CUMPLE CANTIDAD MINIMA DE CARACTERES: NO PASA
public void contraseñaCorta(){
    Usuario usuario = new Usuario("mrulio", "Ros!4");
    Assertions.assertFalse(usuario.esContraseñaSegura());
}

@Test
// Segunda clase de equivalencia //

//TEST CUMPLE TODOS LOS REQUISITOS Y ESTÁ EN LA LISTA DE LAS PEORES CONTRASEÑAS: NO PASA
public void laContraseñaEstaEnLaLista(){
    Usuario usuario = new Usuario("mrulio", "Rosalia54!");
        Assertions.assertFalse(usuario.esContraseñaSegura());
    }

@Test
// Tercer clase de equivalencia //

//TEST CUMPLE TODOS LOS REQUISITOS Y NO ESTÁ EN LA LISTA DE LAS PEORES CONTRASEÑAS: PASA
public void elUsuarioCumpleConLosRequisitosYNoEstaEnLaLista(){
        Usuario usuario = new Usuario("mrulio", "Lapiña32!");
    Assertions.assertTrue(usuario.esContraseñaSegura());
    }





}
