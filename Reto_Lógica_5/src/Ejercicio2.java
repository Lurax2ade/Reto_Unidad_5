import java.io.*;

public class Ejercicio2 {

    public static void main(String[] args) {
        try {
            // Paso a) Mostrar directorio actual y crear directorio con ficheros
            String directorioActual = System.getProperty("user.dir");
            System.out.println("Directorio actual: " + directorioActual);
            String nombreDirectorio = "dirEjer2";
            String rutaDirectorio = directorioActual + File.separator + nombreDirectorio;
            crearDirectorioConFicheros(rutaDirectorio);

            // Paso b) Abrir fichero "uno.txt" para escritura
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaDirectorio + File.separator + "uno.txt"));

            // Paso c) Pedir nombres al usuario y escribir en "uno.txt"
            pedirNombresYEscribirEnFichero(bw);

            // Paso d) El proceso ha finalizado, cerrar el BufferedWriter
            bw.close();

            // Paso e) Abrir fichero "dos.txt" para lectura y mostrar su contenido
            BufferedReader br = new BufferedReader(new FileReader(rutaDirectorio + File.separator + "dos.txt"));
            mostrarContenidoFichero(br);
            br.close();

        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    // Método para crear directorio con ficheros
    public static void crearDirectorioConFicheros(String rutaDirectorio) throws IOException {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Directorio creado: " + rutaDirectorio);
                File fichero1 = new File(rutaDirectorio + File.separator + "uno.txt");
                File fichero2 = new File(rutaDirectorio + File.separator + "dos.txt");
                if (fichero1.createNewFile()) {
                    System.out.println("Fichero uno.txt creado.");
                }
                if (fichero2.createNewFile()) {
                    System.out.println("Fichero dos.txt creado.");
                }
            } else {
                System.out.println("Error al crear el directorio.");
            }
        } else {
            System.out.println("El directorio ya existe.");
        }
    }

    // Método para pedir nombres al usuario y escribir en "uno.txt"
    public static void pedirNombresYEscribirEnFichero(BufferedWriter bw) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce nombres de personas. Presiona '-' y Enter para finalizar.");
        String nombre;
        while (true) {
            nombre = br.readLine();
            if (nombre.equals("-")) {
                break;
            }
            bw.write(nombre + "\n");
        }
        br.close();
    }

    // Método para mostrar contenido de un fichero
    public static void mostrarContenidoFichero(BufferedReader br) throws IOException {
        System.out.println("Contenido del fichero dos.txt:");
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    }
}