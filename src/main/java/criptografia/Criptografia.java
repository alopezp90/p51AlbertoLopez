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

    /**
     * Metodo que cifra una frase palabra a palabra. Primero fracciona por
     * palabras y luego va llamando a los metodos necesarios para: reordenar,
     * poner letras a principio y final, y finalemnte sustituir vocales por
     * numeros
     *
     * @param frase
     * @return
     */
    public static String cifra(String frase) {
        String cifrado = "";
        String[] palabras = frase.split(" ");
        for (String palabra : palabras) {
            System.out.println("La palabra " + palabra);
            palabra = reordena(palabra);
            palabra = masLetras(palabra);
            palabra = sustituye(palabra);
            cifrado = cifrado + palabra + " ";//Concatena las palabras con un espacio despues de cada una
        }
        cifrado = cifrado.substring(0, cifrado.length() - 1);//Quita último espacio al final de la frase cifrada
        return cifrado;
    }

    /**
     * Metodo que descifra una frase palabra a palabra. Primero fracciona por
     * palabras y luego va llamando a los metodos necesarios para: quitar primera
     * y ultima letra/numero, sustituir numeros por letras y finalmente reordenar
     * las letras
     *
     * @param cifrado String a descifrar
     * @return String descifrado
     */
    public static String descifra(String cifrado) {
        String frase = "";
        String[] palabras = cifrado.split(" ");
        for (String palabra : palabras) {
            System.out.println("La palabra " + palabra);
            palabra = menosLetras(palabra);
            palabra = sustituye(palabra);
            palabra = reordena(palabra);
            frase = frase + palabra + " ";//Concatena las palabras con un espacio despues de cada una
        }
        frase = frase.substring(0, frase.length() - 1);//Quita último espacio al final de la frase cifrada
        return frase;
    }

    /**
     * Metodo que invierte un String. Ademas muestra el estado final en consola.
     *
     * @param palabra String a invertir
     * @return String ya invertido
     */
    public static String reordena(String palabra) {
        String tmp = "";
        for (int i = 0; i < palabra.length(); i++) {
            tmp = palabra.charAt(i) + tmp;
        }
        System.out.println("  - Invertida es: " + tmp);
        return tmp;
    }

    /**
     * Metodo que sustituye vocales por numero y numeros por vocales. Ademas
     * muestra el estado final en consola.
     *
     * @param palabra String a modificar
     * @return String con sustitucion hecha
     */
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

    /**
     * Metodo que pone letras aleatorias antes y despues de cada palabra. Ademas
     * muestra el estado final en consola.
     *
     * @param palabra String a modificar
     * @return String con las letras aleatorias incluidas
     */
    public static String masLetras(String palabra) {
        Random random = new Random();
        String tmp = (char) (random.nextInt(26) + 'A') + palabra + (char) (random.nextInt(26) + 'A');
        System.out.println("  - Con letras adicionales es: " + tmp);
        return tmp;
    }

    /**
     * Metodo que quita la primera y ultima letra de una palabra. Ademas muestra
     * el estado final en consola.
     *
     * @param palabra String a modificar
     * @return String sin la primera y la ultima letra
     */
    public static String menosLetras(String palabra) {
        String tmp = "";
        for (int i = 1; i < palabra.length() - 1; i++) {
            tmp = tmp + palabra.charAt(i);
        }
        System.out.println("  - Sin letras adicionales es: " + tmp);
        return tmp;
    }
}
