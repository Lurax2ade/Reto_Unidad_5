
import java.io.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Paso a) Pedir al usuario nombres de ficheros
        String nombreArchivo1 = pedirNombreArchivo(br);
        String nombreArchivo2 = pedirNombreArchivo(br);

        // Paso b) Obtener ruta del directorio actual
        String directorioActual = System.getProperty("user.dir");
        System.out.println("Directorio actual: " + directorioActual);

        // Paso c) Crear los ficheros
        String rutaCompletaFich1 = directorioActual + File.separator + nombreArchivo1;
        String rutaCompletaFich2 = directorioActual + File.separator + nombreArchivo2;
        if (!comprobarExiste(new File(rutaCompletaFich1))) {
            crearFichero(nombreArchivo1);
        }
        if (!comprobarExiste(new File(rutaCompletaFich2))) {
            crearFichero(nombreArchivo2);
        }

        // Paso e) Escribir datos en el primer fichero
        if (comprobarExiste(new File(rutaCompletaFich1))) {
            escribirEnFichero(nombreArchivo1);
        }

        // Paso f) Leer contenido del primer fichero
        if (comprobarExiste(new File(rutaCompletaFich1))) {
            leerDeFichero(nombreArchivo1);
        }

        // Paso g) Mostrar propiedades del primer fichero
        mostrarPropiedadesFichero(nombreArchivo1);

        // Paso h) Duplicar contenido del primer fichero al segundo
        duplicarFicheros(new File(rutaCompletaFich1), new File(rutaCompletaFich2));

        // Paso i) Borrar el primer fichero
        borrarFichero(new File(rutaCompletaFich1));

        // Paso j) Leer contenido del segundo fichero
        if (comprobarExiste(new File(rutaCompletaFich2))) {
            leerDeFichero(nombreArchivo2);
        }

        // Paso k) Crear directorio "dirEjer1"
        String nombreDirectorio = "dirEjer1";
        String rutaCompletaDirectorio = directorioActual + File.separator + nombreDirectorio;
        if (!comprobarExiste(new File(rutaCompletaDirectorio))) {
            crearDirectorio(nombreDirectorio);
        }
    }

    // Método para pedir nombre de archivo
    public static String pedirNombreArchivo(BufferedReader br) {
        String nombre = "";
        try {
            while (true) {
                System.out.print("Introduce el nombre del archivo: ");
                nombre = br.readLine();
                if (nombre.length() >= 3) {
                    System.out.println("El nombre del archivo " + nombre + " es válido.");
                    break;
                } else {
                    System.out.println("El nombre del archivo debe tener al menos 3 caracteres.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer desde la entrada estándar.");
        }
        return nombre;
    }

    // Método para crear un fichero
    public static boolean crearFichero(String nombreArchivo) {
        try {
            File fichero = new File(nombreArchivo);
            return fichero.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear el fichero.");
            return false;
        }
    }

    // Método para escribir en un fichero
    public static boolean escribirEnFichero(String nombreArchivo) {
        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            for (int i = 0; i <= 10; i++) {
                fw.write(String.valueOf(i) + "\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero.");
            return false;
        }
    }

    // Método para leer de un fichero
    public static boolean leerDeFichero(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
            return false;
        }
    }

    // Método para comprobar si un fichero existe
    public static boolean comprobarExiste(File fichero) {
        return fichero.exists();
    }

    // Método para mostrar propiedades de un fichero
    public static void mostrarPropiedadesFichero(String nombreArchivo) {
        File fichero = new File(nombreArchivo);
        if (fichero.exists()) {
            System.out.println("Nombre del archivo: " + fichero.getName());
            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
            System.out.println("Ruta del directorio padre: " + fichero.getParent());
            System.out.println("Tamaño del fichero: " + fichero.length() + " bytes");
            System.out.println("¿Es un fichero o un directorio?: " + (fichero.isFile() ? "Fichero" : "Directorio"));
            System.out.println("Permiso de lectura: " + (fichero.canRead() ? "Sí" : "No"));
            System.out.println("Permiso de escritura: " + (fichero.canWrite() ? "Sí" : "No"));
            System.out.println("Permiso de ejecución: " + (fichero.canExecute() ? "Sí" : "No"));
            System.out.println("¿Está oculto?: " + (fichero.isHidden() ? "Sí" : "No"));
        } else {
            System.out.println("El fichero no existe.");
        }
    }

    // Método para duplicar ficheros
    public static boolean duplicarFicheros(File origen, File destino) {
        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea + "\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al duplicar el fichero.");
            return false;
        }
    }

    // Método para borrar un fichero
    public static boolean borrarFichero(File fichero) {
        if (fichero.exists()) {
            return fichero.delete();
        } else {
            System.out.println("El fichero no existe.");
            return false;
        }
    }

    // Método para crear un directorio
    public static boolean crearDirectorio(String nombreDirectorio) {
        File directorio = new File(nombreDirectorio);
        return directorio.mkdir();
    }
}
