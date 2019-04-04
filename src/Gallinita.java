public class Gallinita {


	  private int numero;

	  private final int huevosMaximo;

	  private int huevosActual;


	  public Gallinita(int i) {//Constructor por defecto
		  
		  numero = i;
		  huevosMaximo = huevosActual = 12;//Iguala el numero de huevos maximos, el actual, y el deseado por el user
	    
	  }

	  //PREGUTNAR DURA SOBRE HUEVS MAXIMOS Y ACTUALES
	  public Gallinita(int numero, int huevosMaximo) {//Constructor "sobrecargado" que define el numero maximo de huevos
		  
		  this.numero = numero;
		  this.huevosMaximo = huevosActual = huevosMaximo;
		  
	  }


	  public int getHuevos() {//devuelve el numero de huevos que le quedan
	    
		  return huevosActual;
		  
	  }


  public void recolectar() throws GallinitaTieneHambre {//Recolecta los huevos
	  
	  
	  int huevosARecojer = 6; // POR SI DESPUES QUEREMOS CAMBIAR EL VALOR DE HUEVOS QUE QUEREMOS RECOJER
	  
	  if(huevosActual == 0) throw new GallinitaTieneHambre(numero);//Si no hay huevos lanza una excepcion personalizada
	  else if(huevosActual <= huevosARecojer) huevosActual = 0;//Si el numero de huevos actual es menor o igual al que se quieren recojer, el actuar pasa a ser 0
	  else huevosActual = huevosActual - huevosARecojer;//Sino, al numero actual se le restan los 6
  }

  public void alimentar(int comida) {
	  
	  
	  for(int  i = 0; i < comida && huevosActual < huevosMaximo; i++) huevosActual++; //Alimenta a la gallina, tantas veces como comida haya
	  
  }
}
