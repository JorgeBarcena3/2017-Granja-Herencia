public class GallinitaTieneHambre extends RuntimeException {
  private int numero;

  public GallinitaTieneHambre(int numero) { this.numero = numero; }

  public String toString() {
    return "La gallinita número " + this.numero + " tiene hambre";
  }

  public int getNumero() { return this.numero; }
}
