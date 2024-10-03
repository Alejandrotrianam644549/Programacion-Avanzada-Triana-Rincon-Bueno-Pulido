import java.io.Console;

public class JuegoAhorcado {
    private Palabra palabra;
    private Ahorcado ahorcado;

    public JuegoAhorcado(Palabra palabra, Ahorcado ahorcado) {
        this.palabra = palabra;
        this.ahorcado = ahorcado;
    }

    public void jugar() {
        Console console = System.console();
        if (console == null) {
            System.out.println("La consola no está disponible. Por favor, ejecute en una terminal.");
            return;
        }

        boolean palabraAdivinadaCompletamente = false;

        while (!ahorcado.haPerdido() && !palabraAdivinadaCompletamente) {
            palabra.mostrarPalabra();
            System.out.print("Estudiante, adivine una letra: ");
            char letra = console.readLine().toLowerCase().charAt(0);

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
    }

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("La consola no está disponible. Por favor, ejecute en una terminal.");
            return;
        }

        char[] palabraIngresada = console.readPassword("Profesor, ingrese una palabra: ");
        String palabraOriginal = new String(palabraIngresada).toLowerCase();

        Palabra palabra = new Palabra(palabraOriginal);
        Ahorcado ahorcado = new Ahorcado();
        JuegoAhorcado juego = new JuegoAhorcado(palabra, ahorcado);

        System.out.println("\n\n\n\n\n\n\n\n\n");  // Limpiar la pantalla
        juego.jugar();
    }
}
