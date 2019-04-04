import java.util.Random;

public class Granja {

  private static int posicionVaquita(String nombre, Vaquita [] vaquitas)
    throws IllegalArgumentException {
	  
	  int posicion = -1;
	  
	  	for(int i = 0; i < vaquitas.length && posicion == -1; i++ ){
	  		
	  		if(nombre.equals(vaquitas[i].getNombre())) posicion = i;
	  	}
	  	
	  	if(posicion == -1) throw new IllegalArgumentException();
	  	
	  	return posicion;

  }

  public static void main(String[] args) {


    Vaquita //Se definen las caracteristicas de cada tipo de vaca
      campanera = new Vaquita("Campanera" , 10),
      barrueca  = new Vaquita("Barrueca"  , 15),
      berraka   = new Vaquita("Berraka"   , 20);

    
    Vaquita [] vaquitas = {campanera, barrueca, berraka}; //Creo el array de vacas de los tres tipos

    final int numGallinitas = 7; //Se definen el numero de gallinas
 
    Gallinita [] gallinitas = new Gallinita [numGallinitas]; //Se crea el array de las gallinas
    
    for(int i = 0; i < numGallinitas; i++){//Se inicializa cada valor de cada gallina.
    	
    	if(i <= (numGallinitas/2)) gallinitas[i] = new Gallinita(i);//La mitad + 1, en caso impar, ponen 12 huevos
    	else gallinitas[i] = new Gallinita (i, 6);//El resto ponen 6 huevos
    	
    }


    Random  rng    = new Random();//se crea un objeto para crear numeros random
    int rondas = 3;//Se define el numero de rondas que el programa ejecutará

    while (rondas > 0) {//Se ejecuta un numero de rondas determinado anteriormente

      mostrarGranja(vaquitas,gallinitas);//Se invoca a la funcion "mostrarGranja()"

      int semilla = rng.nextInt(10) + 1;//Se genera un numero aleatorio entre 0 y 10 (incluidos) y se le suma uno, por si sale el numero 0(supongo).

      try { //Intenta ejecutar este codigo en caso de que no haya excepciones (EN ESTE CASO NO OBLIGATORIO PORQUE ESTA ARREGLADO)
    	  
    	  
    	  evitarExcepciones(vaquitas, gallinitas, semilla); //Invoca a un metodo que evita que aparezcan excepciones   	  
    	

        for (int i = 0; i < vaquitas.length; i++) //Ordeña a cada vaca "semiilla" litros.
        	
          vaquitas[i].ordeniar(semilla);

        for (int i = 0; i < gallinitas.length; i++)//Recolecta de cada gallina 6 huevos
        	
          gallinitas[i].recolectar();

        rondas--; //Acaba una ronda

      } catch (VaquitaTieneHambre e) {//Excepcion que se lanza cuando el numero de litros que se quiere ordeñar es menor que el que tiene la vaca (EN ESTE CASO NO OBLIGATORIO PORQUE ESTA ARREGLADO)

        System.out.println("EXCEPCION\t" + e);
        
        int pos = posicionVaquita(e.getNombre(), vaquitas);
        
        vaquitas[pos].alimentar(semilla);//Alimenta a la vaca semilla litros.
        
        System.out.println("\tAlimento: " + semilla);

      } catch (GallinitaTieneHambre e) {//Excepcion que se lanza cuando el numero de huevos que se quiere objetener es menor a los que la gallina tiene (EN ESTE CASO NO OBLIGATORIO PORQUE ESTA ARREGLADO)

        System.out.println("EXCEPCION\t" + e);
        
        gallinitas[e.getNumero()].alimentar(semilla);//Alimenta a la gallina semilla huevos.
        
        System.out.println("\tAlimento: " + semilla);
        
      }
    }
  }
  
  private static void evitarExcepciones(Vaquita [] vaquitas, Gallinita [] gallinitas, int semilla){//Controla que no existan excepciones
	  
	  for (int i = 0; i < vaquitas.length; i++)//Si la vaca tiene menos litros de los que se quieren ordeñar, se alimenta a la vaca hasta tener el minimo numero de litros para ser ordeñada
		  
  		if(vaquitas[i].getLitros() < semilla) vaquitas[i].alimentar(semilla - vaquitas[i].getLitros());
  		  
  	for (int i = 0; i < gallinitas.length; i++)//Si la gallina tiene menos huevos de los que se quieren recolectar, se alimenta hasta tener el minimo numero de huevos para recolectar
  		  
  		if(gallinitas[i].getHuevos() < 6 ) gallinitas[i].alimentar(6 - gallinitas[i].getHuevos());
  	  
	  
	  
	  
	  
  }

  private static void mostrarGranja(Vaquita [] vs, Gallinita [] gs) {//Muestra el estado de todos los animales que componen la granja

    System.out.println("Estado de la granja:");

    for (int i = 0; i < vs.length; i++)//Pinta el estado de cada vaca
    	
      System.out.println(" " + vs[i].getNombre() + ": " +
                          vs[i].getLitros() + " litros");
    

    for (int i = 0; i < gs.length; i++) {//Pinta el estado de cada gallina
    	
      System.out.println(" Gallinita " + i + ": " +
                         gs[i].getHuevos() + " huevos");
      

    }
  }
}
