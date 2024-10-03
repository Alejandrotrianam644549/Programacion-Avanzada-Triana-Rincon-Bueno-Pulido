import java.util.Scanner;

public class JuegoAhorcado {
    private Palabra palabra;
    private Ahorcado ahorcado;

    public JuegoAhorcado(Palabra palabra, Ahorcado ahorcado) {
        this.palabra = palabra;
        this.ahorcado = ahorcado;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean palabraAdivinadaCompletamente = false;

        while (!ahorcado.haPerdido() && !palabraAdivinadaCompletamente) {
            palabra.mostrarPalabra();
            System.out.print("Estudiante, adivine una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);

            boolean acierto = palabra.adivinarLetra(letra);

            if (!acierto) {
                ahorcado.incrementarFallos();
                ahorcado.mostrarAhorcado();
            }

            palabraAdivinadaCompletamente = palabra.estaAdivinada();
        }

        if (palabraAdivinadaCompletamente) {
            System.out.println("¡Felicidades, adivinaste la palabra!");
        } else {
            System.out.println("La palabra era: " + palabra.getPalabraOriginal());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Profesor, ingrese una palabra: ");
        String palabraOriginal = scanner.nextLine().toLowerCase();

        Palabra palabra = new Palabra(palabraOriginal);
        Ahorcado ahorcado = new Ahorcado();
        JuegoAhorcado juego = new JuegoAhorcado(palabra, ahorcado);

        System.out.println("\n\n\n\n\n\n\n\n\n");  // Limpiar la pantalla
        juego.jugar();
        scanner.close();
    }
}