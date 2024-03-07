import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        Persona[] personas = {
            new Persona("Juan", 30, "Calle 123", "123456789"),
            new Persona("Ana", 25, "Avenida 456", "987654321"),
            new Persona("Pedro", 35, "Boulevard 789", "456123789")
        };

        escribirPersonas(personas);
        leerPersonas();
    }

    public static void escribirPersonas(Persona[] personas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.dat"))) {
            for (Persona persona : personas) {
                oos.writeObject(persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerPersonas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.dat"))) {
            while (true) {
                Persona persona = (Persona) ois.readObject();
                System.out.println(persona.getNombre());
            }
        } catch (EOFException e) {
            // Fin de archivo alcanzado
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}