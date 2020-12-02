package criptografia;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.util.Scanner;
import java.util.Random;

public class Criptografia {

    //Este método permite elegir qué se desea hacer y llama a los métodos correspondientes
    public static void main(String[] args) {
        int opcion;
        boolean repite = true;
        String frase, cifrado;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Indique qué desea hacer:");
            System.out.println("  1- Cifrar");
            System.out.println("  2- Descifrar");
            System.out.println("  3- Salir");
            opcion = sc.nextInt();
            sc.nextLine();      //Limpiamos el objeto de scanner antes de meter el String

            switch (opcion) {
                case 1:
                    System.out.println("Introduce frase a cifrar:");
                    frase = sc.nextLine();
                    frase = frase.toUpperCase();    //Pone la frase en mayúsculas
                    cifrado = cifra(frase);
                    System.out.println("------------------------------------------------");
                    System.out.println("La frase:");
                    System.out.println(frase);
                    System.out.println("Se ha cifrado:");
                    System.out.println(cifrado);
                    break;
                case 2:
                    System.out.println("Introduce la frase a descifrar:");
                    cifrado = sc.nextLine();
                    frase = descifra(cifrado);
                    System.out.println("------------------------------------------------");
                    System.out.println("El cifrado:");
                    System.out.println(cifrado);
                    System.out.println("Se ha descifrado:");
                    System.out.println(frase);
                    break;
                default:
                    System.out.println("ADIOS");
                    repite = false;
            }
            System.out.println("------------------------------------------------");
        } while (repite);
    }

    //Este método cifra una frase palabra a palabra. Primero fracciona por palabras
    //y luego por cada una: reordena, pone letras a principio y final, y
    //finalemnte sustituye vocales por numeros
    public static String cifra(String frase) {
        String cifrado = "";
        String[] palabras = frase.split(" ");
        for (String palabra : palabras) {
            System.out.println("La palabra "+ palabra);
            palabra = reordena(palabra);
            palabra = masLetras(palabra);
            palabra = sustituye(palabra);
            cifrado = cifrado + palabra + " "; //Concatena las palabras con un espacio despues de cada una
        }
        cifrado = cifrado.substring(0, cifrado.length() - 1);   //Quita último espacio al final de la frase cifrada
        return cifrado;
    }

    //Este método descifra una frase palabra a palabra. Primero fracciona por palabras
    //y luego porcada una: quita primera y última letra/numero, sustituye numeros por letras
    //y finalmente reordena las letras
    public static String descifra(String cifrado) {
        String frase = "";
        String[] palabras = cifrado.split(" ");
        for (String palabra : palabras) {
            System.out.println("La palabra "+ palabra);
            palabra = menosLetras(palabra);
            palabra = sustituye(palabra);
            palabra = reordena(palabra);
            frase = frase + palabra + " "; //Concatena las palabras con un espacio despues de cada una
        }
        frase = frase.substring(0, frase.length() - 1);     //Quita último espacio al final de la frase cifrada     
        return frase;
    }

    //Este método reordena las letras de una palabra en orden inverso
    public static String reordena(String palabra) {
        String tmp = "";
        for (int i = 0; i < palabra.length(); i++) {
            tmp = palabra.charAt(i) + tmp;
        }
        System.out.println("  - Invertida es: " + tmp);
        return tmp;
    }

    //Este método cambia las vocales por su correspondiente número y viceversa
    public static String sustituye(String palabra) {
        String tmp = "";
        for (int i = 0; i < palabra.length(); i++) {
            switch (palabra.charAt(i)) {
                case 'A':
                    tmp = tmp + '5';
                    break;
                case 'E':
                    tmp = tmp + '4';
                    break;
                case 'I':
                    tmp = tmp + '3';
                    break;
                case 'O':
                    tmp = tmp + '2';
                    break;
                case 'U':
                    tmp = tmp + '1';
                    break;
                case '5':
                    tmp = tmp + 'A';
                    break;
                case '4':
                    tmp = tmp + 'E';
                    break;
                case '3':
                    tmp = tmp + 'I';
                    break;
                case '2':
                    tmp = tmp + 'O';
                    break;
                case '1':
                    tmp = tmp + 'U';
                    break;
                default:
                    tmp = tmp + palabra.charAt(i);
            }
        }
        System.out.println("  - Sustituyendo vocales por números es: " + tmp);
        return tmp;
    }

    //Este método pone letras aleatorias antes y despues de cada palabra
    public static String masLetras(String palabra) {
        Random random = new Random();
        String tmp = (char) (random.nextInt(26) + 'A') + palabra + (char) (random.nextInt(26) + 'A');
        System.out.println("  - Con letras adicionales es: " + tmp);
        return tmp;
    }

    //Este método quita la primera y última letra de una palabra
    public static String menosLetras(String palabra) {
        String tmp = "";
        for (int i = 1; i < palabra.length() - 1; i++) {
            tmp = tmp + palabra.charAt(i);
        }
        System.out.println("  - Sin letras adicionales es: " + tmp);
        return tmp;
    }
}
