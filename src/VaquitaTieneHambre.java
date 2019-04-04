public class VaquitaTieneHambre extends RuntimeException {
	

private String nombre;

  public VaquitaTieneHambre(String nombre) { this.nombre = nombre; }

  public String toString() {
    return "La vaquita " + this.nombre + " tiene hambre";
  }

  public String getNombre() { return this.nombre; }
}
