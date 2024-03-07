import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private String dni;
    private double salario;

    public Persona(String nombre, int edad, String dni, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.salario = salario;
    }

    // Getters y setters
    
    public Persona(String nombre2, int edad2, String dni2, String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", salario=" + salario +
                '}';
    }

	public char[] getNombre() {
		return null;
	}
}