public class Ahorcado {
    private int intentosFallidos;

    public Ahorcado() {
        this.intentosFallidos = 0;
    }

    public void mostrarAhorcado() {
        switch (intentosFallidos) {
            case 1:
                System.out.println("O");
                break;
            case 2:
                System.out.println("O");
                System.out.println("|");
                break;
            case 3:
                System.out.println(" O");
                System.out.println("/|");
                break;
            case 4:
                System.out.println(" O");
                System.out.println("/|\\");
                break;
            case 5:
                System.out.println(" O");
                System.out.println("/|\\");
                System.out.println("/");
                break;
            case 6:
                System.out.println(" O");
                System.out.println("/|\\");
                System.out.println("/ \\");
                System.out.println("¡Perdiste!");
                break;
        }
    }

    public void incrementarFallos() {
        intentosFallidos++;
    }

    public boolean haPerdido() {
        return intentosFallidos >= 6;
    }
}

