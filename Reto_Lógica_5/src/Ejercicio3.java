import java.io.*;

public class Ejercicio3 {

    public static void main(String[] args) {
        try {
            // Paso a) Abrir fichero "tres.dat" para escritura binaria
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("tres.dat"));

            // Paso b) Pedir números al usuario y escribir en "tres.dat"
            pedirNumerosYGuardarEnFichero(dos);

            // Paso c) El proceso ha finalizado, cerrar el DataOutputStream
            dos.close();

        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    // Método para pedir números al usuario y escribir en "tres.dat"
    public static void pedirNumerosYGuardarEnFichero(DataOutputStream dos) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce números positivos. Introduce un número negativo para finalizar.");
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(br.readLine());
                if (numero < 0) {
                    break;
                }
                dos.writeInt(numero);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número entero válido.");
            }
        }
        br.close();
    }
}
