public class Vaquita {


  private String nombre;

  private final int litrosMaximo;

  private int litrosActual;

  public Vaquita(String nombre, int litrosMaximo){//Constructor por defecto

	  
	  this.nombre = nombre;
	  this.litrosActual = this.litrosMaximo = litrosMaximo;//Iguala el numero de litros actual y el maximo

  }

  public String getNombre() {//Devuelve el nombre de la vaca
	  
	  return nombre;
    
  }

  public int getLitros() {//Devuelve los litros de la vaca
   
	  return litrosActual;
  }

  
  public void ordeniar(int litros) throws VaquitaTieneHambre {//Ordeña la vaca.
  
	  if(litros <= litrosActual) litrosActual = litrosActual - litros;
	  else throw new VaquitaTieneHambre(nombre);//Su el numero de litrpos que se quiere ordeñar a la vaca es menor que los que tiene, se ordena, sino se lanza una excepcion personalizada
	  
	  
  }

  public void alimentar(int comida) {//Alimenta a la vaca tantas veces como comida haya.
	  
	  for(int  i = 0; i < comida && litrosActual < litrosMaximo; i++) litrosActual++; 

  }
}
