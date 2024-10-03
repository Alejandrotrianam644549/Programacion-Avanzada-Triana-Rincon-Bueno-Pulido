public class Palabra {
    private String palabraOriginal;
    private char[] palabraAdivinada;

    public Palabra(String palabraOriginal) {
        this.palabraOriginal = palabraOriginal.toLowerCase();
        this.palabraAdivinada = new char[palabraOriginal.length()];
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }
    }

    public boolean adivinarLetra(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraOriginal.length(); i++) {
            if (palabraOriginal.charAt(i) == letra) {
                palabraAdivinada[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    public void mostrarPalabra() {
        for (char c : palabraAdivinada) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public boolean estaAdivinada() {
        for (char c : palabraAdivinada) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public String getPalabraOriginal() {
        return palabraOriginal;
    }
}

